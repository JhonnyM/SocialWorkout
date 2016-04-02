'use strict';

angular.module('myApp.lugarMedicion', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/lugarMedicion', {
    templateUrl: 'resources/lugarMedicion/lugarmedicion.html',
    controller: 'LugarMedicionCtrl'
  });  
}])

.controller('LugarMedicionCtrl', ['$scope','$http','$uibModal','$route', function($scope,$http,$uibModal,$route) {
	/*$scope.reload = function(){
		 $route.reload();
		};*/
	$scope.lugaresMedicion = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","lugarMedicion": {}};
	$http.post('rest/protected/lugarMedicion/getAll')
		.success(function(response) {
			console.log("response",response)
			$scope.lugaresMedicion = response.lugaresMedicionPOJO;
			console.log("$scope.lugaresMedicion",$scope.lugaresMedicionPOJO)
	});


	$scope.gridOptions = { 
	        data: 'lugaresMedicion',
	        showGroupPanel: true,
	        enableSorting: true,
	        enableFiltering:true,
	        enableColumnResizing : true,
	        enableGridMenu : true,
	        showGridFooter : true,
	        showColumnFooter : true,
	        fastWatch : true,
	        columnDefs: [
	           {name:'idLugarMedicion', displayName:'Id'},
	           {name:'descLugarMedicion', displayName:'Descripción'}, 
	           {name:'unidadMedidaPOJO.descUnidadMedida', displayName:'Unidad de medida'},
	           {name:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button>'}, 
	           ]
	    };
	
		$scope.editRow = function(row){
			console.log("me dieron click",row.entity);
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/lugarMedicion/edit-modal.html',
					controller:'ModalControllerLugarMedicion',
					size:"sx",
					windowClass:"modal",
					resolve:{
						lugarMedicion:function(){return row.entity}
					}
			};
			$uibModal.open(dialogOpts)
		}
		
		$scope.addRow = function(){
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/lugarMedicion/edit-modallugarmedicionnuevo.html',
					controller:'ModalControllerLugarMedicion',
					size:"sx",
					windowClass:"modal",
					resolve:{
						lugarMedicion: {},
			            route : $route,
					}
			};
			
			$uibModal.open(dialogOpts)
		};
    
}]);