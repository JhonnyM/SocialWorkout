//'use strict';

angular.module('myApp.editarRutinaDetalleModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('EditarRutinaDetalleCtrl', ['$scope','$uibModalInstance','rutina', 'detalle', '$http','$route', function($scope, $uibModalInstance,rutina, detalle, $http, $route)
{
	$scope.detalles = [];
	$scope.ejercicios = [];
	$scope.maquinas = [];
	$scope.requestObject = {};
	$scope.selectedEjercicioRelation = {};
	$scope.selectedMaquinaHas = {};
	$scope.relationHas = [];
	$scope.relationHas = [];
	$scope.maquinaHasEjercicios = {};
	//$scope.rutinaDetalleForm = angular.copy(detalle);
	$scope.relation = [];
	$scope.reload = function(){
		$route.reload();
	};
   
	$scope.init = function() {
		$http.get('rest/protected/Ejercicios/getAll').then(function(response) {
			$scope.ejercicios = response.data.ejercicios;
			console.log("Ejercicios: CHRIS",$scope.ejercicios);
		});

		$http.get('rest/protected/Maquinas/getAll').then(function(response) {
			$scope.maquinas = response.data.maquinas;
			console.log("MAQUINAS: CHRIS", $scope.maquinas)
		});

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;
	    	console.log("OBJETIVOS CHRIS", $scope.objetivos)
		});


		$http.get('rest/protected/Maquinahasejercicios/all',$scope.requestObject).success(function(response) {
	    	$scope.maquinaHasEjercicios = response.maquinahasejercicio;
	    	console.log("MAQUINASHASEJERCICIOS: CHRIS", $scope.maquinaHasEjercicios)
		});

		$scope.rutinaDetalleForm = angular.copy(detalle);


	};

	$scope.init();
	
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
	    selectedEjercicioRelation = $scope.maquinaHasEjercicios.find($scope.findTest);
	    console.log("Ejercicios:",selectedEjercicioRelation);
	    dataDetalle = {
	      idPLantillaRutinaDetalle: $scope.rutinaDetalleForm.idPLantillaRutinaDetalle,
	      cantidadPeso : parseFloat($scope.rutinaDetalleForm.cantidadPeso),
	      plantillarutinamaestro : rutina,
	      cantidadRepeticiones : parseInt($scope.rutinaDetalleForm.cantidadRepeticiones),
	      cantidadSeries: parseInt($scope.rutinaDetalleForm.cantidadSeries),
	      maquinahasejercicio: selectedEjercicioRelation
	      
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

	// $scope.requestRelation = function(ejercicio){
	// 	$http.post('rest/protected/Maquinahasejercicios/find', {ejercicio: ejercicio}).success(function(response) {
	//     	$scope.relation = response.maquinaEjercicio;
	// 	});

	// };

	$scope.findTest = function(relation){
		return relation.ejercicio.idEjercicio === $scope.requestObject.idEjercicio;
	};

}]);
