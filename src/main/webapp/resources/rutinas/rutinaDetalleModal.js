//'use strict';

angular.module('myApp.rutinaDetalleModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('RutinaDetalleCtrl', ['$scope','$uibModalInstance','rutina', 'detalle', '$http','$route', function($scope, $uibModalInstance,rutina, detalle, $http, $route)
{
	$scope.detalles = [];
	$scope.ejercicios = [];
	$scope.maquinas = [];
	$scope.requestObject = {};
	$scope.selectedEjercicioRelation = {};
	$scope.selectedMaquinaHas = {};
	$scope.relationHas = [];
	$scope.maquinaHasEjercicios = {};
	$scope.rutinaDetalleForm = angular.copy(detalle);
	$scope.relation = [];
	$scope.reload = function(){
		$route.reload();
	};
   
	$scope.init = function() {
		$http.get('rest/protected/Ejercicios/getAll').then(function(response) {
			$scope.ejercicios = response.data.ejercicios;
			console.log("Ejercicios",$scope.ejercicios);
		});

		$http.get('rest/protected/Maquinas/getAll').then(function(response) {
			$scope.maquinas = response.data.maquinas;
		});

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;
		});

		$http.get('rest/protected/Maquinahasejercicios/all',$scope.requestObject).success(function(response) {
	    	$scope.maquinaHasEjercicios = response.maquinaEjercicio;
	    	console.log("Relation: ", $scope.maquinaHasEjercicios)
		});


	};

	$scope.init();

	$scope.findRelation = function() {
		$http.post('rest/protected/Maquinahasejercicios/find', {ejercicio: $scope.selectedEjercicioRelation}).success(function(response) {
	    	return response.maquinaEjercicio[0];
	    });
	};

	
    $scope.RutinaDetalleSchema = {
	  "type": "object",
	  properties: {
		cantidadPeso: { type: 'string', title: 'Peso' },
		cantidadRepeticiones: { type: 'string', title: 'Repeticiones' },
		cantidadSeries: { type: 'string', title: 'Series' }
	   }
	};
    
    $scope.form = [
		'cantidadPeso',
		{"title":"Peso",
		 "key" : "peso",
		 fieldHtmlClass: "text", 
		},
		'cantidadRepeticiones',
		{"title":"Repeticiones",
		 "key" : "repeticiones",
		 fieldHtmlClass: "text", 
		},
		'cantidadSeries',
		{"title":"Series",
		 "key" : "series",
		 fieldHtmlClass: "text", 
		},
	];
	  
    $scope.save = function () {
	    var dataDetalle = {};
	    $scope.selectedEjercicioRelation = $scope.maquinaHasEjercicios.find($scope.findTest);
	    console.log("Ejercicio seleccionado:",$scope.selectedEjercicioRelation);
	    dataDetalle = {
	      cantidadPeso : parseFloat($scope.rutinaDetalleForm.cantidadPeso),
	      plantillarutinamaestro : rutina,
	      cantidadRepeticiones : parseInt($scope.rutinaDetalleForm.cantidadRepeticiones),
	      cantidadSeries: parseInt($scope.rutinaDetalleForm.cantidadSeries),
	      maquinahasejercicio: $scope.selectedEjercicioRelation
	      
	    };
	    console.log("Data to be send", dataDetalle);
	    $http.post('rest/protected/plantillaDetalles/save', {plantillaRutinaDetalle: dataDetalle})
	    .then(function (response){

	       switch(response.data.code)
	       {
	         case 200:
	           alert(response.data.codeMessage);
	         break;

	         default:
	           alert(response.data.codeMessage);
	       }
			$scope.dismissModal = $scope.reload();
	    }, function (response){
	       alert("Error al crear el detalle de la rutina");
	    });
	    $uibModalInstance.close();   
	};

	$scope.findSelectedEjercicio = function(ejercicio) {
		return ejercicio.idEjercicio === $scope.requestObject.idEjercicio;
	};

	$scope.findTest = function(relation){
		return relation.ejercicio.idEjercicio === $scope.requestObject.idEjercicio;
	};
}]);
