angular.module('myApp.modal_Registrar_Parametro',
  [ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
  'Modal_Registrar_ParametroCtrl',
  [
    '$scope',
    '$http',
    '$uibModalInstance',

    function($scope, $http, $uibModalInstance) {
     $scope.parametroSchema = {
      "type" : "object",
      properties : {
    	  nombreNegocio: { type: 'string', title: 'Gimnasio' },
		  cantidadDiasCalculoPromedios: { type: 'number', title: 'Cantidad dias' }
      }
     };
     
     $scope.form = [
            		'nombreNegocio',
            		'cantidadDiasCalculoPromedios'
            	  ];

     $scope.save = function() {

    	 var data = {};
 		  data = {
 				nombreNegocio : $scope.form.nombreNegocio,
 				cantidadDiasCalculoPromedios : $scope.form.cantidadDiasCalculoPromedios
 		  };

      $http.post('rest/protected/parametros/create', data)
        .success(function(data, status, config) {
         $scope.message = data;
         $uibModalInstance.close();  
         $route.reload();          
        }).error(
          function(data, status, config) {
           alert("failure message: "
             + JSON.stringify({
              data : data
             }));
          });
     };
    } ]);