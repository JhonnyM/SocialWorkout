'use strict'

angular.module('myApp.registrar_Maquina',
		['ngRoute', 'ui.bootstrap'])
.config(['$routeProvider', function($routeProvider) {
	  $routeProvider
	  	.when('/registrar_Maquina', {
		templateUrl: 'resources/listarMaquina/registrar_Maquina.html',
	    controller: 'registrarMaquinaViewCtrl'
	  })
}])

.controller('registrarMaquinaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.requestObject = {};	

	$scope.saveMaquina = function(event){
		
		var data = {};
		
		data = {
				cantidad : $scope.requestObject.cantidad,
				descMaquina : $scope.requestObject.descMaquina,
				minutosXPersona : $scope.requestObject.minutosXPersona,
				personasXMaquina : $scope.requestObject.personasXMaquina
		};

        console.log("$scope.data",$scope.data)
		$http.post('rest/protected/Maquinas/create', data)
		.success(function(data, status, config) {
	        $scope.message = data;

	      }).error(function(data, status, config) {
  	        console.log("$scope.data",$scope.data)
	    	  alert( "failure message: " + JSON.stringify({data: data}));
	    }); 
	};
	
	
}]);

