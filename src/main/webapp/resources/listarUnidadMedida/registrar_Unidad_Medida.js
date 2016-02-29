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

	$scope.saveUnidadMedida = function(event){
		
		var data = {};
		
		data = {
				//idUnidadMedida: 0,
				descUnidadMedida : $scope.requestObject.descUnidadMedida			
		};

        console.log("$scope.data",$scope.data)
		$http.post('rest/protected/UnidadesMedidas/create', data)
		.success(function(data, status, config) {
	        $scope.message = data;

	      }).error(function(data, status, config) {
  	        console.log("$scope.data",$scope.data)
	    	  alert( "failure message: " + JSON.stringify({data: data}));
	    }); 
	};
	
}]);


