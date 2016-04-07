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
  'myApp.historialAsistencia',
  'myApp.historialMedidas',
  'ui.grid',
  'angularFileUpload',
  'myApp.unidadesMedidas',
  'myApp.ocupacionGeneral',
  'myApp.modal_Editar_Unidad_Medida',
  'myApp.modal_Registrar_Unidad_Medida',
  'myApp.maquinas',
  'myApp.modal_Editar_Maquina',
  'myApp.modal_Registrar_Maquina',
  'myApp.ejercicios',
  'myApp.modal_Registrar_Ejercicio',
  'myApp.modal_Editar_Ejercicio', 
  'myApp.modal_Registrar_Maquina_Ejercicio',
  'myApp.registrosMedidas',
  'myApp.modal_Historial_Medida',
  'myApp.modal_Registrar_Medida', 
  'myApp.modal_Editar_Medida',
  'myApp.usuariosAdministrador',
  'myApp.eventosUsuarios'
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
