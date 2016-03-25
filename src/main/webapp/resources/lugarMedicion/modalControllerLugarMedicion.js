//'use strict';

angular.module('myApp.modalm', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalControllerLugarMedicion', ['$scope','$uibModalInstance','lugarMedicion', '$http','$route', function($scope, $uibModalInstance, lugarMedicion , $http, $route)
{
	$scope.UnidadesMedidaList = [];

	$scope.requestObject = {};
	$scope.lugarMedicionForm = angular.copy(lugarMedicion);
	$scope.reload = function(){
		 $route.reload();
		};

	$scope.init = function() {
		 $http.post('rest/protected/UnidadesMedidas/getAll')
			.success(function(response) {
				    $scope.unidadesList = response.unidadesMedidas;
				    $scope.requestObject.idUnidadMedida = $scope.lugarMedicionForm.unidadMedidaPOJO.idUnidadMedida;
				    console.log($scope.lugarMedicionForm,"REQUEST-form");
				});
		 
	    };
	    
    
    
	$scope.init();
	
    $scope.PersonSchema = {
			  "type": "object",
			  properties: {
				descLugarMedicion: { type: 'string', title: 'Descripción' },
			    unidadMedida: { type: 'string', title: 'Unidad de medida' },
			   }
			};
    
	$scope.form = [
	{"title":"Descripción",
	 "key" : "descLugarMedicion",
	},	
	];
	  
    	$scope.save = function () {
    		console.log($scope.requestObject.idUnidadMedida,"IDLUGARMEDICION");
    		$scope.data = {};
			data = {
			  	idLugarMedicion : $scope.lugarMedicionForm.idLugarMedicion,
			  	descLugarMedicion : $scope.lugarMedicionForm.descLugarMedicion,
                unidadMedidaPOJO : {
                	idUnidadMedida : $scope.requestObject.idUnidadMedida,
                	descUnidadMedida : ''
                },
			   
            };
			  //console.log(data.idUsuario);
				  $http.post('rest/protected/lugarMedicion/edit', {lugarMedicion : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
		
	    $uibModalInstance.close();
	   
	    
	  };
      $scope.create = function(event){
    		console.log($scope.requestObject.idUnidadMedida,"IDLUGARMEDICION");
    		$scope.data = {};
			data = {
			  	idLugarMedicion : '',
			  	descLugarMedicion : $scope.lugarMedicionForm.descLugarMedicion,
                unidadMedidaPOJO : {
                	idUnidadMedida : $scope.requestObject.idUnidadMedida,
                	descUnidadMedida : ''
                },
			   
            };
			  //console.log(data.idUsuario);
				  $http.post('rest/protected/lugarMedicion/edit', {lugarMedicion : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
		
	    $uibModalInstance.close();
	   
      };
}]);
