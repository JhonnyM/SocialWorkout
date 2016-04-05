'use strict';

angular.module('myApp.eventosUsuarios', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/eventosUsuarios', {
    templateUrl: 'resources/eventos/eventosUsuarios.html',
    controller: 'eventosUsuariosCtrl'
  });
}])

.controller('eventosUsuariosCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
	$scope.eventos = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};

  $scope.read = function(){
      $http.get('rest/protected/eventos/all').then(function(response) {
      console.log(new Date(response.data.eventos[1].fechaHoraFinal));
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
    data:'eventos',
    showGroupPanel: true,
    enableSorting:true,
    enableFiltering:true,
    columnDefs:[
        {field:'descEvento',displayName:'Descripción'},
        {field:'fechaHoraInicio',displayName:'Hora de Inicio', type: 'date', cellFilter: 'date:\'dd-MM-yyyy -- hh:mm a\''},
        {field:'fechaHoraFinal',displayName:'Hora Final', type: 'date', cellFilter: 'date:\'dd-MM-yyyy -- hh:mm a\''},
        {field:'observaciones',displayName:'Observaciones'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button><button ng-click="grid.appScope.borrar(row)" class="btn m-b-xs btn-sm btn-warning btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Eliminar</button>', enableFiltering: false, enableSorting: false, width: 180},
    ]
  };


}]);
