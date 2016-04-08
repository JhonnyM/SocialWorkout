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
	  		idEvento : $scope.eventoForm.idEvento,
			descEvento : $scope.eventoForm.descEvento,
			fechaHoraInicio: $scope.eventoForm.fechaHoraInicio,
			fechaHoraFinal: $scope.eventoForm.fechaHoraFinal,
			observaciones: $scope.eventoForm.observaciones
	  	};
		$http.post('rest/protected/eventos/update',{evento: data})
		.then(function (response){
	      switch(response.data.code)
	      {
	        case 200:
	          alert(response.data.codeMessage);
	        break;
	        default:
	          alert(response.data.codeMessage);
	      }
	    }, function (response){
	      alert("Error al guardar la información de el nuevo evento");
	    });
	};
}]);
