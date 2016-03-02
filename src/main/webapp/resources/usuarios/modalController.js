//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])


.controller('ModalController', ['$scope','$uibModal','usuario', function($scope, $uibModal,usuario)
{
	$scope.PersonSchema = {
			  type: 'object',
			  properties: {
			    nombre: { type: 'string', title: 'Nombre' },
			    correoElectronico: { type: 'string', title: 'Email' },
			    estatus: { type: 'string', title: 'Habilitado' },
			    
			  }
			};
    $scope.usuario = usuario;
    console.log("me dieron click dentro del modal",usuario.nombre);
	
 
    $scope.cancel = function () 
    {
    	$uibModal.dismiss('cancel');
    };
    
    
      var vm = this;
	  vm.schema = $scope.PersonSchema;
	  vm.entity = usuario;
	  $scope.form = [
	    'nombre',
	    'correoElectronico',
	    'estatus',
	  ];
	  
	  vm.save = save;
	  
	  function save() {
	    // Copy row values over
	    row.entity = angular.extend(row.entity, vm.entity);
	    $modalInstance.close(row.entity);
	  }
    
}]);
