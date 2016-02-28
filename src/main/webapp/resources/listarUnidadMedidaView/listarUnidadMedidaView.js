'use strict'

angular.module('myApp.listarUnidadMedidaView',[])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listarUnidadMedida', {
    templateUrl: 'resources/listarUnidadMedidaView/listarUnidadMedidaView.html',
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