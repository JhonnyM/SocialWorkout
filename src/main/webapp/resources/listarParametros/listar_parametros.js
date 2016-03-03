'use strict';

angular.module('myApp.listar_parametros', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/listar_parametros', {
    templateUrl: 'resources/listarParametros/listar_parametros.html',
    controller: 'ParametroCtrlLst'
  });
}])

.controller('ParametroCtrlLst', ['$scope','$http', '$uibModal', function($scope,$http, $uibModal) {
	$scope.parametros = [];
	$scope.requestObject = {"nombreNegocio": "Matrix", "cantidadDiasCalculoPromedios": 5};
	$http.post('rest/protected/parametro/getAll',$scope.requestObject)
		.success(function(response) {
		$scope.parametros = response.parametros;
		
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
	               				cellTemplate: '<p ng-click="grid.appScope.editRow(row)">Edit</p>'}
			            ]
	
	};
	
	$scope.editRow = function(row){
		   var dialogOpts = {
		     backdrop:'static',
		     keyboard:false,
		     templateUrl:'resources/listarParametros/edit-modal.html',
		     controller:'ModalController',
		     size:"sm",
		     windowClass:"modal",
		     resolve:{
		      parametro:function(){return row.entity}
		     }
		   };
		   $uibModal.open(dialogOpts)
		  }
}]);