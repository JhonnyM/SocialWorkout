angular
    .module('myApp.modalRegistrarMaquinaEjercicio', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalRegistrarMaquinaEjercicioCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'ejercicio',
        function($scope, $http, $uibModalInstance, ejercicio) {

            $scope.maquinas = [];
            $scope.maquinaEjercicio = [];
            $scope.maquinasSeleccionadas = [];

            $scope.requestObject = {
                "pageNumber": 0,
                "pageSize": 0,
                "sortBy": [""],
                "searchColumn": "string",
                "searchTerm": "",
                "ejercicio": {}
            };

            $scope.ejercicioForm = angular.copy(ejercicio);

            $scope.setMachine = function(maquinas, maquinaEjercicio) {

                for (i = 0; i < $scope.maquinas.length; i++) {
                    for (j = 0; j < $scope.maquinaEjercicio.length; j++) {
                        if ($scope.maquinas[i].idMaquina == $scope.maquinaEjercicio[j].maquinaPOJO.idMaquina) {
                            $scope.toggle(maquinas[i], $scope.maquinasSeleccionadas);
                        }
                    }
                }
            };


            $scope.getMaquinasAsignadas = function(maquinas) {

                var maquinaHasEjercicio = {};

                maquinaHasEjercicio = {
                    idEjercicioXMaquina: 0,
                    ejercicioPOJO: {
                        idEjercicio: $scope.ejercicioForm.idEjercicio
                    },
                    maquinaPOJO: {
                        idMaquina: 0
                    }

                };

                $http
                    .post(
                        'rest/protected/Ejercicios/getMaquinasEjercicio', {
                            maquinaEjercicio: maquinaHasEjercicio
                        })
                    .success(
                        function(data, status,
                            config) {
                            $scope.message = data;
                            $scope.maquinaEjercicio = data.maquinaEjercicio;
                            $scope.setMachine($scope.maquinas, $scope.maquinaEjercicio);
                        })
                    .error(
                        function(data, status,
                            config) {
                            alert("failure message: " +
                                JSON
                                .stringify({
                                    data: data
                                }));
                        });


            };

            $scope.read = function() {
                $scope.maquinasSeleccionadas.length = 0;
                $http
                    .get('rest/protected/Maquinas/getAll')
                    .then(
                        function(response) {
                            $scope.maquinas = response.data.maquinas;
                            $scope.getMaquinasAsignadas($scope.maquinas);
                        },
                        function() {
                            alert("Error obteniendo la informacion de los eventos")
                        });
            };

            $scope.read();


            $scope.toggle = function(maquina,
                maquinasSeleccionadas) {

                var idx = maquinasSeleccionadas
                    .indexOf(maquina);
                if (idx > -1)
                    maquinasSeleccionadas.splice(idx, 1)
                else
                    maquinasSeleccionadas.push(maquina);
            };

            $scope.exists = function(maquina,
                maquinasSeleccionadas) {

                return maquinasSeleccionadas.indexOf(maquina) > -1;

            };

            $scope.save = function() {

                $scope.data = {};
                var maquinaHasEjercicio = {};

                if ($scope.maquinasSeleccionadas.length == 0) {

                    maquinaHasEjercicio = {
                        idEjercicioXMaquina: 0,
                        ejercicioPOJO: {
                            idEjercicio: $scope.ejercicioForm.idEjercicio
                        },
                        maquinaPOJO: {
                            idMaquina: 0
                        }
                    };

                    $http
                        .post(
                            'rest/protected/Ejercicios/deleteAllAssignedMachines', {
                                maquinaEjercicio: maquinaHasEjercicio
                            })
                        .success(
                            function(data, status,
                                config) {
                                $scope.message = data;
                                $uibModalInstance
                                    .close();
                            })
                        .error(
                            function(data, status,
                                config) {
                                alert("failure message: " +
                                    JSON
                                    .stringify({
                                        data: data
                                    }));
                            });

                } else {

                    maquinaHasEjercicio = {

                    		idEjercicioXMaquina: 0,
                            
                    		ejercicioPOJO: {
                                idEjercicio: $scope.ejercicioForm.idEjercicio
                            
                    		},
                            maquinaPOJO: {
                                idMaquina: 0
                            }
                        };

                    $http
                    .post(
                        'rest/protected/Ejercicios/deleteAllAssignedMachines', {
                            maquinaEjercicio: maquinaHasEjercicio
                        });

                    
                    for (i = 0; i < $scope.maquinasSeleccionadas.length; i++) {

                        maquinaHasEjercicio = {
                            idEjercicioXMaquina: 0,

                            ejercicioPOJO: {
                                idEjercicio: $scope.ejercicioForm.idEjercicio
                            },
                            maquinaPOJO: {
                                idMaquina: $scope.maquinasSeleccionadas[i].idMaquina
                            }
                        };
                    
                    $http
                        .post(
                            'rest/protected/Ejercicios/assignMachine', {
                                maquinaEjercicio: maquinaHasEjercicio
                            })
                        .success(
                            function(data, status,
                                config) {
                                $scope.message = data;
                                $uibModalInstance
                                    .close();
                            })
                        .error(
                            function(data, status,
                                config) {
                                alert("failure message: " +
                                    JSON
                                    .stringify({
                                        data: data
                                    }));
                            });

                };
                };
            }
        }
    ]);