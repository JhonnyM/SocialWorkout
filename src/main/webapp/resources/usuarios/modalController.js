//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalController', ['$scope','$uibModalInstance','usuario',  function($scope, $uibModalInstance,usuario)
{
	$scope.PersonSchema = {
			  "type": "object",
			  properties: {
				identificacion: { type: 'string', title: 'Identificación' },
			    nombre: { type: 'string', title: 'Nombre' },
			    apellidos: { type: 'string', title: 'Apellidos' },
			    correoElectronico: { type: 'string', pattern: "^\\S+@\\S+$", title: 'Email', validationMessage: "La dirección de correo no es válida" },
			    fechaNac: {title: 'Fecha de nacimiento' },
			    fechaIngreso: {title: 'Fecha de ingreso'},
			    fechaPago: {title: 'Fecha de pago'},
			    poseeVehiculo: { type: 'string', title: 'Posee vehiculo' },
			    estatus: { type: 'string', title: 'Habilitado' },
			  }
			};
    
	$scope.usuarioForm = angular.copy(usuario);
    console.log("me dieron click dentro del modal",$scope.usuarioForm.nombre);
	
    var base = 'directives/decorators/bootstrap/';

    schemaFormDecoratorsProvider.createDecorator('bootstrapDecorator', {
      textarea: base + 'textarea.html',
      fieldset: base + 'fieldset.html',
      array: base + 'array.html',
      tabarray: base + 'tabarray.html',
      tabs: base + 'tabs.html',
      section: base + 'section.html',
      conditional: base + 'section.html',
      actions: base + 'actions.html',
      select: base + 'select.html',
      checkbox: base + 'checkbox.html',
      checkboxes: base + 'checkboxes.html',
      number: base + 'default.html',
      password: base + 'default.html',
      submit: base + 'submit.html',
      button: base + 'submit.html',
      radios: base + 'radios.html',
      'radios-inline': base + 'radios-inline.html',
      radiobuttons: base + 'radio-buttons.html',
      help: base + 'help.html',
      'default': base + 'default.html'
    }, [
      function(form) {
        if (form.readonly && form.key && form.type !== 'fieldset') {
          return base + 'readonly.html';
        }
      }
    ]);
    
    
    
    	$scope.form = [
		'identificacion',
		'nombre',
		'apellidos',
		'correoElectronico',
		{"key": "fechaNac",
		 "type": "date",
		},
		{"key": "fechaIngreso",
	     "type": "date",
		},
		{"key": "fechaPago",
		 "type": "date",
	    },
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
