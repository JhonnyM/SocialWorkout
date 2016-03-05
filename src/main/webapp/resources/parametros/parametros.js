'use strict';

angular.module('myApp.parametros', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/parametros', {
    templateUrl: 'resources/parametros/parametros.html',
    controller: 'ParametrosCtrl'
  });
}])

.controller('ParametrosCtrl', ['$scope','$http', '$uibModal', function($scope,$http,$uibModal) {
	$scope.parametros = [];
	$scope.requestObject = {"nombreNegocio": "Matrix", "cantidadDiasCalculoPromedios": 5};
	$http.post('rest/protected/parametros/getAll',$scope.requestObject)
		.success(function(response) {
		$scope.parametros = response.parametros;
		$uibModalInstance.close();
		
	});
	
	$scope.gridOptions = {
			data:'parametros',
			showGroupPanel: true,
	         enableSorting: true,
	         enableFiltering:true,
	         enableColumnResizing : true,
	         enableGridMenu : true,
	         showGridFooter : true,
	         showColumnFooter : true,
	         fastWatch : true,
			columnDefs:[{field:'nombreNegocio', displayName:'Gym'}, 
			            {field:'cantidadDiasCalculoPromedios', displayName:'Cantidad Dias'},
			            {field:'Acciones', displayName:'Acciones',
	               		cellTemplate: '<p ng-click="grid.appScope.edit(row)">Edit</p>'}
			            ]
	
	};
	
	$scope.edit = function(row){
		   var dialogOpts = {
		     backdrop:'static',
		     keyboard:false,
		     templateUrl:'resources/parametros/modal_Editar_Parametro.html',
		     controller:'Modal_Editar_ParametroCtrl',
		     size:"sm",
		     windowClass:"modal",
		     resolve:{
		      parametro:function(){return row.entity}
		     }
		   };

		   $uibModal.open(dialogOpts)
		  
	}
	
	$scope.register = function(){
		   var dialogOpts = {
		     backdrop:'static',
		     keyboard:false,
		     templateUrl:'resources/parametros/modal_Registrar_Parametro.html',
		     controller:'Modal_Registrar_ParametroCtrl',
		     size:"sm",
		     windowClass:"modal"
		   };
		   
		   $uibModal.open(dialogOpts)
		  
		  };
	
}]);