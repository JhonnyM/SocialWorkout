//'use strict';

angular.module('myApp.modalTipoUsuario', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalControllerTiposUsuario', ['$scope','$uibModalInstance','$http','tiposUsuario',  function($scope, $uibModalInstance, $http, tiposUsuario)
{
	$scope.Schema = {
			  "type": "object",
			  properties: {
				idTipoUsuario: { type: 'string', title: 'Id tipo usuario' },
			    descTipoUsuario: { type: 'string', title: 'Descripción' }
			  }
			};
    
	$scope.tipoUsuarioForm = angular.copy(tiposUsuario);

      
    	$scope.form = [
		
		'descTipoUsuario',
		
	  ];
	  
    	$scope.save = function () {
    		$scope.data = {};
    			data = {
    			  	idTipoUsuario : $scope.tipoUsuarioForm.idTipoUsuario,
    				descTipoUsuario : $scope.tipoUsuarioForm.descTipoUsuario
    			  };
    				$http.post('rest/protected/tipousers/edit',data).success(
    					function(data, status, config) {
    					$scope.message = data;
    					}).error(
    					function(data, status, config) {
    					  alert("failure message: "+ JSON.stringify({data : data}));
    					});
    	tiposUsuario.descTipoUsuario = $scope.tipoUsuarioForm.descTipoUsuario;
	    $uibModalInstance.close();
	  }
    	
    	
    	$scope.saveTipoUsuario = function(event){
	    	
		  	var data = {};
		  	console.log($scope.tipoUsuarioForm.descTipoUsuario);

		  	data = {
		  			descTipoUsuario :  $scope.tipoUsuarioForm.descTipoUsuario
		  	};
		  	
		  	$http.post('rest/protected/tipousers/create', data)
		  	.success(function(data, status, config) {
		      $scope.message = data;
		      }).error(function(data, status, config) {
		        alert( "failure message: " + JSON.stringify({data: data}));
		    }); 
		  	$uibModalInstance.close();
		    
		  };
}]);
