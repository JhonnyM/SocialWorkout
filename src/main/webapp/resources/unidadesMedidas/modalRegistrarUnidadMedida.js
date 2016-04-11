angular
    .module('myApp.modalRegistrarUnidadMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalRegistrarUnidadMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        '$route',
        function($scope, $http, $uibModalInstance, $route) {
        	$scope.unidadMedidaForm = {};
            $scope.unidadMedidaSchema = {
                type: 'object',
                properties: {
                    descUnidadMedida: {
                        type: 'string',
                        title: 'Descripción',
                        validationMessage: 'Descripción de unidad de medida inválida',
                        pattern: "^[A-Za-z0-9 áéíóú.!=/-]+$",
                        maxLength: 255
                    }
                },
                required : [
                             'descUnidadMedida'
			               ]
            };

            $scope.reload = function() {
                $route.reload();
            };


            $scope.form = ['descUnidadMedida'];

            $scope.save = function() {

                $scope.data = {};

                data = {
                    descUnidadMedida: $scope.unidadMedidaForm.descUnidadMedida
                };

    			$scope.valid = tv4.validate($scope.unidadMedidaForm, $scope.unidadMedidaSchema);
    			
               if($scope.valid){
                   $http.post('rest/protected/UnidadesMedidas/create', {
                       unidadMedida: data
                   }).success(
                       function(data, status, config) {
                           $scope.message = data;
                           $scope.dismissModal = $scope.reload();
                           $uibModalInstance.close();            	   
                       }).error(
                       function(data, status, config) {
                           alert("failure message: " + JSON.stringify({
                               data: data
                           }));
                       });
               }else{

               }
            };
            
        }
    ]);