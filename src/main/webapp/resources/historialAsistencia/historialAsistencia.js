'use strict';

angular.module('myApp.historialAsistencia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/historialAsistencia', {
    templateUrl: 'resources/historialAsistencia/historialAsistencia.html',
    controller: 'historialAsistenciaCtrl'
  });  
}])

.controller('historialAsistenciaCtrl', ['$scope','$http', function($scope,$http) {

	$scope.registros = {};
	 $http.post('rest/protected/registro/getRegistroIngresoByUsuario')
		.success(function(response) {
			$scope.registros = response.registros;
			for (var i = 0; i < $scope.registros.length; i++){
		        $scope.registros[i].fechaHoraIngreso = new Date($scope.registros[i].fechaHoraIngreso);
		        $scope.registros[i].horaSalida  = new Date($scope.registros[i].horaSalida);
		        /*if(){
		        	
		        }*/
		      };
			 console.log(response.registros,"REGISTRO");
		});
	$scope.gridOptions = { 
	        data: 'registros',
	        showGroupPanel: true,
	        enableSorting: true,
	        enableFiltering:true,
	        enableColumnResizing : true,
	        enableGridMenu : true,
	        showGridFooter : true,
	        showColumnFooter : true,
	        fastWatch : true,
	        columnDefs: [
	           {name:'fechaHoraIngreso', displayName:'Fecha asistencia',type: 'date', cellFilter: 'date:\'dd-MM-yyyy -- hh:mm a\''}, 
	           {name:'usuario2.nombre', displayName:'Instructor'},
	           {name:'plantillarutinamaestro.descRutina',  displayName:'Rutina'},
	           ]
	    };

	 		
}]);
