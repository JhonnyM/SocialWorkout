'use strict';

angular.module('myApp.listar_parametros', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listar_parametros', {
    templateUrl: 'resources/listarParametros/listar_parametros.html',
    controller: 'ParametroCtrlLst'
  });
}])

.controller('ParametroCtrlLst', ['$scope','$http',function($scope,$http) {
	$scope.parametros = [];
	$scope.requestObject = {"nombreNegocio": "Matrix", "cantidadDiasCalculoPromedios": 5};
	$http.post('rest/protected/parametro/getAll',$scope.requestObject)
		.success(function(response) {
		console.log("response",response)
		$scope.parametros = response.parametros;
		
		console.log("$scope.parametros",$scope.gridOptions)
		
	});
	
	$scope.gridOptions = {
			data:'parametros',
			showGroupPanel: true,
			enableSorting:true,
			enableFiltering:true,
			columnDefs:[{field:'nombreNegocio', displayName:'Gym'}, {field:'cantidadDiasCalculoPromedios', displayName:'Cantidad Dias'}]
	
	};
	
	
}]);