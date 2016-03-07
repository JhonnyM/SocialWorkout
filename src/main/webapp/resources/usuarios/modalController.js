//'use strict';

angular.module('myApp.modal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalController', ['$scope','$uibModalInstance','usuario', '$http',  function($scope, $uibModalInstance,usuario, $http)
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
			    tipoUsuario: { type: 'string', title: 'Tipo de usuario' },
			    poseeVehiculo: { type: 'boolean', title: 'Posee vehiculo' },
			    estatus: { type: 'boolean', title: 'Habilitado' },
			   }
			};
	$scope.tiposUsuario = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","tiposusuario": {}};
	$http.post('rest/protected/tipousers/getAll',$scope.requestObject)
		.success(function(response) {
			console.log("response",response)
			$scope.tiposUsuario = response.tipoUsuariosList;
			console.log("$scope.tiposUsuario",$scope.gridOptions)
			
	});
	
	
	$scope.usuarioForm = angular.copy(usuario);
    console.log("me dieron click dentro del modal",$scope.usuarioForm.idUsuario);
    $scope.listaTipos = function(){
    	angular.forEach($scope.tiposUsuario, function(value, key){
    	     console.log("FORECAA"+key + ': ' + value);
    	});
    	return [
                {value: "Cliente", name: "Cliente"},
                {value: "Instructor", name: "Instructor"},
                {value: "Administrador", name: "Administrador"}
            ];

    };
    $scope.listaTipos();
    console.log("tipos",$scope.listaTipos());  
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
	    {"key": "tipoUsuarioPOJO.descTipoUsuario",
			 "type": 'select',
			  titleMap: $scope.listaTipos()
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
                	idTipoUsuario : 1,
                	descTipoUsuario : $scope.usuarioForm.descTipoUsuario
                }
            };
			  console.log(data.idUsuario);
				  $http.post('rest/protected/users/edit',  data).success(
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
