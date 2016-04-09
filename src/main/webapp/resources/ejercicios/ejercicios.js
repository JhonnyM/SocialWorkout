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
						'$route',
						function($scope, $http, $uibModal,$route) {
						
							$scope.reload = function() {
								$route.reload();
							};

							
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
											cellTemplate : '<button ng-click="grid.appScope.edit(row)" class="btn m-b-xs btn-sm btn-success btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Editar</button><button ng-click="grid.appScope.deleteE(row)" class="btn m-b-xs btn-sm btn-warning btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Eliminar</button><button ng-click="grid.appScope.assignMachine(row)" class="btn m-b-xs btn-sm btn-primary btn-addon"><i class="fa fa-pencil-square-o pull-right"></i>Asignar máquina</button>', enableFiltering: false, enableSorting: false, width: 350},
										 ]
							};

							$scope.read();

							$scope.register = function(read) {
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/ejercicios/modalRegistrarEjercicio.html',
									controller : 'ModalRegistrarEjercicioCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										route : $route
									}									
								};

								$uibModal.open(dialogOpts)
							};
							$scope.read();

							$scope.edit = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/ejercicios/modalEditarEjercicio.html',
									controller : 'ModalEditarEjercicioCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										ejercicio : function() {
											return row.entity},
											route : $route	
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
										$scope.reload();
										break;

									default:
										$scope.reload();
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
									templateUrl : 'resources/ejercicios/modalRegistrarMaquinaEjercicio.html',
									controller : 'ModalRegistrarMaquinaEjercicioCtrl',
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
