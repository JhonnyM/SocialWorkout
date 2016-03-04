'use strict'

angular.module('myApp.listar_Maquina',['ngRoute','ui.grid','ui.grid.moveColumns'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  	.when('/listar_Maquina', {
	templateUrl: 'resources/listarMaquina/listar_Maquina.html',
    controller: 'listarMaquinaViewCtrl'
  });

}])

.controller('listarMaquinaViewCtrl',['$scope','$http',function($scope,$http){
	$scope.maquinas = [];
	$scope.requestObject = 
		{
		"idMaquina":0,
		"cantidad":0,
		"descMaquina":"",
		"minutosXPersona":0,
		"personasXMaquina":0,
		"maquinahasejercicios":[]
		};
	
		$http.post('rest/protected/Maquinas/getAll',$scope.requestObject).success(function(response){
			console.log("response",response)
			$scope.maquinas = response.maquinas;
			console.log("$scope.maquinas",$scope.gridOptions)
		});	
		
		$scope.gridOptions = {
			data:'maquinas',
			showGroupPanel: true,
			enableSorting:true,
			enableFiltering:true,
			columnDefs:[{field:'cantidad',displayName:'Cantidad de máquinas'},
			            {field:'descMaquina',displayName:'Descripción'},
			            {field:'minutosXPersona',displayName:'Minutos de uso'},
			            {field:'personasXMaquina',displayName:'Personas por máquina'},
			            ]
		};
		
		$scope.registerMaquina = function(){
			var dialogOpts = {
					backdrop:'static',
					keyboard:false,
					templateUrl:'resources/listarMaquina/register-modal-Maquina.html',
					controller:'Modal_Registrar_Maquina_Controller',
					size:"sm",
					windowClass:"modal"
//					,resolve:{
//						unidadMedida:function(){return row.entity}
//					}
			};
			$uibModal.open(dialogOpts)
		};		

		
}]);
