//'use strict';

angular.module('myApp.modalEditarRutinaMaestro', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('EditarRutinaMaestroCtrl', ['$scope','$uibModalInstance','rutina', '$http','$route', function($scope, $uibModalInstance,rutina, $http, $route)
{
	$scope.objetivos = [];
	$scope.rutinas = [];
	$scope.requestObject = {};
	$scope.rutinaForm = angular.copy(rutina);
	$scope.reload = function(){
		$route.reload();
	};
   
	$scope.init = function() {

		$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	    	$scope.objetivos = response.objetivoList;
	    	console.log("$scope.objetivos", $scope.objetivos)
		});
	};

	$scope.init();
	
    $scope.RutinaSchema = {
	  "type": "object",
	  properties: {
		descRutina: { type: 'string', title: 'Descripcion' },
	   }
	};
    
    $scope.form = [
		'descRutina',
		{"title":"Descripcion",
		 "key" : "descripcion",
		 fieldHtmlClass: "text", 
		},	
	];
	  
    $scope.save = function () {
	    var data = {};
	    var userToSave = {};
	    var objetivoToSave = {};
	    objetivoToSave = $scope.objetivos.find($scope.findObjetivo);
	    data = {
	   	  idRutina: $scope.rutinaForm.idRutina,
	      objetivo : objetivoToSave,
	      descRutina : $scope.rutinaForm.descRutina,
	      rutinaBase : true
	    };
	    console.log(data);
	    console.log($scope.rutinaForm);
	    $http.post('rest/protected/plantillas/update', {plantillaRutinaMaestro: data})
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
	       alert("Error al crear la rutina");
	    });
	    $uibModalInstance.close();   
	};

	$scope.findObjetivo = function (objetivo) { 
    	return objetivo.idObjetivo === $scope.requestObject.idObjetivo;
  	};

  	$scope.create = function(event){
	  $scope.data = {};
  	};
}]);
