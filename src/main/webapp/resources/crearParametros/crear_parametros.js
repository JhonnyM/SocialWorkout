'use strict';

angular.module('myApp.crear_parametros', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/crear_parametros', {
    templateUrl: 'resources/crearParametros/crear_parametros.html',
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
	
$scope.saveParametro = function(event){
    	
    	var data = {};
    	data = {
    			nombreNegocio : $scope.requestObject.nombreNegocio,
    			cantidadDiasCalculoPromedios : $scope.requestObject.cantidadDiasCalculoPromedios
    	};
    	$http.post('rest/protected/parametro/create', data)
    	.success(function(data, status, config) {
            $scope.message = data;
          }).error(function(data, status, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        }); 
    };
    	
}]);

