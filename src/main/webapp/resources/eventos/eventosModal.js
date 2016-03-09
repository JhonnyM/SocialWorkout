//'use strict';

angular.module('myApp.eventosModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('EventosModalCtrl', ['$scope','$http','$uibModalInstance','evento',  function($scope,$http,$uibModalInstance,evento)
{

	$scope.EventoSchema = {
	  "type": "object",
	  properties: {
		  descEvento: { type: 'string', title: 'Descripción'},
		  fechaHoraInicio: { title: 'Fecha de Inicio'},
		  fechaHoraFinal: {  title: 'Fecha Final'},
		  observaciones: { type: 'string', title: 'Observaciones'}
	  	}
	};
    
	$scope.eventoForm = angular.copy(evento);
	
    $scope.form = [
		'descEvento',
		{"key": "fechaHoraInicio",
		 "type": "date",
		},
		{"key": "fechaHoraFinal",
	     "type": "date",
		},
		'observaciones'
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
