'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/parametroView', {
    templateUrl: 'resources/paametroView/listarParametros.html',
    controller: 'ParametroCtrl'
  });
}])

.controller('ParametroCtrl', ['$scope','$http',function($scope,$http) {
	$scope.parametros = [];
	$scope.requestObject = {"nombreNegocio": "Matrix", "cantidadDiasCalculoPromedios": 5};
	$http.post('rest/protected/parametro/getAll',$scope.requestObject).success(function(response) {
		console.log("response",response)
		$scope.parametros = response.parametros;
		console.log("$scope.parametros",$scope.parametros)
		
	});
	
}]);