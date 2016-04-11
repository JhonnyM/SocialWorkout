'use strict';

angular.module('myApp.miPerfil', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/miPerfil', {
    templateUrl: 'resources/miPerfil/miPerfil.html',
    controller: 'miPerfilCtrl'
  });  
}])

.controller('miPerfilCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {
	$scope.tiposUsuariosList = [];
	$scope.instructorList = [];
	$scope.requestObject = {};
	$scope.usuarioForm = {};
	$scope.requestObject.idTipoUsuario = "";
	$scope.requestObject.idUsuarioInstructor = "";
	$http.post('rest/protected/users/usuarioSet')
		.success(function(response) {
			$scope.usuarioForm = response.usuario;
			    console.log($scope.usuarioForm.fechaNac,"LOGUEADO");
			    $scope.usuarioForm.fechaNac = new Date($scope.usuarioForm.fechaNac);
			    $scope.usuarioForm.fechaIngreso  = new Date($scope.usuarioForm.fechaIngreso);
			    $scope.usuarioForm.fechaPago  = new Date($scope.usuarioForm.fechaPago);
			    console.log($scope.usuarioForm);
			});	

    $scope.init = function() {
		 
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
			   },
               "readonly":true
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
	  

}]);
