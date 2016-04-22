'use strict';

angular.module('myApp.tiposUsuario', ['ngRoute', 'ui.grid', 'ui.grid.cellNav' , 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/tiposUsuario', {
    templateUrl: 'resources/tiposUsuario/tiposUsuario.html',
    controller: 'TiposUsuarioCtrl'
  });  
}])

.controller('TiposUsuarioCtrl', ['$scope','$http','$uibModal','$route' , function($scope,$http,$uibModal, $route) {
	 $scope.reload = function(){
		 $route.reload();
		};

	$scope.tiposUsuario = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","tiposusuario": {}};
	$http.post('rest/protected/tipousers/getAll',$scope.requestObject)
		.success(function(response) {
			console.log("response",response)
			$scope.tiposUsuario = response.tipoUsuariosList;
			console.log("$scope.tiposUsuario",$scope.gridOptions)
			
	});
	$scope.gridOptions = { 
	        data: 'tiposUsuario',
	        enableSorting: true,
	        enableFiltering: true,
	        enableColumnResizing : true,
	        enableGridMenu : true,
	        showGridFooter : true,
	        showColumnFooter : true,
	        fastWatch : true,
	        columnDefs: [
	           {field:'descTipoUsuario', displayName:'Descripción',}, 
	           {name:'Acciones', displayName:'Acciones',enableFiltering: false, enableSorting: false, width: 180},
	           ]
	    };
	
		$scope.editRow = function(row){
			console.log("me dieron click",row.entity);
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/tiposUsuario/edit-modaltipousuario.html',
					controller:'ModalControllerTiposUsuario',
					size:"sm",
					windowClass:"modal",
					resolve:{
						tiposUsuario:function(){return row.entity},
			            route : $route,
			        }
			};
			
			$uibModal.open(dialogOpts)
		};
       
		$scope.addRow = function(){
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/tiposUsuario/edit-modaltipousuarionuevo.html',
					controller:'ModalControllerTiposUsuario',
					size:"sm",
					windowClass:"modal",
					resolve:{
						tiposUsuario:{},
			            route : $route,
					}
			};
			
			$uibModal.open(dialogOpts)
		};
		
			$scope.borrar = function (row){
		    var data = {};
		    data = {
		        idTipoUsuario : row.entity.idTipoUsuario,
		        descTipoUsuario : row.entity.descTipoUsuario
		    };
		    $http.post('rest/protected/tipousers/delete', {tipo:data} )
		    .then(function (response){
		    switch(response.data.code)
		      {
		        case 200:
		          alert("Tipo de usuario eliminado")
		          $scope.reload();
		        break;

		        default:
		          alert(response.data.codeMessage);
		      }
		      
		     }, function (response){

		      console.log(response);
		    }); 
		    
		  };
		  
		 
}]);