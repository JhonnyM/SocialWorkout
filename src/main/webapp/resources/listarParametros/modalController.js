//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])


.controller('ModalController', ['$scope','$uibModalInstance','parametro',  function($scope, $uibModalInstance, parametro)
{
	$scope.ParametroSchema = {
			  "type": "object",
			  properties: {
				  
				  nombreNegocio: { type: 'string', title: 'Gimnasio' },
				  cantidadDiasCalculoPromedios: { type: 'number', title: 'Cantidad dias' }
			  }
			};
    
	$scope.parametroForm = angular.copy(parametro);
	
    	$scope.form = [
		'nombreNegocio',
		'cantidadDiasCalculoPromedios'
	  ];
	  
	  
	  $scope.save = function () {
		  
	    // Copy row values over
		  parametro.cantidadDiasCalculoPromedios = $scope.parametroForm.cantidadDiasCalculoPromedios;
		  parametro.nombreNegocio = $scope.parametroForm.nombreNegocio;
	   
	    $uibModalInstance.close();
	  }
    
}]);
