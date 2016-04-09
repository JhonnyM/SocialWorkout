//'use strict';
angular
    .module('myApp.modalEditarUnidadMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalEditarUnidadMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'unidadMedida',
        '$route',
        function($scope, $http, $uibModalInstance, unidadMedida, $route) {
            $scope.unidadMedidaSchema = {
                "type": "object",
                properties: {
                    descUnidadMedida: {
                        type: 'string',
                        title: 'Descripción',
                        pattern: "^[A-Za-z0-9 ]{1,255}$",
                        minLength: 1,
                        validationMessage: "Descripción de unidad de medida inválida"                       
                    }
                }
            };

            $scope.reload = function() {
                $route.reload();
            };

            $scope.unidadMedidaForm = angular
                .copy(unidadMedida);

            $scope.form = ['descUnidadMedida'];

            $scope.save = function() {

                $scope.data = {};
                data = {
                    idUnidadMedida: $scope.unidadMedidaForm.idUnidadMedida,
                    descUnidadMedida: $scope.unidadMedidaForm.descUnidadMedida
                };

    			$scope.valid = tv4.validate($scope.unidadMedidaForm, $scope.unidadMedidaSchema);
    			
    			if($scope.valid){

                    $http.post(
                            'rest/protected/UnidadesMedidas/edit', {
                                unidadMedida: data
                            }).success(
                            function(data, status, config) {
                                $scope.message = data;
                                $scope.dismissModal = $scope.reload();
                                $uibModalInstance.close();

                            }).error(
                            function(data, status, config) {
                                console.log("$scope.data",
                                    $scope.data)
                                alert("failure message: " + JSON.stringify({
                                    data: data
                                }));
                            });    				
    			}

             };
        }
    ]);