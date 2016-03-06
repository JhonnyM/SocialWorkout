//'use strict';

angular.module('myApp.EventosModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('EventosModalCtrl', ['$scope','$http','$uibModalInstance','evento',  function($scope,$http,$uibModalInstance,evento)
{

	$scope.EventoSchema = {
	  "type": "object",
	  properties: {
		  descObjetivo: { type: 'string', title: 'Descripción'}
	  	}
	};
    
	$scope.eventoForm = angular.copy(evento);
	
    $scope.form = [
		'descObjetivo'
	];
	  
	$scope.save = function() {
		  
	  $scope.data = {};

	  data = {
	  	idObjetivo : $scope.eventoForm.idObjetivo,
		descObjetivo : $scope.eventoForm.descObjetivo
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
