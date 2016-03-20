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
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","registro": {}};

  $http.get('rest/protected/users/all').success(function(response) {
    $scope.users = response.usuarios;
    console.log($scope.users);
  });

	$scope.save = function(event){
    	
    var data = {};
  	console.log($scope.requestObject.desc);
    if ($scope.userExists($scope.requestObject.idUsuario) != null ){
      var userToSave = $scope.userExists($scope.requestObject.idUsuario);
      data = {
        horaSalida : $scope.fechaHoraSalidaUsuario(),
        fechaHoraIngreso : $scope.fechaHoraIngresoUsuario(),
        usuario1 : { userToSave },
        usuario2 : { }

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
    return fechaHora.toString();
  };

  $scope.fechaHoraSalidaUsuario = function(){
    var fechaHora = new Date();
    fechaHora.setHours(fechaHora.getHours()+2);
    return fechaHora.toString();
  };

  $scope.generateRandomInstructor = function(){

  };

}]);
