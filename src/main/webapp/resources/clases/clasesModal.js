angular.module('myApp.clasesModal', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller('ClasesModalCtrl', ['$scope','$http','$uibModalInstance','clase','$route',  function($scope,$http,$uibModalInstance,clase,$route)
{

	$scope.reload = function() {
    	$route.reload();
  	}

	$scope.ClaseSchema = {
	  "type": "object",
	  properties: {
		  descClase: { 
		  	type: 'string', 
		  	title: 'Descripción',
		  	validationMessage: 'Descripción de evento inválido',
	        pattern: "^[A-Za-z áéíóú.!=/-]+$", 
	        maxLength: 50
		  },
	  	},
	  	required : ['descClase' ]
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
	  	$scope.valid = tv4.validate($scope.claseForm, $scope.ClaseSchema);
			if($scope.valid){
				$http.post('rest/protected/clases/update',{clase: data})
				.then(function (response){

			      switch(response.data.code)
			      {
			        case 200:
			          alert(response.data.codeMessage);
			          $scope.dismissModal = $scope.reload();
			        break;

			        default:
			          alert(response.data.codeMessage);
			          $scope.dismissModal = $scope.reload();
			      }
			    }, function (response){
			      alert("Error al guardar la información de la nueva clase");
			    });
			    $uibModalInstance.close();
		}
		$scope.valid = false;
	};
}]);
