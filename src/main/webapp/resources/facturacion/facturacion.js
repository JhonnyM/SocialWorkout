'use strict';

angular.module('myApp.facturacion', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/facturacion', {
    templateUrl: 'resources/facturacion/facturacion.html',
    controller: 'FacturacionCtrl'
  });
}])

.controller('FacturacionCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
  $scope.usuarios = [];
  $scope.usuariosMorosos = [];
  $scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};

  $scope.read = function(){
    $http.get('rest/protected/users/all').then(function(response) {
      console.log("response",response)
      $scope.usuarios = response.data.usuarios;
      for (var i = 0; i < $scope.usuarios.length; i++){
        var testDate = new Date($scope.usuarios[i].fechaPago);
        console.log(testDate);
        if ($scope.dateFormatted(testDate)) {
          $scope.usuariosMorosos.push($scope.usuarios[i]);
        }else{
          alert("No se encontraron usuarios morosos");
        }
      };
    }, function(){
      alert("Error obteniendo la informacion de los usuarios morosos")
    });
  };

  $scope.read();

  $scope.gridOptions = {
    data:'usuariosMorosos',
    showGroupPanel: true,
    enableSorting:true,
    enableFiltering:true,
    columnDefs:[
        {field:'idUsuario',displayName:'ID'},
        {field:'nombre',displayName:'Nombre'},
        {field:'correoElectronico',displayName:'Email'},
        {field:'fechaPago',displayName:'Fecha de Pago'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.pagar(row)">Pagar</button>'}
    ]
  };

  $scope.pagar = function(row){
    alert("El mae ya pago");
  };

  $scope.datePlusMonth = function(date){
    return new Date(new Date(date).setMonth(date.getMonth()+1));
  };

  $scope.dateFormatted = function(date){
    var todayDate = new Date()
    var dateFromDb = new Date(date.getTime() + date.getTimezoneOffset()*60000);
    var dateToCompare = new Date(todayDate.getTime() + todayDate.getTimezoneOffset()*60000);
    if (dateFromDb.setHours(0,0,0,0) == dateToCompare.setHours(0,0,0,0)){
      return true;
    } else{
      return false;
    }
  }

}]);
