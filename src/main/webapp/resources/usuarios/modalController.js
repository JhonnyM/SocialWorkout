//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalController', ['$scope','$uibModalInstance','usuario', '$http',  function($scope, $uibModalInstance,usuario, $http)
{
	$scope.tiposUsuariosList = [];
	$scope.requestObject = {};
	$scope.usuarioForm = angular.copy(usuario);
	$scope.init = function() {
		 $http.post('rest/protected/tipousers/getAll')
		.success(function(response) {
			    $scope.tiposUsuariosList = response.tipoUsuariosList;
			    $scope.requestObject.idTipoUsuario = $scope.usuarioForm.tipoUsuarioPOJO.idTipoUsuario;
				
			});
	    	
	    };
	$scope.init();
	
	

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
			    poseeVehiculo: { type: 'boolean', title: 'Posee vehiculo' },
			    estatus: { type: 'boolean', title: 'Habilitado' },
			   }
			};
    
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
	   {"key": "poseeVehiculo",
			 "type": "checkbox",
		    },
	    {"key": "estatus",
			 "type": "checkbox",
		    },
	    
	    
	  ];
	  
    	$scope.save = function () {
    		$scope.data = {};
			data = {
			  	idUsuario : usuario.idUsuario,
			  	identificacion : $scope.usuarioForm.identificacion,
                nombre : $scope.usuarioForm.nombre,
                apellidos : $scope.usuarioForm.apellidos,
                correoElectronico : $scope.usuarioForm.correoElectronico,
                estatus : $scope.usuarioForm.estatus,
                fechaIngreso : $scope.usuarioForm.fechaIngreso,
                fechaNac : $scope.usuarioForm.fechaNac,
                fechaPago : $scope.usuarioForm.fechaPago,
                poseeVehiculo : $scope.usuarioForm.poseeVehiculo,
                tipoUsuarioPOJO : {
                	idTipoUsuario : $scope.usuarioForm.idTipoUsuario,
                	descTipoUsuario : ''
                }
            };
			  console.log(data.idUsuario);
				  $http.post('rest/protected/users/edit', {user : data}).success(
					function(data, status, config) {
					$scope.message = data;
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
				
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
	  };
    
}]);
