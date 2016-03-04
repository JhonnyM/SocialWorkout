//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('ModalController', ['$scope','$http','$uibModalInstance','unidadMedida',  function($scope,$http,$uibModalInstance,unidadMedida)
{
	$scope.unidadMedidaSchema = {
			  "type": "object",
			  properties: {
				  descUnidadMedida: { type: 'string', title: 'Descripción'}
			  }
			};
    
	$scope.unidadMedidaForm = angular.copy(unidadMedida);

    console.log("me dieron click dentro del modal",$scope.unidadMedidaForm.idUnidadMedida);	
    console.log("me dieron click dentro del modal",$scope.unidadMedidaForm.descUnidadMedida);
	
    $scope.form = [
		'descUnidadMedida'
	];
	  
	  $scope.save = function() {

    	  $scope.data = {};
		  data = {
				  idUnidadMedida : $scope.unidadMedidaForm.idUnidadMedida,
				  descUnidadMedida : $scope.unidadMedidaForm.descUnidadMedida
		  };

		  console.log("$scope.data", $scope.data)
		  $http.post(
				  'rest/protected/UnidadesMedidas/edit',data).success(
						  function(data, status, config) {
							  $scope.message = data;
						  }).error(
								  function(data, status, config) {
									  console.log("$scope.data",$scope.data)
											  alert("failure message: "+ JSON.stringify({data : data}));
								  });
	  };
}]);