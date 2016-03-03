//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])


.controller('ModalController', ['$scope','$uibModalInstance','usuario',  function($scope, $uibModalInstance,usuario)
{
	$scope.PersonSchema = {
			  "type": "object",
			  properties: {
				identificacion: { type: 'string', title: 'Identificación' },
			    nombre: { type: 'string', title: 'Nombre' },
			    apellidos: { type: 'string', title: 'Apellidos' },
			    correoElectronico: { type: 'string', pattern: "^\\S+@\\S+$", title: 'Email', validationMessage: "La dirección de correo no es válida" },
			    fechaNac: { type: 'string', format: 'date' , title: 'Fecha de nacimiento' },
			    fechaIngreso: { type: 'string', title: 'Fecha de ingreso', format:'date' },
			    fechaPago: { type: 'string', title: 'Fecha de pago', format:'date' },
			    poseeVehiculo: { type: 'string', title: 'Posee vehiculo' },
			    estatus: { type: 'string', title: 'Habilitado' },
			  }
			};
    
	$scope.usuarioForm = angular.copy(usuario);
    console.log("me dieron click dentro del modal",$scope.usuarioForm.nombre);
	
    	$scope.form = [
		'identificacion',
		'nombre',
		'apellidos',
		'correoElectronico',
		'fechaNac',
		'fechaIngreso',
	    'fechaPago',
	    'poseeVehiculo',
	    'estatus',
	  ];
	  
	  
	  $scope.save = function () {
	    // Copy row values over
	    usuario.identificacion = $scope.usuarioForm.identificacion;
	    usuario.nombre = $scope.usuarioForm.nombre;
	    usuario.apellidos = $scope.usuarioForm.apellidos;
	    usuario.correoElectronico = $scope.usuarioForm.correoElectronico;
	    usuario.fechaNac = $scope.usuarioForm.fechaNac;
	    usuario.fechaIngreso = $scope.usuarioForm.fechaIngreso;
	    usuario.fechaPago = $scope.usuarioForm.fechaPago;
	    usuario.poseeVehiculo = $scope.usuarioForm.poseeVehiculo;
	    usuario.estatus = $scope.usuarioForm.estatus;
	   
	    $uibModalInstance.close();
	  }
    
}]);
