'use strict';

angular
    .module('myApp.eventosUsuarios', ['ngRoute', 'ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/eventosUsuarios', {
        templateUrl: 'resources/eventosUsuarios/eventosUsuarios.html',
        controller: 'eventosUsuariosCtrl'
    });
}])

.controller(
    'eventosUsuariosCtrl', [
        '$scope',
        '$http',
        '$uibModal',
        '$route',
        function($scope, $http, $uibModal,$route) {
            $scope.eventos = [];
            $scope.usuario = {};
            $scope.requestObject = {
                "pageNumber": 0,
                "pageSize": 0,
                "sortBy": [""],
                "searchColumn": "string",
                "searchTerm": "",
                "objetivo": {}
            };

			$scope.reload = function() {
				$route.reload();
			};

            
            $scope.read = function(){
                $http.get('rest/protected/eventos/allPendingEvents').then(function(response) {
                console.log("response",response)
                $scope.eventos = response.data.eventos;
                for (var i = 0; i < $scope.eventos.length; i++){
                  $scope.eventos[i].fechaHoraInicio = new Date($scope.eventos[i].fechaHoraInicio);
                  $scope.eventos[i].fechaHoraFinal  = new Date($scope.eventos[i].fechaHoraFinal);
                };
                console.log("$scope.eventos", $scope.gridOptions)
                }, function(){
                  alert("Error obteniendo la informacion de los eventos")
                });
            };
            $scope.read();

            $scope.gridOptions = {
                data: 'eventos',
                showGroupPanel: true,
                enableSorting: true,
                enableFiltering: true,
                columnDefs: [{
                    field: 'descEvento',
                    displayName: 'Descripción'
                }, {
                    field: 'fechaHoraInicio',
                    displayName: 'Hora de Inicio',
                    type: 'date',
                    cellFilter: 'date:\'dd-MM-yyyy -- hh:mm a\''
                }, {
                    field: 'fechaHoraFinal',
                    displayName: 'Hora Final',
                    type: 'date',
                    cellFilter: 'date:\'dd-MM-yyyy -- hh:mm a\''
                }, {
                    field: 'observaciones',
                    displayName: 'Observaciones'
                }, {
                    field: 'inscrito',
                    displayName: 'Estado inscripción'
                },
                
                {
                    field: 'Acciones',
                    displayName: 'Acciones',
                    cellTemplate: '<button ng-show= "!grid.appScope.getInscrito(row)" ng-click="grid.appScope.inscripcionEvento(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Registrarse al evento</button>',
                    enableFiltering: false,
                    enableSorting: false,
                    width: 180
                }, ]
            };

            $scope.getInscrito = function(row){
            	if(row.entity.inscrito == 'Evento ya inscrito'){
            		return true;
            	}else{
            		return false;
            	}
            };
            
            $scope.inscripcionEvento = function(row) {
                var data = {};

                data = {
                    idEvento: row.entity.idEvento,
                    usuario : {
                    	idUsuario: row.entity.usuario.idUsuario,
                    }
                };

				$http.post('rest/protected/eventos/assignEventoUsuario', {
					evento : data
				}).success(function(data, status, config) {
					$scope.message = data;				
					$scope.reload();
				}).error(function(data, status, config) {
					alert("failure message: " + JSON.stringify({
						data : data
					}));
				});
  
				$scope.reload();
                console.log("data", data)
            }

        }
    ]);