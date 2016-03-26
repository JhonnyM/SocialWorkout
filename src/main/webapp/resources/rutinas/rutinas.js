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
    $scope.users = response.usuarios;
    console.log($scope.users);
  });


  $scope.read = function(){
    $http.get('rest/protected/plantillas/all').success(function(response) {
      $scope.rutinas = response.plantillas;
      console.log($scope.rutinas);
    }, function(){
      alert("Error obteniendo la informacion de las rutinas");
    });
  };

  $scope.read();

  $http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
    $scope.objetivos = response.objetivoList;
    console.log("$scope.objetivos", $scope.objetivos)
  });

  $scope.gridOptions = {
    data:'rutinas',
    showGroupPanel: true,
    enableSorting:true,
    enableFiltering:true,
    columnDefs:[
        {field:'descRutina',displayName:'Descripción'},
        {field:'rutinaBase',displayName:'Es Rutina Base'},
        {field:'Acciones', displayName:'Acciones',cellTemplate: '<button ng-click="grid.appScope.edit(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button>&nbsp;&nbsp;&nbsp;<button ng-click="grid.appScope.addRutinaDetalle(row)" class="btn btn-info btn-addon"><i class="fa fa-cog pull-right"></i>Agregar Detalles</button>'}

    ]
  };

  $scope.edit = function(row){
    alert("To be implemented");
  };

  $scope.addRutinaDetalle = function(row){
    alert("To be implemented");
  };

	$scope.save = function(event){
    	
    var data = {};
    var userToSave = {};
    var objetivoToSave = {};
    objetivoToSave = $scope.objetivos.find($scope.findObjetivo);
    data = {
      objetivo : objetivoToSave,
      descRutina : $scope.requestObject.desc,
      rutinaBase : $scope.requestObject.base
    };
    console.log(data);
    
    $http.post('rest/protected/plantillas/save', {plantillaRutinaMaestro: data})
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
       alert("Error al crear la rutina");
     })
  };

  $scope.userExists = function(id){
    var user;
    var paramId = parseInt(id);
    for (var x in $scope.users){

    }
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

 $scope.findObjetivo = function (objetivo) { 
    return objetivo.idObjetivo === $scope.requestObject.idObjetivo;
  }

}]);
