'use strict';

angular.module('myApp.usuarios', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/usuarios', {
    templateUrl: 'resources/usuarios/usuarios.html',
    controller: 'UsuariosCtrl'
  });  
}])

.controller('UsuariosCtrl', ['$scope','$http','$uibModal','$route', function($scope,$http,$uibModal,$route) {
	$scope.reload = function(){
		 $route.reload();
		};
	$scope.usuarios = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","usuario": {}};
	$http.post('rest/protected/users/getAll',$scope.requestObject)
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
	           {name:'correoElectronico', displayName:'Email'},
	           {name:'fechaPago', displayName:'Fecha pago'},
	           {name:'estatus', displayName:'Habilitado', cellTemplate: '<input type="checkbox" ng-model="row.entity.estatus" disabled="disabled">'},
	           {name:'poseeVehiculo', displayName:'Vehículo', cellTemplate: '<input type="checkbox" ng-model="row.entity.poseeVehiculo" disabled="disabled">'},
	           {name: 'tipoUsuarioPOJO.descTipoUsuario' , displayName:'Tipo de usuario'},
	           {name: 'usuarioPOJOInstructor.nombre' , displayName:'Instructor'},
	           {name:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button>'},
	           {name:'Historial Medidas', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.getHistorialMedidas(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Ver historial de medidas</button>'} 

	           ]
	    };
	
		$scope.editRow = function(row){
			console.log("me dieron click",row.entity);
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/usuarios/edit-modal.html',
					controller:'ModalController',
					size:"sx",
					windowClass:"modal",
					resolve:{
						usuario:function(){return row.entity}
					}
			};
			$uibModal.open(dialogOpts)
		}
		
		$scope.getHistorialMedidas = function(row){

			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/usuarios/modal_Historial_Medidas.html',
					controller:'modal_Historial_Medida_Ctrl',
					size:"lg",
					windowClass:"modal",
					resolve:{
						usuario:function(){return row.entity}
					}
			};
			$uibModal.open(dialogOpts)
		}
		
		$scope.addRow = function(){
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/usuarios/edit-modalusuarionuevo.html',
					controller:'ModalController',
					size:"sx",
					windowClass:"modal",
					resolve:{
						usuario: {},
			            route : $route,
					}
			};
			
			$uibModal.open(dialogOpts)
		};
    
}]);