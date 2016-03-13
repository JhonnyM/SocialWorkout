angular.module('myApp.clasesModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('ClasesModalCtrl', ['$scope','$http','$uibModalInstance','clase',  function($scope,$http,$uibModalInstance,clase)
{

	$scope.ClaseSchema = {
	  "type": "object",
	  properties: {
		  descClase: { type: 'string', title: 'Descripción'},
	  	}
	};
    
	$scope.claseForm = angular.copy(clase);
	
    $scope.form = [
		'descClase'
	];
	  
	$scope.save = function() {
		  
	  	$scope.data = {};

	  	data = {
	  		idClase : $scope.claseForm.idClase,
			descClase : $scope.claseForm.descClase
	  	};

		$http.post('rest/protected/clases/update',{clase: data})
		.then(function (response){

	      switch(response.data.code)
	      {
	        case 200:
	          alert(response.data.codeMessage);
	        break;

	        default:
	          alert(response.data.codeMessage);
	      }
	      $scope.read();
	    }, function (response){
	      alert("Error al guardar la información de la nueva clase");
	    });
	};
}]);
