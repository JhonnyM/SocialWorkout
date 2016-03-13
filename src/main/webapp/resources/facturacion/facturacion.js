'use strict';

angular.module('myApp.facturacion', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/facturacion', {
    templateUrl: 'resources/facturacion/facturacion.html',
    controller: 'FacturacionCtrl'
  });
}])

.controller('FacturacionCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
  $scope.usuariosMorosos = [];
  $scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};

  $scope.read = function(){
      $http.get('rest/protected/usuarios/all').then(function(response) {
      console.log("response",response)
      $scope.usuariosMorosos = response.data.usuariosMorosos;
      console.log("$scope.clases", $scope.gridOptions)
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
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)">Pagar</button>'}
    ]
  };

  $scope.editRow = function(row){
     var dialogOpts = {
         backdrop:'static',
         keyboard:false,
         templateUrl:'resources/clases/edit-modal.html',
         controller:'ClasesModalCtrl',
         size:"lg",
         windowClass:"modal",
         resolve:{
             clase:function(){return row.entity}
         }
     };
     $uibModal.open(dialogOpts)
  };

}]);
