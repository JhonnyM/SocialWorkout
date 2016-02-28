'use strict'

angular.module('myApp.registrar_Unidad_Medida',['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
	  $routeProvider
	  	.when('/registrar_Unidad_Medida', {
		templateUrl: 'resources/listarUnidadMedida/registrar_Unidad_Medida.html',
	    controller: 'registrarUnidadMedidaViewCtrl'
	  })
}])

.controller('registrarUnidadMedidaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.requestObject = {};
	$scope.requestObject.idUnidadMedida = 1;
	$scope.requestObject.descUnidadMedida = $scope.descUnidadMedida;
	$scope.requestObject.lugarmedicions = {idLugarMedicion:0,descLugarMedicion:"test"};
	$scope.working;
	
	$http.post('rest/protected/UnidadesMedidas/create',$scope.requestObject).success(function (response){
		console.log("response",response)
		$scope.working = response.nunidad
		console.log("$scope.working",$scope.working)
	});
}]);
