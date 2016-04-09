//'use strict';
angular
    .module('myApp.modalRegistrarMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalRegistrarMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'usuario',
        '$route',
        function($scope, $http, $uibModalInstance, usuario, $route) {
        	$scope.lugarMedicionEscogido = {};
            $scope.lugaresMedicion = [];

            $scope.reload = function() {
                $route.reload();
            };

            $scope.cargarLugaresMedicion = function() {
                $http.get('rest/protected/lugarMedicion/getAll2')
                    .success(function(response) {
                        console.log("response", response)
                        $scope.lugaresMedicion = response.lugaresMedicion;
                        console.log("$scope.lugaresMedicion", $scope.lugaresMedicion)
                    });
            };

            $scope.cargarLugaresMedicion();

            $scope.registroMedidaSchema = {
                "type": "object",
                properties: {

                    fechaMedida: {
                        title: 'Fecha de medición'
                    },

                    registroMedida: {
                        type: 'number',
                        title: 'Registro'
                    }
                },
                "required": ["fechaMedida", "registroMedida"]
            };

            $scope.usuarioForm = angular.copy(usuario);

            $scope.form = [{
                    "title": "Fecha de medición:",
                    "key": "fechaMedida",
                    "type": "date"
                },
                'registroMedida'
            ];

            $scope.save = function() {
            	console.log("LUGARMEDICIONESCOGIDO", $scope.lugarMedicionEscogido)
                $scope.data = {};

                data = {
                    cantidad: $scope.form.registroMedida,
                    fecha: $scope.form.fechaMedida,
                    lugarmedicionPOJO: {
                        idLugarMedicion: $scope.lugarMedicionEscogido,
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
                    'rest/protected/RegistrosMedidas/create', {
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