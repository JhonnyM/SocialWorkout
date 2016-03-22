'use strict';

angular.module('myApp.ocupacion', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ocupacion', {
    templateUrl: 'resources/ocupacion/ocupacion.html',
    controller: 'miOcupacionCtrl'
  });  
}])

.controller('miOcupacionCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {

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
	 $scope.PromedioOcupacion = {};
	 		 $http.post('rest/protected/promedioOcupacion/getDia')
				.success(function(response) {
					$scope.PromedioOcupacion = response.ocupacion[0].ocupacionParqueo;
					console.log(response,"PRUBAMORTAL");
	             });		 
	 $scope.PromedioOcupacionParqueo = {};
	 		 $http.post('rest/protected/promedioOcupacionParqueo/getAll')
				.success(function(response) {
					$scope.PromedioOcupacionParqueo = response.ocupacion[0].ocupacionParqueo;
					console.log(response,"PromedioOcupacionParqueo");
	             });     
}]);
