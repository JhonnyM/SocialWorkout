'use strict'

angular.module('myApp.listar_Unidad_Medida',['ngRoute','ui.grid','ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  	.when('/listar_Unidad_Medida', {
	templateUrl: 'resources/listarUnidadMedida/listar_Unidad_Medida.html',
    controller: 'listarUnidadMedidaViewCtrl'
  });

}])

.controller('listarUnidadMedidaViewCtrl',['$scope','$http','$uibModal',function($scope,$http,$uibModal){
	$scope.unidadesMedida = [];
	$scope.requestObject = {"idUnidadMedida":1,"descUnidadMedida":"","lugarmedicions":[]};
	
		$http.post('rest/protected/UnidadesMedidas/getAll',$scope.requestObject).success(function(response){
			console.log("response",response)
			$scope.unidadesMedida = response.unidadesMedidas;
			console.log("$scope.unidadesMedida",$scope.gridOptions)
		});	
		
		$scope.gridOptions = {
			data:'unidadesMedida',
	        showGroupPanel: true,
	        enableSorting: true,
	        enableFiltering:true,
	        enableColumnResizing : true,
	        enableGridMenu : true,
	        showGridFooter : true,
	        showColumnFooter : true,
	        fastWatch : true,
	        columnDefs:[
			            {field:'descUnidadMedida',displayName:'Descripción'},
			            {field:'Acciones', displayName:'Acciones',
			            cellTemplate: '<p ng-click="grid.appScope.editRow(row)">Edit</p>'},
			            {field:'Acciones', displayName:'Acciones',
			            cellTemplate: '<p ng-click="grid.appScope.deleteUnidadMedida(row)">Delete</p>'}
	                    ]
		};
		
		$scope.editRow = function(row){
			console.log("me dieron click",row.entity);
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/listarUnidadMedida/edit-modal.html',
					controller:'ModalController',
					size:"sm",
					windowClass:"modal",
					resolve:{
						unidadMedida:function(){return row.entity}
					}
			};
			$uibModal.open(dialogOpts)
		};		

		  $scope.deleteUnidadMedida = function(row){
			    var data = {};
			    
			    data = {

			    	idUnidadMedida : row.entity.idUnidadMedida,
			   		descUnidadMedida : row.entity.descUnidadMedida
			    };

			    console.log("data",data);
			    
			    $http.post("rest/protected/UnidadesMedidas/delete", {unidadMedida:data} )
			    .then(function (response){

			      switch(response.data.code)
			      {
			        case 200:
			          alert("Unidad de medida eliminada.")
			        break;

			        default:
			          alert(response.data.codeMessage);
			      }

			    }, function (response){

			      console.log(response);
			    }); 
			  };

}]);


