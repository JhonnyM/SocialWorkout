'use strict'

angular
		.module('myApp.ejercicios', [ 'ngRoute', 'ui.grid', 'ui.bootstrap' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/ejercicios', {
				templateUrl : 'resources/ejercicios/ejercicios.html',
				controller : 'EjerciciosCtrl'
			});

		} ])

		.controller(
				'EjerciciosCtrl',
				[
						'$scope',
						'$http',
						'$uibModal',
						function($scope, $http, $uibModal) {
							$scope.ejercicios = [];
							$scope.requestObject = {
								"pageNumber" : 0,
								"pageSize" : 0,
								"sortBy" : [ "" ],
								"searchColumn" : "string",
								"searchTerm" : "",
								"ejercicio" : {}
							};

							$scope.read = function() {
								$http
										.get('rest/protected/Ejercicios/getAll')
										.then(
												function(response) {

													console.log("response",
															response)
													$scope.ejercicios = response.data.ejercicios;
													console
															.log(
																	"$scope.ejercicios",
																	$scope.gridOptions)
												},
												function() {
													alert("Error obteniendo la informacion de los eventos")
												});
							};

							$scope.gridOptions = {
								data : 'ejercicios',
								showGroupPanel : true,
								enableSorting : true,
								enableFiltering : true,
								columnDefs : [

										{
											field : 'descEjercicio',
											displayName : 'Descripción'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.edit(row)">Edit</p>'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.deleteE(row)">Delete</p>'
										},

										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.assignMachine(row)">Delete</p>'
										} ]
							};

							$scope.read();

							$scope.register = function(read) {
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/ejercicios/modal_Registrar_Ejercicio.html',
									controller : 'modal_Registrar_EjercicioCtrl',
									size : "sm",
									windowClass : "modal"
								};

								$uibModal.open(dialogOpts)
							};
							$scope.read();

							$scope.edit = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/ejercicios/modal_Editar_Ejercicio.html',
									controller : 'modal_Editar_EjercicioCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										ejercicio : function() {
											return row.entity
										}
									}
								};

								$uibModal.open(dialogOpts)

							};

							$scope.deleteE = function(row) {
								var data = {};

								data = {
									idEjercicio : row.entity.idEjercicio,
									descEjercicio : row.entity.descEjercicio
								};

								$http.post("rest/protected/Ejercicios/delete",
										{
											ejercicio : data
										}).then(function(response) {

									switch (response.data.code) {
									case 200:
										alert("Ejercicio eliminada.")
										break;

									default:
										alert(response.data.codeMessage);
									}

								}, function(response) {

									console.log(response);
								});
							};

							$scope.assignMachine = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/ejercicios/modal_Registrar_Maquina_Ejercicio.html',
									controller : 'modal_Registrar_Maquina_EjercicioCtrl',
									size : "md",
									windowClass : "modal",
									resolve : {
										ejercicio : function() {
											return row.entity
										}
									}
								};

								$uibModal.open(dialogOpts)

							};

						} ]);
