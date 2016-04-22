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
	
  $scope.read = function(){
    $http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
      $scope.objetivos = response.objetivoList;
    });

  };

  $scope.read();

    $scope.gridOptions = {
        data:'objetivos',
        showGroupPanel: true,
        enableSorting: true,
        enableFiltering:true,
        enableColumnResizing : true,
        enableGridMenu : true,
        showGridFooter : true,
        showColumnFooter : true,
        fastWatch : true,
        columnDefs:[
            {field:'descObjetivo',displayName:'Descripción'},
            {field:'Acciones', displayName:'Acciones',cellTemplate:'<button ng-click="grid.appScope.editRow(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button>', enableFiltering: false, enableSorting: false, width: 180}
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

    if($scope.isNumeric($scope.requestObject.desc)){
      $http.post('rest/protected/objetivos/create', data)
      .success(function(data, status, config) {
        $scope.message = data;
      }).error(function(data, status, config) {
        alert( "failure message: " + JSON.stringify({data: data}));
      }); 
      $scope.read();

    } else {
      alert("Por favor ingresar todos los datos y no ingresar numeros")
    }
    $scope.clearInputs();
  
  };

  $scope.del = function (row){
    var data = {};
    data = {
        idObjetivo : row.entity.idObjetivo,
        descObjetivo : row.entity.descObjetivo
    };

    $http.post("rest/protected/objetivos/delete", {objetivo: data})
    .then(function (response){

      switch(response.data.code)
      {
        case 200:
          alert("Objetivo Eliminado")
        break;

        default:
          alert(response.data.codeMessage);
      }
      
      $scope.read();

    }, function (response){

      console.log(response);
    }); 
  };


  $scope.isNumeric = function(n) {
    return isNaN(parseFloat(n)) && !isFinite(n) && n != null;
  };

  $scope.clearInputs = function () {
    $scope.requestObject.desc = null;
  };

}]);
