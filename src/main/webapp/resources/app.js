'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.objetivos',
  'myApp.eventos',
  'myApp.eventosModal',
  'myApp.usuarios',
  'myApp.tiposUsuario',
  'myApp.version',
  'myApp.modal',
  'myApp.modalTipoUsuario',
  'myApp.miPerfil',
  'myApp.modalu',
  'myApp.lugarMedicion',
  'myApp.modalm',
  'myApp.ocupacion',
  'myApp.home',
  'myApp.clases',
  'myApp.clasesModal',
  'myApp.facturacion',
  'myApp.registrar',
  'myApp.rutinas',
  'myApp.modalRutinaMaestro',
  'myApp.rutinaDetalleModal',
  'myApp.historialAsistencia',
  'myApp.historialMedidas',
  'myApp.ocupacionMaquinas',
  'myApp.misRutinas',
  'ui.grid',
  'angularFileUpload',
  'myApp.unidadesMedidas',
  'myApp.ocupacionGeneral',
  'myApp.modalEditarUnidadMedida',
  'myApp.modalRegistrarUnidadMedida',
  'myApp.maquinas',
  'myApp.modalEditarMaquina',
  'myApp.modalRegistrarMaquina',
  'myApp.ejercicios',
  'myApp.modalRegistrarEjercicio',
  'myApp.modalEditarEjercicio', 
  'myApp.modalRegistrarMaquinaEjercicio',
  'myApp.registrosMedidas',
  'myApp.modalHistorialMedida',
  'myApp.modalRegistrarMedida', 
  'myApp.modalEditarMedida',
  'myApp.usuariosAdministrador',
  'myApp.eventosUsuarios',
  'myApp.editarRutinaDetalleModal',
  'myApp.modalEditarRutinaMaestro'
])
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/view1'});
  
	$provide.factory('responseHttpInterceptor', function($q) {
		  return {
		    response: function(response) {
		      // do something on success
		      return response;
		    },
		    responseError: function(response) {
		      // do something on error
		    	if(response.status === 401){
					window.location.href = "/socialWorkout/#/login";
				}
		      return $q.reject(response);
		    }
		  };
		});
	
	$httpProvider.interceptors.push('responseHttpInterceptor');
	
	//RESPONSE INTERCEPTOR FOR ALL THE JQUERY CALLS: EX:THE JQGRID
	$.ajaxSetup({
	    beforeSend: function() {
	    },
	    complete: function(response) {
	    	if(response.status === 401){
	    		window.location.href = "/socialWorkout/#/login";
			}
	    }
	});
  
}]);
