'use strict';

angular.module('myApp.rutinas', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/rutinas', {
    templateUrl: 'resources/rutinas/rutinas.html',
    controller: 'rutinasCtrl'
  });
}])

.controller('rutinasCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
	$scope.rutinas = [];
  $scope.users = [];
  $scope.objetivos = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","rutinas": {}};

  $http.get('rest/protected/users/all').success(function(response) {
    console.log($scope.users);
  });

  $http.get('rest/protected/plantillas/all').success(function(response) {
    $scope.rutinas = response.plantillas;
    console.log($scope.rutinas);
  });

  $http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
    $scope.objetivos = response.objetivoList;
    console.log("$scope.objetivos", $scope.gridOptions)
  });

  $scope.gridOptions = {
    data:'rutinas',
    showGroupPanel: true,
    enableSorting:true,
    enableFiltering:true,
    columnDefs:[
        {field:'descRutina',displayName:'Descripción'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.edit(row)">Edit</button>'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.delete(row)">Delete</button>'}
    ]
  };

  $scope.edit = function(row){
    alert("To be implemented");
  };

  $scope.delete = function(row){
    alert("To be implemented");
  };

	$scope.save = function(event){
    	
    var data = {};
  	console.log($scope.requestObject.desc);
    if ($scope.userExists($scope.requestObject.idUsuario) != null ){
      var userToSave = $scope.userExists($scope.requestObject.idUsuario);
      var instructorToSave = $scope.generateRandomInstructor();
      data = {
        horaSalida : $scope.fechaHoraSalidaUsuario(),
        fechaHoraIngreso : $scope.fechaHoraIngresoUsuario(),
        usuario1 : userToSave,
        usuario2 : instructorToSave

      };
  
      $http.post('rest/protected/rutinas/save', {registro: data})
      .then(function (response){

        switch(response.data.code)
        {
          case 200:
            alert(response.data.codeMessage);
          break;

          default:
            alert(response.data.codeMessage);
        }
      }, function (response){
        alert("Error al crear la rutina");
      });

    }else{
      alert("Id " + $scope.requestObject.idUsuario + " Invalido");
    }
  };

  $scope.userExists = function(id){
    var user;
    var paramId = parseInt(id);
    for (var i = 0; i < $scope.users.length; i++){
      if ($scope.users[i].idUsuario == paramId){
        user = $scope.users[i];
        return user;
      }else{
        user = null;
        return user;
      }

    }
  };

  $scope.fechaHoraIngresoUsuario = function(){
    var fechaHora = new Date();
    return fechaHora.getTime();
  };

  $scope.fechaHoraSalidaUsuario = function(){
    var fechaHora = new Date();
    fechaHora.setHours(fechaHora.getHours()+2);
    return fechaHora.getTime();
  };

  $scope.generateRandomInstructor = function(){
    var rand = $scope.instructores[Math.floor(Math.random() * $scope.instructores.length)];
    return rand;
  };

}]);
