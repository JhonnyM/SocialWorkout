'use strict'

angular
		.module('myApp.registrosMedidas',
				[ 'ngRoute', 'ui.grid', 'ui.bootstrap' ])

		.config(
				[
						'$routeProvider',
						function($routeProvider) {
							$routeProvider
									.when(
											'/registrosMedidas',
											{
												templateUrl : 'resources/registrosMedidas/registrosMedidas.html',
												controller : 'RegistrosMedidasCtrl'
											});

						} ])

		.controller(
				'RegistrosMedidasCtrl',
				[
						'$scope',
						'$http',
						'$uibModal',
						'$route',
						function($scope, $http, $uibModal, $route) {

							$scope.reload = function() {
								$route.reload();
							};

							$scope.registrosMedidas = [];
							$scope.requestObject = {
								"pageNumber" : 0,
								"pageSize" : 0,
								"sortBy" : [ "" ],
								"searchColumn" : "string",
								"searchTerm" : "",
								"registroMedida" : {}
							};

							$scope.read = function() {
								$http
										.get(
												'rest/protected/RegistrosMedidas/getAll')
										.then(
												function(response) {

													console.log("response",
															response)
													$scope.registrosMedidas = response.data.registroMedidaPOJO;
													console
															.log(
																	"$scope.registrosMedidas",
																	$scope.gridOptions)
												},
												function() {
													alert("Error obteniendo los registros de medidas.")
												});
							};

							$scope.gridOptions = {
								data : 'registrosMedidas',
								showGroupPanel : true,
								enableSorting : true,
								enableFiltering : true,
								columnDefs : [

										{
											field : 'fecha',
											displayName : 'Fecha de registro'
										},
										{
											field : 'cantidad',
											displayName : 'Medida'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.edit(row)">Editar</p>'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.deleteRM(row)">Eliminar</p>'
										} ]
							};

							$scope.read();

							$scope.register = function() {
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/registroMedida/modal_Registrar_RegistroMedida.html',
									controller : 'modal_Registrar_RegistroMedidaCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										route : $route
									}
								};

								$uibModal.open(dialogOpts)

							};

							$scope.edit = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/registroMedida/modal_Editar_RegistroMedida.html',
									controller : 'modal_Editar_RegistroMedidaCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
										maquina : function() {
											return row.entity
										},
										route : $route
									}
								};

								$uibModal.open(dialogOpts)

							};

							// $scope.deleteRM = function(row) {
							// var data = {};
							//
							// data = {
							// idMaquina : row.entity.idMaquina,
							// descMaquina : row.entity.descMaquina,
							// cantidad : row.entity.cantidad
							// };
							//
							// $http.post("rest/protected/Maquinas/delete", {
							// maquina : data
							// }).then(function(response) {
							//
							// switch (response.data.code) {
							// case 200:
							// $scope.reload();
							// break;
							//
							// default:
							//
							// }
							//
							// }, function(response) {
							//
							// console.log(response);
							// });
							// };
						} ]);
