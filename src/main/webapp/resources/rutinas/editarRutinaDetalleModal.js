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

		});

		$http.get('rest/protected/Maquinas/getAll').then(function(response) {
			$scope.maquinas = response.data.maquinas;

		});

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;

		});


		$http.get('rest/protected/Maquinahasejercicios/all',$scope.requestObject).success(function(response) {
	    	$scope.maquinaHasEjercicios = response.maquinahasejercicio;

		});

		$scope.rutinaDetalleForm = angular.copy(detalle);


	};

	$scope.init();
	
    $scope.RutinaDetalleSchema = {
	  "type": "object",
	  properties: {
		cantidadPeso: { 
			type: 'number', 
			title: 'Peso',
            minimum : 0,
			pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
            validationMessage: 'Peso no válido'
		},
		cantidadRepeticiones: { 
			type: 'number', 
			title: 'Repeticiones',
			minimum : 0,
			pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
            validationMessage: 'Repeticiones no válidas' 
		},
		cantidadSeries: { 
			type: 'number', 
			title: 'Series',
			minimum : 0,
			pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
            validationMessage: 'Series no válidas' 
		}
	   },
	   required: ['cantidadPeso', 'cantidadRepeticiones', 'cantidadSeries']
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
	    $scope.valid = tv4.validate($scope.rutinaDetalleForm, $scope.RutinaDetalleSchema);
		if($scope.valid){
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
		}
		$scope.valid = false;  
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
