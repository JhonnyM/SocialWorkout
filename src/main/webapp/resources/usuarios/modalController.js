//'use strict';

angular.module('myApp.modalu', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalController', ['$scope','$uibModalInstance','usuario', '$http','$route', function($scope, $uibModalInstance,usuario, $http, $route)
{
	$scope.tiposUsuariosList = [];
	$scope.instructorList = [];
	$scope.requestObject = {};
	$scope.usuarioForm = angular.copy(usuario);
	$scope.reload = function(){
		 $route.reload();
		};
   $scope.usuarioForm.fechaNac = new Date(usuario.fechaNac);
   $scope.usuarioForm.fechaIngreso  = new Date(usuario.fechaIngreso);
   $scope.usuarioForm.fechaPago  = new Date(usuario.fechaPago);
   console.log($scope.usuarioForm.poseeVehiculo,"POSEE");
   
	
	
	$scope.init = function() {
		 $http.post('rest/protected/tipousers/getAll')
		 	.success(function(response) {
			    $scope.tiposUsuariosList = response.tipoUsuariosList;
			    $scope.requestObject.idTipoUsuario = $scope.usuarioForm.tipoUsuarioPOJO.idTipoUsuario;
			    console.log($scope.requestObject.idTipoUsuario,"REQUEST");
			});
		 $http.post('rest/protected/users/getAllByTipoUsuario')
			.success(function(response) {
				    $scope.instructorList = response.usuarios;
				    $scope.requestObject.idUsuarioInstructor = $scope.usuarioForm.usuarioPOJOInstructor.idUsuario;
				    console.log($scope.requestObject.idUsuarioInstructor,"REQUEST-INSTRUCTOR");
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
		{"title":"Fecha de nacimiento",
		 "key": "fechaNac",
		 "type": "date",
		},
		{"title":"Fecha de Ingreso",
		 "key": "fechaIngreso",
	     "type": "date",
		},
		{"title":"Fecha de pago",
		 "key": "fechaPago",
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
                	idTipoUsuario : $scope.requestObject.idTipoUsuario,
                	descTipoUsuario : ''
                },
			    usuarioPOJOInstructor : {
			    	idUsuario : $scope.requestObject.idUsuarioInstructor
			    }
            };
			  console.log(data.idUsuario);
				  $http.post('rest/protected/users/edit', {user : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
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
      $scope.create = function(event){
    	  $scope.data = {};
			data = {
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
              	idTipoUsuario : $scope.requestObject.idTipoUsuario,
              	descTipoUsuario : ''
              },
		      usuarioPOJOInstructor : {
				idUsuario : $scope.requestObject.idUsuarioInstructor
			  }
          };
			  console.log(data.idUsuario);
				  $http.post('rest/protected/users/create', {user : data}).success(
					function(data, status, config) {
					$scope.message = data;
					 $scope.dismissModal = $scope.reload();
					}).error(
					function(data, status, config) {
					  alert("failure message: "+ JSON.stringify({data : data}));
					});
	    $uibModalInstance.close();
      };
}]);
