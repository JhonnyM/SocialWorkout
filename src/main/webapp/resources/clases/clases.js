'use strict';

angular.module('myApp.clases', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/clases', {
    templateUrl: 'resources/clases/clases.html',
    controller: 'ClasesCtrl'
  });
}])

.controller('ClasesCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
	$scope.clases = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};

  $scope.read = function(){
      $http.get('rest/protected/clases/all').then(function(response) {
      console.log("response",response)
      $scope.clases = response.data.clases;
      console.log("$scope.clases", $scope.gridOptions)
      }, function(){
        alert("Error obteniendo la informacion de las clases")
      });
  };

  $scope.read();

  $scope.gridOptions = {
    data:'clases',
    showGroupPanel: true,
    enableSorting:true,
    enableFiltering:true,
    columnDefs:[
        {field:'idClase',displayName:'ID'},
        {field:'descClase',displayName:'Descripción'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)">Edit</button>'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.delete(row)">Delete</button>'}
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

	$scope.saveClase = function(event){
    	
    var data = {};
  	console.log($scope.requestObject.desc);

    data = {
      descClase : $scope.requestObject.desc,
    };
  
    $http.post('rest/protected/clases/save', {clase: data})
    .then(function (response){

      switch(response.data.code)
      {
        case 200:
          alert(response.data.codeMessage);
        break;

        default:
          alert(response.data.codeMessage);
      }
      $scope.read();
    }, function (response){
      alert("Error al guardar la información de la nueva clase");
    });
  };

  $scope.delete = function (row){
    var data = {};
    data = {
      idClase : row.entity.idClase,
      descClase : row.entity.descClase,
    };

    $http.post('rest/protected/clases/delete', {clase: data})
    .then(function (response){

      switch(response.data.code)
      {
        case 200:
          alert("Clase Eliminada")
        break;

        default:
          alert(response.data.codeMessage);
      }
      $scope.read();
    }, function (response){
      alert("Error al eliminar la información de la clase");
    }); 
  };

}]);
