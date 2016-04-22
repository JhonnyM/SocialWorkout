//'use strict';

angular.module('myApp.eventosModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('EventosModalCtrl', ['$scope','$http','$uibModalInstance','evento','$route',  function($scope,$http,$uibModalInstance,evento, $route)
{
	$scope.reload = function() {
    	$route.reload();
  	};

	$scope.EventoSchema = {
	  "type": "object",
	  properties: {
		  descEvento: { 
	  					type: 'string', 
	  					title: 'Descripción', 
	  					validationMessage: 'Descripción de evento inválido',
	                	pattern: "^[A-Za-z áéíóú.!=/-]+$", 
	                	maxLength: 50
		            },
		  fechaHoraInicio: { 

		  					title: 'Fecha de Inicio'
		  				},
		  fechaHoraFinal: {  

		  					title: 'Fecha Final'
		  				},
		  observaciones: { 

	  					   	type: 'string', 
	  					   	title: 'Observaciones',
	  					   	validationMessage: 'Observaciones de evento inválido',
		                   	pattern: "^[A-Za-z áéíóú.!=/-]+$", 
		                	maxLength: 50
		  				}
	  	},
	  	required : ['descEvento', 'fechaHoraInicio', 'fechaHoraFinal', 'observaciones' ]
	};
    
	$scope.eventoForm = angular.copy(evento);


	$scope.reload = function(){
    	$route.reload();
  	};
	
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
	  	$scope.valid = tv4.validate($scope.eventoForm, $scope.EventoSchema);
			if($scope.valid){
				$http.post('rest/protected/eventos/update',{evento: data})
				.then(function (response){
			      switch(response.data.code)
			      {
			        case 200:
			          alert(response.data.codeMessage);
			          $scope.dismissModal = $scope.reload();
			        break;
			        default:
			          alert(response.data.codeMessage);
			          $scope.dismissModal = $scope.reload();
			      }
			    }, function (response){
			      alert("Error al guardar la información de el nuevo evento");
			    });
			    $uibModalInstance.close();
		} 
		$scope.valid = false;
	};
}]);
