'use strict';

angular.module('myApp.home', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/homeController', {
    templateUrl: 'WEB-INF/views/home.html',
    controller: 'homeCtrl'
  });  
}])

.controller('homeCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {

	
	$scope.usuario = {};
	$scope.descTipoUsuario = {};
	$scope.mostrarCliente = false;
	$scope.mostrarInstructor = false;
	$scope.mostrarAdministrador = false;
	 $http.post('rest/protected/users/usuarioSet')
		.success(function(response) {
			$scope.usuario = response.usuario;
			$scope.descTipoUsuario = response.usuario.tipoUsuarioPOJO.descTipoUsuario;
			if ($scope.descTipoUsuario == "Cliente"){
				$scope.mostrarCliente = true
			}
			if ($scope.descTipoUsuario == "Instructor"){
				$scope.mostrarInstructor = true
			}
			if ($scope.descTipoUsuario == "Administrador"){
				$scope.mostrarAdministrador = true
			}
			console.log($scope.mostrarCliente,"CLIENTE"); 
			console.log($scope.mostrarInstructor,"INSTRUCTOR"); 
			console.log($scope.mostrarAdministrador,"ADMINISTRADOR"); 
		});
}]);
