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
	$scope.rutinaDetalleForm = angular.copy(detalle);
	$scope.reload = function(){
		$route.reload();
	};
   
	$scope.init = function() {
		$http.get('rest/protected/Ejercicios/getAll').then(function(response) {
			$scope.ejercicios = response.data.ejercicios;
		});

		$http.get('rest/protected/Maquinas/getAll').then(function(response) {
			$scope.maquinas = response.data.maquinas;
			for(i=0; i < $scope.maquinas.length; i++){
				if($scope.maquinas[i].maquinahasejercicios.length > 0){
					$scope.relationHas.push($scope.maquinas[i]);
				}

			}
		});

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;
		});


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
	    selectedEjercicioRelation = $scope.ejercicios.find($scope.findSelectedEjercicio);
	    selectedMaquinaHas = $scope.relationHas.find($scope.findMaquinaHasEjercicio);
	    dataDetalle = {
	      cantidadPeso : parseFloat($scope.rutinaDetalleForm.cantidadPeso),
	      plantillarutinamaestro : rutina,
	      cantidadRepeticiones : parseInt($scope.rutinaDetalleForm.cantidadRepeticiones),
	      cantidadSeries: parseInt($scope.rutinaDetalleForm.cantidadSeries),
	      maquinahasejercicio: selectedMaquinaHas.maquinahasejercicios[0]
	      
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

	$scope.findMaquinaHasEjercicio = function(maquinaHasEjercicio) {
		return maquinaHasEjercicio.maquinahasejercicios.idEjercicioXMaquina === selectedEjercicioRelation.maquinahasejercicios.idEjercicioXMaquina;

	}

	$scope.findSelectedEjercicio = function(ejercicio) {
		return ejercicio.idEjercicio === $scope.requestObject.idEjercicio;
	}

}]);
