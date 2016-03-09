'use strict';

angular.module('myApp.eventos', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/eventos', {
    templateUrl: 'resources/eventos/eventos.html',
    controller: 'EventosCtrl'
  });
}])

.controller('EventosCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
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
        {field:'idEvento',displayName:'ID'},
        {field:'descEvento',displayName:'Descripción'},
        {field:'fechaHoraInicio',displayName:'Hora de Inicio'},
        {field:'fechaHoraFinal',displayName:'Hora Final'},
        {field:'observaciones',displayName:'Observaciones'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.editRow(row)">Edit</button>'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.delete(row)">Delete</button>'}
    ]
  };

  $scope.editRow = function(row){
     var dialogOpts = {
         backdrop:'static',
         keyboard:false,
         templateUrl:'resources/eventos/edit-modal.html',
         controller:'EventosModalCtrl',
         size:"lg",
         windowClass:"modal",
         resolve:{
             evento:function(){return row.entity}
         }
     };
     $uibModal.open(dialogOpts)
  };

	$scope.saveEvento = function(event){
    	
    var data = {};
  	console.log($scope.requestObject.desc);

    data = {
      descEvento : $scope.requestObject.desc,
      fechaHoraInicio: $scope.requestObject.ini,
      fechaHoraFinal: $scope.requestObject.fin,
      observaciones: $scope.requestObject.obs,
    };
  
    $http.post('rest/protected/eventos/save', {evento: data})
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
      alert("Error al de guardar la información del nuevo evento");
    });
  };

  $scope.delete = function (row){
    var data = {};
    data = {
      idEvento : row.entity.idEvento,
      descEvento : row.entity.descEvento,
      fechaHoraInicio: row.entity.fechaHoraInicio,
      fechaHoraFinal: row.entity.fechaHoraFinal,
      observaciones: row.entity.observaciones,
    };

    $http.post("rest/protected/eventos/delete", {evento: data})
    .then(function (response){

      switch(response.data.code)
      {
        case 200:
          alert("Evento Eliminado")
        break;

        default:
          alert(response.data.codeMessage);
      }
      
      $scope.read();

    }, function (response){

      console.log(response);
    }); 
  };

  $scope.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();

    $scope.opened = true;
  };

  $scope.dateOptions = {
      formatYear: 'yy',
      startingDay: 1,
      class: 'datepicker'
  };

  $scope.open1 = function() {
    $scope.popup1.opened = true;
  };

  $scope.open2 = function() {
    $scope.popup2.opened = true;
  };

  $scope.setDate = function(year, month, day) {
    $scope.dt = new Date(year, month, day);
  };

  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
  $scope.format = $scope.formats[0];
  $scope.altInputFormats = ['M!/d!/yyyy'];

  $scope.popup1 = {
    opened: false
  };

  $scope.popup2 = {
    opened: false
  };


}]);
