'use strict';

angular.module('myApp.loginView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'resources/loginView/loginView.html',
    controller: 'LoginViewCtrl'
  });
}])

.controller('LoginViewCtrl', ['$scope','$http',function($scope,$http) {
	$scope.user = {correoElectronico:"culloat@ucenfotec.ac.cr",clave:"12345"};
	
	$scope.checkLogin = function(){
		
    	$http.post('rest/login/checkuser/',$scope.user).success(function (loginResponse) {

    		if(loginResponse.code == 200){
    			var usuario = {"idUsuario":loginResponse.idUsuario,"nombre":loginResponse.nombre,"apellido":loginResponse.apellidos};
    			var path = "/socialWorkout/app#/usuariosAdministrador";
    			window.location.href = path;
    		}else{
    			alert("invalido");
    		}
    	});
    	
    };
}]);