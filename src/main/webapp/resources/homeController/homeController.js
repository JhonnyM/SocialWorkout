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
	$scope.visorCliente = {};
	 $http.post('rest/protected/users/usuarioSet')
		.success(function(response) {
			$scope.usuario = response.usuario;
			$scope.descTipoUsuario = response.usuario.tipoUsuarioPOJO.descTipoUsuario;
			if ($scope.descTipoUsuario == "Cliente"){
				$scope.visorCliente = "false"
			}
			 console.log(response.usuario+$scope.visorCliente,"USUARIO");
		});
}]);
