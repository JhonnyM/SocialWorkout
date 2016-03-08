//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('ObjetivosModal', ['$scope','$http','$uibModalInstance','objetivo',  function($scope,$http,$uibModalInstance,objetivo)
{

	$scope.ObjetivoSchema = {
	  "type": "object",
	  properties: {
		  descObjetivo: { type: 'string', title: 'Descripción'}
	  	}
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

		console.log("$scope.data", $scope.data)
		$http.post('rest/protected/objetivos/edit',data).success(
			function(data, status, config) {
			$scope.message = data;
			}).error(
			function(data, status, config) {
			  alert("failure message: "+ JSON.stringify({data : data}));
			});
	  	};
}]);
