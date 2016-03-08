'use strict';

angular.module('myApp.objetivos', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/objetivos', {
    templateUrl: 'resources/objetivos/objetivos.html',
    controller: 'ObjetivosCtrl'
  });
}])

.controller('ObjetivosCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
	$scope.objetivos = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};
	$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	console.log("response",response)
	$scope.objetivos = response.objetivoList;
	console.log("$scope.objetivos", $scope.gridOptions)
		
	});

    $scope.gridOptions = {
        data:'objetivos',
        showGroupPanel: true,
        enableSorting:true,
        enableFiltering:true,
        columnDefs:[
            {field:'idObjetivo',displayName:'ID'},
            {field:'descObjetivo',displayName:'Descripción'},
            {field:'Acciones', displayName:'Acciones',cellTemplate: '<p ng-click="grid.appScope.editRow(row)">Edit</p>'},
            {field:'Acciones', displayName:'Acciones',cellTemplate: '<p ng-click="grid.appScope.delete(row)">Delete</p>'}
        ]
    };

    $scope.editRow = function(row){
       console.log("me dieron click",row.entity);
       var dialogOpts = {
           backdrop:'static',
           keyboard:false,
           templateUrl:'resources/objetivos/edit-modal.html',
           controller:'ObjetivosModal',
           size:"lg",
           windowClass:"modal",
           resolve:{
               objetivo:function(){return row.entity}
           }
       };
       $uibModal.open(dialogOpts)
    };

	$scope.saveObjetivo = function(event){
    	
  	var data = {};
  	console.log($scope.requestObject.desc);

  	data = {
  			descObjetivo : $scope.requestObject.desc
  	};
  	
  	$http.post('rest/protected/objetivos/create', data)
  	.success(function(data, status, config) {
      $scope.message = data;
      }).error(function(data, status, config) {
        alert( "failure message: " + JSON.stringify({data: data}));
    }); 
  };

  $scope.delete = function (row){
    var data = {};
    data = {
        idObjetivo : row.entity.idObjetivo,
        descObjetivo : row.entity.descObjetivo
    };

    $http.post("rest/protected/objetivos/delete", {objetivo: data})
    .then(function (response){

      /**
       * Se muestra una notificación dependiendo del codigo de estatus recibido tras la llamada al servidor
       */
      switch(response.data.code)
      {
        case 200:
          alert("Objetivo Eliminado")
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
