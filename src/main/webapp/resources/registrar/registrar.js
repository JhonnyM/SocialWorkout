'use strict';

angular.module('myApp.registrar', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registrar', {
    templateUrl: 'resources/registrar/registrar.html',
    controller: 'registroCtrl'
  });
}])

.controller('registroCtrl', ['$scope','$http','$uibModal', function($scope,$http,$uibModal) {
	$scope.clases = [];
  $scope.users = [];
  $scope.instructores = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","registro": {}};

  $http.get('rest/protected/users/all').success(function(response) {
    $scope.users = response.usuarios;
    console.log($scope.users);
  });

  $http.get('rest/protected/users/getInstructores').success(function(response) {
    $scope.instructores = response.usuarios;
    console.log($scope.users);
    });

	$scope.save = function(event){
    	
    var data = {};
  	console.log($scope.requestObject.desc);
    if ($scope.userExists($scope.requestObject.idUsuario) != null && $scope.isNumeric($scope.requestObject.idUsuario)){
      var userToSave = $scope.userExists($scope.requestObject.idUsuario);
      var instructorToSave = $scope.generateRandomInstructor();
      data = {
        horaSalida : $scope.fechaHoraSalidaUsuario(),
        fechaHoraIngreso : $scope.fechaHoraIngresoUsuario(),
        usuario1 : userToSave,
        usuario2 : instructorToSave

      };
  
      $http.post('rest/protected/registro/save', {registro: data})
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
        alert("Error al registrar el usuario");
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

  $scope.isNumeric = function(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
  }

}]);
