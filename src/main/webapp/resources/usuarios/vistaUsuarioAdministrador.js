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
			console.log("$scope.usuarios",$scope.gridOptions)
	});


	$scope.gridOptions = { 
	        data: 'usuarios',
	        showGroupPanel: true,
	        enableSorting: true,
	        enableFiltering:true,
	        enableColumnResizing : true,
	        enableGridMenu : true,
	        showGridFooter : true,
	        showColumnFooter : true,
	        fastWatch : true,
	        columnDefs: [
	           {name:'identificacion', displayName:'Identificación'},
	           {name:'nombre', displayName:'Nombre'}, 
	           {name:'apellidos', displayName:'Apellidos'},
	           {name:'fechaPago', displayName:'Fecha pago', type: 'date', cellFilter: 'date:\'dd-MM-yyyy\''},
	           {name: 'tipoUsuarioPOJO.descTipoUsuario' , displayName:'Tipo de usuario'},
	           {name: 'usuarioPOJOInstructor.nombre' , displayName:'Instructor'},
	           {name: 'registroIngresoPOJO.fechaHoraIngreso', displayName:'Ult.Fecha de Ingreso', type: 'date', cellFilter: 'date:\'dd-MM-yyyy\''},
	           {name: 'debePago', displayName:'Debe Pago?'}
	           ]
	    };
					    
}]);