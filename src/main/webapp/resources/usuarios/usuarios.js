'use strict';

angular.module('myApp.usuarios', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/usuarios', {
    templateUrl: 'resources/usuarios/usuarios.html',
    controller: 'UsuariosCtrl'
  });  
}])

.controller('UsuariosCtrl', ['$scope','$http','$uibModal',function($scope,$http,$uibModal) {
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
	           {field:'identificacion', displayName:'Identificación'},
	           {field:'nombre', displayName:'Nombre'}, 
	           {field:'apellidos', displayName:'Apellidos'},
	           {field:'correoElectronico', displayName:'Email'},
	           {field:'fechaPago', displayName:'Fecha Pago'},
	           {field:'estatus', displayName:'Habilitado'},
	           {field:'Acciones', displayName:'Acciones',cellTemplate: '<p ng-click="grid.appScope.editRow(row)">Edit</p>'} 
	           ]
	    };
	
		$scope.editRow = function(row){
			console.log("me dieron click",row.entity);
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/usuarios/edit-modal.html',
					controller:'ModalController',
					size:"lg",
					windowClass:"modal",
					resolve:{
						usuario:function(){return row.entity}
					}
			};
			$uibModal.open(dialogOpts)
		}
       $scope.saveUsuario = function(event){
    	var data = {};
    	console.log($scope.requestObject.usuario);
    	data = {
    			identificacion : $scope.requestObject.identificacion,
    			nombre : $scope.requestObject.nombre,
    			apellidos : $scope.requestObject.apellidos,
    			clave : $scope.requestObject.clave,
    			correoElectronico : $scope.requestObject.correoElectronico,
    			estatus : $scope.requestObject.estatus,
    			fechaNacimiento : $scope.requestObject.fechaNacimiento,
    			fechaIngreso : $scope.requestObject.fechaIngreso,
    			fechaPago : $scope.requestObject.fechaPago,
    			poseeVehiculo : $scope.requestObject.poseeVehiculo
    	};
    	
    	$http.post('rest/protected/users/create', data)
    	.success(function(data, status, config) {
            $scope.message = data;
          }).error(function(data, status, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        }); 
    };
    
}]);