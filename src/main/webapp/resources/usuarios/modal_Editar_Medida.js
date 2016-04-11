//'use strict';
angular
    .module('myApp.modal_Editar_Medida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'modal_Editar_MedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'usuario',
        'registroMedida',
        '$route',
        function($scope, $http, $uibModalInstance, usuario, registroMedida, $route) {

            $scope.registroMedidaSchema = {
                "type": "object",
                properties: {

                    fecha: {
                        title: 'Fecha de medición'
                    },

                    cantidad: {
                        type: 'number',
                        title: 'Registro'
                    }
                }
            };

            $scope.reload = function() {
                $route.reload();
            };

            $scope.lugaresMedicion = [];
            $scope.usuarioForm = angular.copy(usuario);
            $scope.registroMedidaForm = angular.copy(registroMedida);
            $scope.registroMedidaForm.fecha = new Date(registroMedida.fecha);
            $scope.lugarMedicionRegistro = $scope.registroMedidaForm.lugarmedicionPOJO.idLugarMedicion

            $scope.form = [{
                    "title": "Fecha de medición:",
                    "key": "fecha",
                    "type": "date"
                },
                'cantidad'
            ];


            $scope.cargarLugaresMedicion = function() {
                $http.get('rest/protected/lugarMedicion/getAll2')
                    .success(function(response) {
                        console.log("response", response)
                        $scope.lugaresMedicion = response.lugaresMedicion;
                        console.log("$scope.lugaresMedicion", $scope.lugaresMedicion)
                    });
            };

            $scope.cargarLugaresMedicion();

            $scope.save = function() {
            	console.log("LUGARMEDICION",$scope.lugarMedicionRegistro)
                $scope.data = {};

                data = {
                    idRegistroMedida: $scope.registroMedidaForm.idRegistroMedida,
                    cantidad: $scope.registroMedidaForm.cantidad,
                    fecha: $scope.registroMedidaForm.fecha,
                    lugarmedicionPOJO: {
                        idLugarMedicion: $scope.lugarMedicionRegistro,
                        unidadMedidaPOJO: {
                            idUnidadMedida: 0
                        }

                    },

                    usuarioPOJO: {
                        idUsuario: $scope.usuarioForm.idUsuario,
                        tipoUsuarioPOJO: {
                            idTipoUsuario: 0
                        },
                        usuarioPOJOInstructor: {
                            idUsuario: 0
                        }
                    }

                };

                console.log("$scope.data", $scope.data)
                $http.post(
                    'rest/protected/RegistrosMedidas/edit', {
                        registroMedida: data
                    }).success(
                    function(data, status, config) {
                        $scope.message = data;
                        $scope.dismissModal = $scope.reload();
                    }).error(
                    function(data, status, config) {
                        console.log("$scope.data",
                            $scope.data)
                        alert("failure message: " +
                            JSON.stringify({
                                data: data
                            }));
                    });
                $uibModalInstance.close();
            };
        }
    ]);