'use strict';

angular.module('myApp.usuariosAdministrador', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/usuariosAdministrador', {
    templateUrl: 'resources/usuarios/vistaUsuarioAdministrador.html',
    controller: 'UsuariosAdministradorCtrl'
  });  
}])

.controller('UsuariosAdministradorCtrl', ['$scope','$http','$uibModal','$route', function($scope,$http,$uibModal,$route) {
	$scope.reload = function(){
		 $route.reload();
	};
	
	$scope.usuarios = [];
	
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","usuario": {}};
	
	$http.post('rest/protected/users/getAllToAdministrador',$scope.requestObject)
		.success(function(response) {
			console.log("response",response)
			$scope.usuarios = response.usuarios;
			angular.forEach($scope.usuarios,function(row){
				  row.getNombreApellido = function(){
				
					var nombre;
					var apellidos;
					
					if(this.usuarioPOJOInstructor.nombre == null){
						nombre = "";
					}else{
						nombre = this.usuarioPOJOInstructor.nombre;
					}

					if(this.usuarioPOJOInstructor.apellidos == null){
						apellidos = "";
					}else{
						apellidos = this.usuarioPOJOInstructor.apellidos;
					}

				    return nombre + ' ' + apellidos;
				  }
				});
			console.log("$scope.usuarios",$scope.gridOptions)
	});


	$scope.gridOptions = { 
	        data: 'usuarios',
            showGroupPanel: true,
            enableSorting: true,
            enableFiltering: true,
	        columnDefs: [
	           {name:'identificacion', displayName:'Identificación'},
	           {name:'nombre', displayName:'Nombre'}, 
	           {name:'fechaPago', displayName:'Fecha pago', type: 'date', cellFilter: 'date:\'dd-MM-yyyy\''},
	           {name: 'tipoUsuarioPOJO.descTipoUsuario' , displayName:'Tipo de usuario'},
	           {name: 'getNombreApellido()' , displayName:'Instructor'},
	           {name: 'registroIngresoPOJO.fechaHoraIngreso', displayName:'Ult.Fecha de Ingreso', type: 'date', cellFilter: 'date:\'dd-MM-yyyy\''},
	           {name: 'debePago', displayName:'Debe Pago?'}
	           ]
	    };
					    
}]);