'use strict';

angular.module('myApp.ocupacion', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ocupacion', {
    templateUrl: 'resources/ocupacion/ocupacion.html',
    controller: 'miOcupacionCtrl'
  });  
}])

.controller('miOcupacionCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {

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
	 $scope.ocupacionParqueo = {};
	 $scope.capacidadParqueo = {};
			 $http.post('rest/protected/ocupacionActualParqueo/getAll')
				.success(function(response) {
					$scope.ocupacionParqueo = response.ocupacion[0].ocupacionParqueo;
					$scope.capacidadParqueo = response.ocupacion[0].capacidad;
					   console.log(response,"OCUPACION ACTUAL PARQUEO");
	             });
	 $scope.ocupaciones = {};
	 		 $http.post('rest/protected/promedioOcupacion/getDiaHoraUsuario')
				.success(function(response) {
					console.log(response.nulo,"AQUI VERIFICA NULO");
					if(response.nulo==0){
						$scope.ocupaciones = response.ocupacion;
						console.log(response,"PRUeBAMORTAL");
					}else{
						$scope.promedioOcupacion = "";
					}
				});		 
	 $scope.ocupacionesParqueo = {};
	 		 $http.post('rest/protected/promedioOcupacionParqueo/getDiaHoraUsuario')
				.success(function(response) {
					$scope.ocupacionesParqueo = response.ocupacion;
					console.log(response,"PromedioOcupacionParqueo");
	             });
	 		 
	 $scope.promedioTotal = {};		 
	 		$http.post('rest/protected/promedioOcupacion/getDiaTotal')
			.success(function(response) {
				console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL");
				if(response.nulo==0){
					$scope.promedioTotal = response.ocupacion;
					console.log(response,"promedioTotal");
				}else{
					$scope.promedioTotal = "";
				}
			});		
	$scope.promedioTotalParqueo = {};		 
	$http.post('rest/protected/promedioOcupacionParqueo/getDiaTotal')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL PARQUEO");
		if(response.nulo==0){
			$scope.promedioTotalParqueo = response.ocupacion;
			console.log(response,"promedioTotalParqueo");
		}else{
			$scope.promedioTotalParqueo = "";
		}
	});				
	 		
}]);
