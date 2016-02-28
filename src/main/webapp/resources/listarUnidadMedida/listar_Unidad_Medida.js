'use strict'

angular.module('myApp.listar_Unidad_Medida',['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listar_Unidad_Medida', {
	templateUrl: 'resources/listarUnidadMedida/listar_Unidad_Medida.html',
    controller: 'listarUnidadMedidaViewCtrl'
  });
}])

.controller('listarUnidadMedidaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.unidadesMedida = [];
	$scope.requestObject = {"idUnidadMedida":1,"descUnidadMedida":"","lugarmedicions":[]};
	
		$http.post('rest/protected/UnidadesMedidas/getAll',$scope.requestObject).success(function(response){
			console.log("response",response)
			$scope.unidadesMedida = response.unidadesMedida;
			console.log("$scope.unidadesMedida",$scope.unidadesMedida)		
		});	
}]);