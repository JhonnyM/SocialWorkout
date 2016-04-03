//'use strict';

angular.module('myApp.modalu', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalController', ['$scope','$uibModalInstance','usuario', '$http','$route', function($scope, $uibModalInstance,usuario, $http, $route)
{
	$scope.tiposUsuariosList = [];
	$scope.instructorList = [];
	$scope.requestObject = {};
	$scope.usuarioForm = angular.copy(usuario);
	$scope.valid = true;
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
		 $http.post('rest/protected/users/usuarioSet')
			.success(function(response) {
				    $scope.usuarioSet = response.usuario;
				    console.log($scope.usuarioSet,"LOGUEADO");
				});	
	    };
	    
    
    
	$scope.init();
	
	

    $scope.PersonSchema = {
			  "type": "object",
			  properties: {
				identificacion: { type: 'string', title: 'Identificación',validationMessage: "La identificación no es válida"},
			    nombre: { type: 'string', title: 'Nombre' ,validationMessage: "El nombre no es válido"},
			    apellidos: { type: 'string', title: 'Apellidos' ,validationMessage: "Los apellidos no son válidos"},
			    correoElectronico: { type: 'string', pattern: "^\\S+@\\S+$", title: 'Email', validationMessage: "La dirección de correo no es válida"},
			    fechaNac: {title: 'Fecha de nacimiento' },
			    fechaIngreso: {title: 'Fecha de ingreso'},
			    fechaPago: {title: 'Fecha de pago'},
			    poseeVehiculo: { type: 'boolean', title: 'Posee vehiculo' },
			    estatus: { type: 'boolean', title: 'Habilitado' },
			   },
			   "required": [
                             "identificacion",
			                 "nombre",
			                 "apellidos",
			                 "correoElectronico"
			               ]
    			 
			};
    
    	$scope.form = [
		'identificacion',
		
		{"title":"Nombre",
		 "key" : "nombre",
		 fieldHtmlClass: "text", 
		},	
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
    		$scope.dataReq = {};
    		
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
                },
			    usuarioPOJOInstructor : {
			    	idUsuario : $scope.requestObject.idUsuarioInstructor
			    }
            };
			$scope.valid = tv4.validate($scope.usuarioForm, $scope.PersonSchema);
			  if($scope.valid && $scope.requestObject.idTipoUsuario > 0){
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
			  }
	    $scope.valid = false;
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
			$scope.valid = tv4.validate($scope.usuarioForm, $scope.PersonSchema);
			  if($scope.valid && $scope.requestObject.idTipoUsuario > 0){
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
			  }
			  $scope.valid = false;
      };
}]);
