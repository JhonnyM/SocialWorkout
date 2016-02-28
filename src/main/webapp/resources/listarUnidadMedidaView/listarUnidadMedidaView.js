'use strict'

angular.module('myApp.listarUnidadMedidaView',['ng-route'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listarUnidadMedida', {
    templateUrl: 'resources/listarUnidadMedidaView/listarUnidadMedidaView.html',
    controller: 'listarUnidadMedidaViewCtrl'
  });
}])

.controller('listarUnidadMedidaView',['$scope','$http',function($scope,$http){
	$scope.unidadesMedida = [];
	$scope.requestObject = {"idUnidadMedida":0,"descUnidadMedida":"","lugarmedicions":{}};				
	$http.post('rest/protected/UnidadesMedidas',$scope.requestObject).success(function(response){

		console.log("response",response)
		$scope.unidadesMedida = response.unidadesMedida;
		console.log("$scope.unidadesMedida",$scope.unidadesMedida)
	});			
}]);