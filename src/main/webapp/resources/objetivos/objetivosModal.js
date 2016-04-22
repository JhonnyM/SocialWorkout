//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('ObjetivosModal', ['$scope','$http','$uibModalInstance','objetivo','$route',  function($scope,$http,$uibModalInstance,objetivo,$route)
{
	$scope.reload = function() {
    	$route.reload();
  	};

	$scope.ObjetivoSchema = {
	  "type": "object",
	  properties: {
		descObjetivo: { 
		  				type: 'string', 
		  				title: 'Descripción',
		  				validationMessage: 'Descripción del objetivo inválido',
	                	pattern: "^[A-Za-z áéíóú.!=/-]+$", 
	                	maxLength: 50
		  			}

	  	},
	  	required : ['descObjetivo' ]
	};
    
	$scope.objetivoForm = angular.copy(objetivo);
	
    $scope.form = [
		'descObjetivo'
	];
	  
	$scope.save = function() {
		  
	  $scope.data = {};

	  data = {
	  	idObjetivo : $scope.objetivoForm.idObjetivo,
		descObjetivo : $scope.objetivoForm.descObjetivo
	  };
	  $scope.valid = tv4.validate($scope.objetivoForm, $scope.ObjetivoSchema);
		if($scope.valid){
			$http.post('rest/protected/objetivos/edit',data).success(
				function(data, status, config) {
				$scope.message = data;
				$scope.dismissModal = $scope.reload();
				}).error(
				function(data, status, config) {
				  alert("failure message: "+ JSON.stringify({data : data}));
			});
			$uibModalInstance.close();
		}
		$scope.valid = false;	
	};

}]);
