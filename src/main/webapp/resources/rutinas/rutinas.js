'use strict';

angular.module('myApp.rutinas', ['ngRoute','ui.grid', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/rutinas', {
    templateUrl: 'resources/rutinas/rutinas.html',
    controller: 'rutinasCtrl'
  });
}])

.controller('rutinasCtrl', ['$scope','$http','$uibModal', '$filter','$route', function($scope,$http,$uibModal,$filter,$route) {
  $scope.rutinas = [];
  $scope.rutina = $filter('orderBy')($scope.rutinas, 'first')[0];
  $scope.rutinaAEditar = {};
  $scope.users = [];
  $scope.objetivos = [];
  $scope.detalles = [];
  $scope.ejercicios = [];
  $scope.maquinas = [];
  $scope.relationHas = [];
  $scope.updateEjercicio = {};
  $scope.excludeEmptyDetalles = {};
  $scope.idRelation = [];
  $scope.rutinaMaestroMaquinaHasEjercicio = [];
  $scope.detallesSeleccionados = [];
  $scope.detallesDelItemSeleccionado = [];
  $scope.maquinaHasEjercicios = {};
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","rutinas": {}};


  $scope.read = function(){
    
    $http.get('rest/protected/Maquinahasejercicios/all',$scope.requestObject).success(function(response) {
      $scope.maquinaHasEjercicios = response.maquinaEjercicio;
    });

    $http.get('rest/protected/plantillas/all').success(function(response) {
      $scope.rutinas = response.plantillas;
    }, function(){
      alert("Error obteniendo la informacion de las rutinas");
    });

    $http.get('rest/protected/plantillaDetalles/all').success(function(response) {
      $scope.detalles = response.plantillasDetalle;
      $scope.rutinaMaestroMaquinaHasEjercicio = $scope.detalles.maquinahasejercicios
    });

    $http.get('rest/protected/Ejercicios/getAll').then(function(response) {
      $scope.ejercicios = response.data.ejercicios;
    });

    $http.get('rest/protected/Maquinas/getAll').then(function(response) {
      $scope.maquinas = response.data.maquinas;
    });

  };


  $scope.read();

  $http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
    $scope.objetivos = response.objetivoList;
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

	$scope.save = function(event){
    	
    var data = {};
    var userToSave = {};
    var objetivoToSave = {};
    var detallesToSave = [];
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

 $scope.findObjetivo = function (objetivo) { 
    return objetivo.idObjetivo === $scope.requestObject.idObjetivo;
  };

  $scope.findDetalleRutina = function (detalle) { 
    return detalle.idPLantillaRutinaDetalle === $scope.requestObject.idPLantillaRutinaDetalle;
  };


  $scope.createRutina = function(){
    var dialogOpts = {
        backdrop:'static',
        keyboard:false,
        templateUrl:'resources/rutinas/nueva-rutina-maestro.html',
        controller:'RutinaMaestroCtrl',
        size:"sx",
        windowClass:"modal",
        resolve:{
          rutina: {},
          route : $route,
        }
    };
      
    $uibModal.open(dialogOpts)
  };

  $scope.checkItem = function(obj, arr, key){
    var i=0;
    angular.forEach(arr, function(item) {
      if(item[key].indexOf( obj[key] ) == 0){
        var j = item[key].replace(obj[key], '').trim();
        if(j){
          i = Math.max(i, parseInt(j)+1);
        }else{
          i = 1;
        }
      }
    });
    return obj[key] + (i ? ' '+i : '');
  };

  $scope.deleteGroup = function(item){
    $scope.rutinas.splice($scope.rutinas.indexOf(item), 1);
  };

  $scope.selectGroup = function(item){    
    console.log("selectGroup parametro", item)   
    angular.forEach($scope.rutinas, function(item) { 
      item.selected = false;
    });
    $scope.rutinaAEditar = item;
    $scope.setGlobalSelecteIdRelation($scope.rutinaAEditar);
    $scope.detallesSeleccionados = item.plantillarutinadetalles;
    $scope.rutinaAEditar.selected = true;
    $scope.filter = item.name;
  };

  $scope.selectItem = function(item){ 
    console.log("selectItem parametro", item)   
    angular.forEach($scope.detallesSeleccionados, function(item) {
      console.log("Item dentro del for", item) 
      item.selected = false;
      item.editing = false;
    });
    $scope.detallesDelItemSeleccionado = item.plantillarutinadetalles;
    $scope.item = item;
    $scope.item.selected = true;
  };

  $scope.doneEditing = function(item){
    item.editing = false;
  };

  $scope.addRutinaDetalle = function(row){
    if($scope.rutinaAEditar.selected == true){
      var dialogOpts = {
       backdrop:'static',
       keyboard:false,
       templateUrl:'resources/rutinas/agregar-rutina-detalle.html',
       controller:'RutinaDetalleCtrl',
       size:"lg",
       windowClass:"modal",
       resolve:{
            rutina: $scope.rutinaAEditar,
            detalle: {},
            route : $route,
          }
      };
      $uibModal.open(dialogOpts)
    } else {
      alert("Seleccione una rutina");
    };
  };

  $scope.updatePlantilla = function() {
      
    $scope.data = {};

    data = {
      idClase : $scope.claseForm.idClase,
    descClase : $scope.claseForm.descClase
    };

    $http.post('rest/protected/plantillas/update',{plantillaRutinaMaestro: data})
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

  $scope.findEjercicio = function(ejercicio) {
    return ejercicio.maquinahasejercicios.idEjercicioXMaquina === selectedEjercicioRelation.maquinahasejercicios.idEjercicioXMaquina;
  };

  $scope.findMaquinaHasEjercicio = function(rutina) {
    return rutina.idEjercicioXMaquina === $scope.requestObject.idEjercicio;
  };

  $scope.setGlobalSelecteIdRelation = function(){
    if($scope.rutinaAEditar.plantillarutinadetalles.length > 0){
      for(var j = 0; j< $scope.rutinaAEditar.plantillarutinadetalles.length;j++){
        var idToComparre = $scope.rutinaAEditar.plantillarutinadetalles[j].maquinahasejercicio.idEjercicioXMaquina;
        for(var f =0; f< $scope.maquinaHasEjercicios.length; f++){
          if(idToComparre === $scope.maquinaHasEjercicios[f].idEjercicioXMaquina){
            $scope.rutinaAEditar.plantillarutinadetalles[j].maquinahasejercicio = $scope.maquinaHasEjercicios[f];
          }
        }
      }
    }
  };

  $scope.editDetalle = function(item){
    if($scope.rutinaAEditar.selected == true){
      var dialogOpts = {
       backdrop:'static',
       keyboard:false,
       templateUrl:'resources/rutinas/editar-rutina-detalle.html',
       controller:'EditarRutinaDetalleCtrl',
       size:"lg",
       windowClass:"modal",
       resolve:{
            rutina: $scope.rutinaAEditar,
            detalle: item,
            route : $route,
          }
      };
      $uibModal.open(dialogOpts)
    } else {
      alert("Seleccione una rutina");
    };
  };

  $scope.editItem = function(item){
    if(item && item.selected){
      var dialogOpts = {
        backdrop:'static',
        keyboard:false,
        templateUrl:'resources/rutinas/editar-rutina-maestro.html',
        controller:'EditarRutinaMaestroCtrl',
        size:"sx",
        windowClass:"modal",
        resolve:{
          rutina: item,
          route : $route,
        }
      };
      
      $uibModal.open(dialogOpts)
    }
  };

}]);
