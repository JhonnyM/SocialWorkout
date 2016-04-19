'use strict';

angular.module('myApp.ocupacionMaquinas', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ocupacionMaquinas', {
    templateUrl: 'resources/ocupacionMaquinas/ocupacionMaquinas.html',
    controller: 'miOcupacionMaquinasCtrl'
  });  
}])

.controller('miOcupacionMaquinasCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {

	
	$scope.usuario = {};
	 $http.post('rest/protected/users/usuarioSet')
		.success(function(response) {
			$scope.usuario = response.usuario;
			 console.log(response.usuario,"USUARIO");
		});
	$scope.ocupacion = {};
	$scope.capacidad = {};
		 $http.post('rest/protected/ocupacionActual/getAll')
			.success(function(response) {
				$scope.ocupacion = response.ocupacion[0].ocupacionGimnasio;
				$scope.capacidad = response.ocupacion[0].capacidad;
				   console.log(response.ocupacion,"OCUPACION ACTUAL");
			});
	
	$scope.promedioTotalMaquinas = {};		 
	$http.post('rest/protected/promedioRutinasMaquina/getMaquinasUsuario')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL PARQUEO");
		if(response.nulo==0){
			$scope.promedioTotalMaquinas = response.ocupacion;
			console.log(response,"MAQUINAS");
		}else{
			$scope.promedioTotalMaquinas = "";
		}
	});	
	
	$scope.promedioDiaMaquinas = {};		 
	$http.post('rest/protected/promedioRutinasMaquina/getDiaTotal')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA NULO MAQUINAS X DIA");
		if(response.nulo==0){
			$scope.promedioDiaMaquinas = response.ocupacion;
			console.log(response,"MAQUINAS TODO EL DIA");
		}else{
			$scope.promedioDiaMaquinas = "";
		}
	});	
	 		
}]);
