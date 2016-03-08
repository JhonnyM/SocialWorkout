//'use strict';

angular.module('myApp.modalTipoUsuario', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap', ])


.controller('ModalControllerTiposUsuario', ['$scope','$uibModalInstance','$http','tiposUsuario', 'route', function($scope, $uibModalInstance, $http, tiposUsuario, route)
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
    		$scope.tipoUsuarioRequest = {}
    		tipoUsuarioRequest = {
    			  	idTipoUsuario : $scope.tipoUsuarioForm.idTipoUsuario,
    				descTipoUsuario : $scope.tipoUsuarioForm.descTipoUsuario
    			  };
    		
    				$http.post('rest/protected/tipousers/edit',{tipo: tipoUsuarioRequest}).success(
    					function(tipoUsuarioRequest, status, config) {
    					$scope.message = tipoUsuarioRequest;
    					}).error(
    					function(tipoUsuarioRequest, status, config) {
    					  alert("failure message: "+ JSON.stringify({tipoUsuarioRequest : tipoUsuarioRequest}));
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
		  	
		  	$http.post('rest/protected/tipousers/create', {tipo: data})
		  	.success(function(data, status, config) {
		      $scope.message = data;
		      }).error(function(data, status, config) {
		        alert( "failure message: " + JSON.stringify({data : data}));
		        route.reload();
		    }); 
		  	
		  	$uibModalInstance.close();
		    
		  };
}]);
