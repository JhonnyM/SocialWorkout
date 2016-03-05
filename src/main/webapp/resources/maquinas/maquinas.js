'use strict'

angular
		.module('myApp.maquinas', [ 'ngRoute', 'ui.grid', 'ui.bootstrap' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/maquinas', {
				templateUrl : 'resources/maquinas/maquinas.html',
				controller : 'MaquinasCtrl'
			});

		} ])

		.controller(
				'MaquinasCtrl',
				[
						'$scope',
						'$http',
						'$uibModal',
						function($scope, $http, $uibModal) {
							$scope.maquinas = [];
							$scope.requestObject = {
								"idMaquina" : 0,
								"cantidad" : 0,
								"descMaquina" : "",
								"minutosXPersona" : 0,
								"personasXMaquina" : 0,
								"maquinahasejercicios" : []
							};

							$http.post('rest/protected/Maquinas/getAll',
									$scope.requestObject).success(
									function(response) {
										console.log("response", response)
										$scope.maquinas = response.maquinas;
										console.log("$scope.maquinas",
												$scope.gridOptions)
									});

							$scope.gridOptions = {
								data : 'maquinas',
								showGroupPanel : true,
								enableSorting : true,
								enableFiltering : true,
								columnDefs : [

										{
											field : 'descMaquina',
											displayName : 'Descripción'
										},
										{
											field : 'cantidad',
											displayName : 'Cantidad de máquinas'
										},
										{
											field : 'minutosXPersona',
											displayName : 'Minutos de uso'
										},
										{
											field : 'personasXMaquina',
											displayName : 'Personas por máquina'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.edit(row)">Edit</p>'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.deleteM(row)">Delete</p>'
										} ]
							};

							$scope.register = function() {
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/maquinas/modal_Registrar_Maquina.html',
									controller : 'modal_Registrar_MaquinaCtrl',
									size : "sm",
									windowClass : "modal"
								};

								$uibModal.open(dialogOpts)

							};

							$scope.edit = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/maquinas/modal_Editar_Maquina.html',
									controller : 'modal_Editar_MaquinaCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										maquina : function() {
											return row.entity
										}
									}
								};

								$uibModal.open(dialogOpts)

							};

							$scope.deleteM = function(row) {
								var data = {};

								data = {
									idMaquina : row.entity.idMaquina,
									descMaquina : row.entity.descMaquina,
									cantidad : row.entity.cantidad,
									personasXMaquina : row.entity.personasXMaquina,
									minutosXPersona : row.entity.minutosXPersona
								};

								$http.post("rest/protected/Maquinas/delete", {
									maquina : data
								}).then(function(response) {

									switch (response.data.code) {
									case 200:
										alert("Máquina eliminada.")
										break;

									default:
										alert(response.data.codeMessage);
									}

								}, function(response) {

									console.log(response);
								});
							};

							};
						} ]);
