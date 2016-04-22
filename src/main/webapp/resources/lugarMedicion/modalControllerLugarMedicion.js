//'use strict';

angular.module('myApp.modalm', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalControllerLugarMedicion', ['$scope','$uibModalInstance','lugarMedicion', '$http','$route', function($scope, $uibModalInstance, lugarMedicion , $http, $route)
{
	$scope.form ={};
	$scope.unidadesMedidaList = [];
	$scope.requestObject = {};
	$scope.requestObject.idUnidadMedida = {};
	$scope.lugarMedicionForm = angular.copy(lugarMedicion);
	console.log($scope.lugarMedicionForm , "PUTA");
	$scope.reload = function(){
		 $route.reload();
		};

	
		 $http.get('rest/protected/UnidadesMedidas/getAll')
			.success(function(response) {
				    $scope.unidadList = response.unidadesMedidas;
				    $scope.requestObject.idUnidadMedida = $scope.lugarMedicionForm.unidadMedidaPOJO.idUnidadMedida;
				    console.log($scope.$scope.unidadList,"REQUEST-form");
				});
		 
	  
   
	
    $scope.PersonSchema = {
			  "type": "object",
			  properties: {
				descLugarMedicion: { type : 'string',
									 title : 'Descripción',
				                     validationMessage: 'Descripción de lugar inválido',
				                     pattern: "^[A-Za-z0-9 áéíóú.!=/-]+$",
				                     maxLength: 50
				                     }
			  },
			   	required : [
                'descLugarMedicion'
              ]
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
			$scope.valid = tv4.validate($scope.lugarMedicionForm, $scope.PersonSchema);
			
            if($scope.valid&&$scope.requestObject.idUnidadMedida>0){
				  $http.post('rest/protected/lugarMedicion/edit', {lugarMedicion : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
		
	    $uibModalInstance.close();
            }
	    
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
			$scope.valid = tv4.validate($scope.lugarMedicionForm, $scope.PersonSchema);
			if($scope.valid&&$scope.requestObject.idUnidadMedida>0){
				  $http.post('rest/protected/lugarMedicion/edit', {lugarMedicion : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
		
	    $uibModalInstance.close();
            }
      };
}]);
