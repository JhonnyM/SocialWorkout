'use strict'

angular
    .module('myApp.unidadesMedidas', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/unidadesMedidas', {
        templateUrl: 'resources/unidadesMedidas/unidadesMedidas.html',
        controller: 'UnidadesMedidasCtrl'
    });

}])

.controller(
    'UnidadesMedidasCtrl', [
        '$scope',
        '$http',
        '$uibModal',
        '$route',

        function($scope, $http, $uibModal, $route) {
            $scope.reload = function() {
                $route.reload();
            };
            $scope.unidadesMedidas = [];
            $scope.requestObject = {
                "pageNumber": 0,
                "pageSize": 0,
                "sortBy": [""],
                "searchColumn": "string",
                "searchTerm": "",
                "unidadMedida": {}
            };

            $scope.read = function() {
                $http
                    .get('rest/protected/UnidadesMedidas/getAll')
                    .then(
                        function(response) {

                            $scope.unidadesMedidas = response.data.unidadesMedidas;
                            console
                                .log(
                                    "$scope.unidadesMedidas",
                                    $scope.gridOptions)
                        },
                        function() {
                            alert("Error obteniendo la informacion de las unidades de medida")
                        });
            };



            $scope.gridOptions = {
                data: 'unidadesMedidas',
                showGroupPanel: true,
                enableSorting: true,
                enableFiltering: true,
                columnDefs: [{
                    field: 'descUnidadMedida',
                    displayName: 'Descripción',
                    cellTemplate: '',
                    width: 900
                }, {
                    field: 'Acciones',
                    displayName: 'Acciones',
                    cellTemplate: '<button ng-click="grid.appScope.edit(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button>',
                    //cellTemplate: '<button ng-click="grid.appScope.edit(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button><button ng-click="grid.appScope.deleteU(row)" class="btn m-b-xs btn-sm btn-warning btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Eliminar</button>',
                    enableFiltering: false,
                    enableSorting: false,
                    width: 180
                }]
            };

            $scope.read();

            $scope.edit = function(row) {
                var dialogOpts = {
                    backdrop: 'static',
                    keyboard: false,
                    templateUrl: 'resources/unidadesMedidas/modalEditarUnidadMedida.html',
                    controller: 'ModalEditarUnidadMedidaCtrl',
                    size: "sm",
                    windowClass: "modal",
                    resolve: {
                        unidadMedida: function() {
                            return row.entity
                        },
                        route: $route
                    }
                };
                $uibModal.open(dialogOpts)
            };

            $scope.register = function() {
                var dialogOpts = {
                    backdrop: 'static',
                    keyboard: false,
                    templateUrl: 'resources/unidadesMedidas/modalRegistrarUnidadMedida.html',
                    controller: 'ModalRegistrarUnidadMedidaCtrl',
                    size: "sm",
                    windowClass: "modal",
                    resolve: {
                        route: $route
                    }
                };

                $uibModal.open(dialogOpts)

            };

            $scope.deleteU = function(row) {
                var data = {};

                data = {

                    idUnidadMedida: row.entity.idUnidadMedida,
                    descUnidadMedida: row.entity.descUnidadMedida
                };

                $http
                    .post(
                        "rest/protected/UnidadesMedidas/delete", {
                            unidadMedida: data
                        })
                    .then(
                        function(response) {

                            switch (response.data.code) {
                                case 200:
                                    $scope.reload();
                                    break;
                                default:
                            }

                        },
                        function(response) {

                            console.log(response);
                        });
            };

        }
    ]);