//'use strict';

angular.module('myApp.rutinaDetalleModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('RutinaDetalleCtrl', ['$scope','$uibModalInstance','rutina', 'detalle', '$http','$route', function($scope, $uibModalInstance,rutina, detalle, $http, $route)
{
	$scope.detalles = [];
	$scope.requestObject = {};
	$scope.rutinaDetalleForm = angular.copy(detalle);
	$scope.reload = function(){
		$route.reload();
	};
   
	$scope.init = function() {
	    // $http.get('rest/protected/plantillas/all').success(function(response) {
	    // 	$scope.rutinas = response.plantillas;
	    // 	console.log($scope.rutinas);
	    // }, function(){
	    //   	alert("Error obteniendo la informacion de las rutinas");
	    // });

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;
	    	console.log("$scope.objetivos", $scope.objetivos)
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
	    dataDetalle = {
	      cantidadPeso : parseFloat($scope.rutinaDetalleForm.cantidadPeso),
	      plantillarutinamaestro : rutina,
	      cantidadRepeticiones : parseInt($scope.rutinaDetalleForm.cantidadRepeticiones),
	      cantidadSeries: parseInt($scope.rutinaDetalleForm.cantidadSeries),
	      maquinahasejercicio: {}
	      
	    };
	    console.log(dataDetalle);
	    console.log($scope.rutinaDetalleForm);
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

}]);
