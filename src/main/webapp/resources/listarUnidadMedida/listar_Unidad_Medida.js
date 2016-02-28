'use strict'

angular.module('myApp.listar_Unidad_Medida',['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  	.when('/listar_Unidad_Medida', {
	templateUrl: 'resources/listarUnidadMedida/listar_Unidad_Medida.html',
    controller: 'listarUnidadMedidaViewCtrl'
  })
  
	.when('/registrar_Unidad_Medida', {
		templateUrl: 'resources/listarUnidadMedida/registrar_Unidad_Medida.html',
	    controller: 'registrarUnidadMedidaViewCtrl'
	  });
  
}])

.controller('listarUnidadMedidaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.unidadesMedida = [];
	$scope.requestObject = {"idUnidadMedida":1,"descUnidadMedida":"","lugarmedicions":[]};
	
		$http.post('rest/protected/UnidadesMedidas/getAll',$scope.requestObject).success(function(response){
			console.log("response",response)
			$scope.unidadesMedida = response.unidadesMedidas;
			console.log("$scope.unidadesMedida",$scope.unidadesMedida)		
		});	
}]);

myApp.controller('registrarUnidadMedidaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.requestObject = {};
	$scope.requestObject.idUnidadMedida = 1;
	$scope.requestObject.descUnidadMedida = $scope.descUnidadMedida;
	$scope.requestObject.lugarmedicions = {};
	$scope.working;
	
	$http.post('rest/protected/UnidadesMedidas/create',$scope.requestObject).success(function (response){
		console.log("response",response)
		$scope.working = response.nunidad
		console.log("$scope.working",$scope.working)
	});
}]);

