angular
    .module('myApp.modalRegistrarUnidadMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalRegistrarUnidadMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        '$route',
        function($scope, $http, $uibModalInstance, $route) {
            $scope.unidadMedidaSchema = {
                "type": "object",
                properties: {
                    descUnidadMedida: {
                        type: 'string',
                        title: 'Descripción'
//                        pattern: "^[A-Za-z0-9 ]{1,255}$",
//                        minLength: 1,
//                        validationMessage: "Descripción de unidad de medida inválida"

                    }
                },
                "required": [
                             "descUnidadMedida"
			               ]
            };

            $scope.reload = function() {
                $route.reload();
            };


            $scope.form = ['descUnidadMedida'];

            $scope.save = function() {

                $scope.data = {};

                data = {
                    descUnidadMedida: $scope.form.descUnidadMedida
                };

    			$scope.valid = tv4.validate($scope.form, $scope.unidadMedidaSchema);
                $scope.valid = true;
    			
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