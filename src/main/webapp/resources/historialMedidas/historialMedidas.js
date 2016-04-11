//'use strict';
angular.module('myApp.historialMedidas', ['ngRoute', 'ui.grid', 'ui.bootstrap'])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/historialMedidas', {
    templateUrl: 'resources/historialMedidas/historialMedidas.html',
    controller: 'historialMedidasCtrl'
  });  
}])
.controller('historialMedidasCtrl', ['$scope', '$http', '$route', function($scope, $http, $route) {
    	$scope.usuario = {};
    	$scope.idUsuario = {};
    	$scope.registroMedidas = [];
        
    	$http.post('rest/protected/users/usuarioSet')
 		.success(function(response) {
 			$scope.usuario = response.usuario;
 			$scope.idUsuario = response.usuario.idUsuario;
 			
 			$scope.data = {};
            data = {
               idRegistroMedida: 0,
               usuarioPOJO: {
                           idUsuario: $scope.idUsuario
               }
            };
            console.log("JSON", {registroMedida : data});
            console.log("JSON", {registroMedida : data});
            console.log("USUARIO", $scope.idUsuario);
           $http.post('rest/protected/RegistrosMedidas/getAllByIdUsuario',{registroMedida : data}
           ).success(function(response) {
               $scope.registroMedidas = response.registroMedidaPOJO;
               console.log("DATA", response.registroMedidaPOJO);
               console.log("$scope.registroMedidas", $scope.gridOptions);

           }).error(
               function(data, status, config) {
                   console.log("$scope.data",
                       $scope.data)
                   alert("failure message: " +
                       JSON.stringify({
                           data: data
                       }));
               });
 		});

            $scope.gridOptions = {
                data: 'registroMedidas',
                showGroupPanel: true,
                enableSorting: true,
                enableFiltering: true,
                columnDefs: [

                    {
                        field: 'fecha',
                        displayName: 'Fecha de ingreso'
                    }, 
                    {
                        field: 'lugarmedicionPOJO.descLugarMedicion',
                        displayName: 'Lug.Medición'
                    },
                    {
                        field: 'cantidad',
                        displayName: 'Medición',
                    },
                    {
                        field: 'lugarmedicionPOJO.unidadMedidaPOJO.descUnidadMedida',
                        displayName: 'Un.Medida'
                    }
                ]
            };

            








        }
    ]);

