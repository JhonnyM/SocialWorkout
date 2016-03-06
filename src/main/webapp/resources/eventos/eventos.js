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

      console.log("response",response)
      $scope.eventos = response.data.eventos;
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
       console.log("me dieron click",row.entity);
       var dialogOpts = {
           backdrop:'static',
           keyboard:false,
           templateUrl:'resources/eventos/edit-modal.html',
           controller:'EventosModal',
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

      alert("Error fatal al momento de guardar la información del nuevo usuario");

    });
  };

  $scope.delete = function (row){
    var data = {};
    data = {
        idObjetivo : row.entity.idObjetivo,
        descObjetivo : row.entity.descObjetivo
    };

    $http.post("rest/protected/eventos/delete", {objetivo: data})
    .then(function (response){

      /**
       * Se muestra una notificación dependiendo del codigo de estatus recibido tras la llamada al servidor
       */
      switch(response.data.code)
      {
        case 200:
          alert("Evento Eliminado")
        break;

        default:
          alert(response.data.codeMessage);
      }
      
      /**
       * Se refresca la lista de todos los tipos de usuario existentes.
       */
      /**
      Poner algo aqui para refrescar la lista
      */

    }, function (response){

      console.log(response);
    }); 
  };

}]);
