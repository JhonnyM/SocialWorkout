'use strict'

angular
		.module('myApp.unidadesMedidas',
				[ 'ngRoute', 'ui.grid', 'ui.bootstrap' ])

		.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/unidadesMedidas', {
				templateUrl : 'resources/unidadesMedidas/unidadesMedidas.html',
				controller : 'UnidadesMedidasCtrl'
			});

		} ])

		.controller(
				'UnidadesMedidasCtrl',
				[
						'$scope',
						'$http',
						'$uibModal',
						'$route',
						
						function($scope, $http, $uibModal,$route) {
							$scope.reload = function(){
								 $route.reload();
							};
							$scope.unidadesMedidas = [];
							$scope.requestObject = {
									"pageNumber" : 0,
									"pageSize" : 0,
									"sortBy" : [ "" ],
									"searchColumn" : "string",
									"searchTerm" : "",
									"unidadMedida" : {}
								};
	
							$scope.read = function() {
								$http
										.get('rest/protected/UnidadesMedidas/getAll')
										.then(
												function(response) {

													console.log("response",
															response)
													$scope.unidadesMedidas = response.data.unidadesMedidas;
													console
															.log(
																	"$scope.unidadesMedidas",
																	$scope.gridOptions)
												},
												function() {
													alert("Error obteniendo la informacion de las unidades de medida")
												});
							};



							$scope.gridOptions = {
								data : 'unidadesMedidas',
								showGroupPanel : true,
								enableSorting : true,
								enableFiltering : true,
								columnDefs : [
										{
											field : 'descUnidadMedida',
											displayName : 'Descripción'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.edit(row)">Editar</p>'
										},
										{
											field : 'Acciones',
											displayName : 'Acciones',
											cellTemplate : '<p ng-click="grid.appScope.deleteU(row)">Eliminar</p>'
										} ]
							};

							$scope.read();
							
							$scope.edit = function(row) {
								console.log("me dieron click", row.entity);
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/unidadesMedidas/modal_Editar_Unidad_Medida.html',
									controller : 'modal_Editar_Unidad_MedidaCtrl',
									size : "sm",
									windowClass : "modal",
									resolve : {
									unidadMedida : function() {
											return row.entity
									},
									route : $route
									}
								};
								$uibModal.open(dialogOpts)
							};
							
							$scope.register = function() {
								var dialogOpts = {
									backdrop : 'static',
									keyboard : false,
									templateUrl : 'resources/unidadesMedidas/modal_Registrar_Unidad_Medida.html',
									controller : 'modal_Registrar_Unidad_MedidaCtrl',
									size : "sm",
									windowClass : "modal",
									resolve:{
										route : $route
									}
								};

								$uibModal.open(dialogOpts)

							};

							$scope.deleteU = function(row) {
								var data = {};

								data = {

									idUnidadMedida : row.entity.idUnidadMedida,
									descUnidadMedida : row.entity.descUnidadMedida
								};

								console.log("data", data);

								$http
										.post(
												"rest/protected/UnidadesMedidas/delete",
												{
													unidadMedida : data
												})
										.then(
												function(response) {

													switch (response.data.code) {
													case 200:
														$scope.reload();
														break;
													default:
													}

												}, function(response) {

													console.log(response);
												});
							};

						} ]);
