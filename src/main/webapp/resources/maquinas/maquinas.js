'use strict'

angular
    .module('myApp.maquinas', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/maquinas', {
        templateUrl: 'resources/maquinas/maquinas.html',
        controller: 'MaquinasCtrl'
    });

}])

.controller(
    'MaquinasCtrl', [
        '$scope',
        '$http',
        '$uibModal',
        '$route',
        function($scope, $http, $uibModal, $route) {

            $scope.reload = function() {
                $route.reload();
            };

            $scope.maquinas = [];
            $scope.requestObject = {
                "pageNumber": 0,
                "pageSize": 0,
                "sortBy": [""],
                "searchColumn": "string",
                "searchTerm": "",
                "maquina": {}
            };

            $scope.read = function() {
                $http
                    .get('rest/protected/Maquinas/getAll')
                    .then(
                        function(response) {

                            console.log("response",
                                response)
                            $scope.maquinas = response.data.maquinas;
                            console.log(
                                "$scope.maquinas",
                                $scope.gridOptions)
                        },
                        function() {
                            alert("Error obteniendo la informacion de las unidades de medida")
                        });
            };

            $scope.gridOptions = {
                data: 'maquinas',
                showGroupPanel: true,
                enableSorting: true,
                enableFiltering: true,
                columnDefs: [

                    {
                        field: 'descMaquina',
                        displayName: 'Descripción',
                        cellTemplate: '',
                        width: 360
                    }, {
                        field: 'cantidad',
                        displayName: 'Cantidad de máquinas',
                        cellTemplate: '',
                        width: 180
                    },

                    {
                        field: 'minutosXPersona',
                        displayName: 'Minutos por persona',
                        cellTemplate: '',
                        width: 180
                    },

                    {
                        field: 'personasXMaquina',
                        displayName: 'Personas por máquina',
                        cellTemplate: '',
                        width: 180
                    },

                    {
                        field: 'Acciones',
                        displayName: 'Acciones',
                        cellTemplate: '<button ng-click="grid.appScope.edit(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button><button ng-click="grid.appScope.deleteM(row)" class="btn m-b-xs btn-sm btn-warning btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Eliminar</button>',
                        enableFiltering: false,
                        enableSorting: false,
                        width: 180
                    }
                ]
            };

            $scope.read();

            $scope.register = function() {
                var dialogOpts = {
                    backdrop: 'static',
                    keyboard: false,
                    templateUrl: 'resources/maquinas/modalRegistrarMaquina.html',
                    controller: 'ModalRegistrarMaquinaCtrl',
                    size: "sm",
                    windowClass: "modal",
                    resolve: {
                        route: $route
                    }
                };

                $uibModal.open(dialogOpts)

            };

            $scope.edit = function(row) {
                console.log("me dieron click", row.entity);
                var dialogOpts = {
                    backdrop: 'static',
                    keyboard: false,
                    templateUrl: 'resources/maquinas/modalEditarMaquina.html',
                    controller: 'ModalEditarMaquinaCtrl',
                    size: "sm",
                    windowClass: "modal",
                    resolve: {
                        maquina: function() {
                            return row.entity
                        },
                        route: $route
                    }
                };

                $uibModal.open(dialogOpts)

            };

            $scope.deleteM = function(row) {
                var data = {};

                data = {
                    idMaquina: row.entity.idMaquina,
                    descMaquina: row.entity.descMaquina,
                    cantidad: row.entity.cantidad
                };

                $http.post("rest/protected/Maquinas/delete", {
                    maquina: data
                }).then(function(response) {

                    switch (response.data.code) {
                        case 200:
                            $scope.reload();
                            break;

                        default:

                    }

                }, function(response) {

                    console.log(response);
                });
            };
        }
    ]);