//'use strict';

angular.module('myApp.modal_Historial_Medida',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'modal_Historial_Medida_Ctrl',
		[ '$scope', '$http', '$uibModalInstance','$uibModal', 'usuario', '$route',
				function($scope, $http, $uibModalInstance, $uibModal, usuario, $route) {

					$scope.reload = function() {
						$route.reload();
					};

					$scope.usuarioForm = angular.copy(usuario);
					
					$scope.registroMedidas = [];
					

					 $scope.read = function() {

						 	$scope.registroMedida = {};
						 
						 	registroMedida = {

									idRegistroMedida : 0,
									
									cantidad : 0,
									
									fecha: '1900-01-01',
									
									lugarmedicionPOJO : {
										
										unidadMedidaPOJO : {
											idUnidadMedida : 0
										}
									
									},

									usuarioPOJO : {
										idUsuario : $scope.usuarioForm.idUsuario,
						                tipoUsuarioPOJO : {
						                	idTipoUsuario : 0
						                },
									    usuarioPOJOInstructor : {
									    	idUsuario : 0
									    }
									}
									
								};

						 console.log("RegistroMedida",registroMedida)
						 $http.post('rest/protected/RegistrosMedidas/getAllByIdUsuario',
								 {registroMedida:registroMedida}).success(function(data,status,config){
							 $scope.message = data;
							 $scope.registroMedidas = data.registroMedidaPOJO;
							 console.log("$scope.registroMedidas",$scope.registroMedidas);
							 console.log("$scope.registroMedidas",$scope.gridOptions);

						 }).error(
									function(data, status, config) {
										console.log("$scope.data",
												$scope.data)
										alert("failure message: "
												+ JSON.stringify({
													data : data
												}));
									});					 
					 };
					 					 
					 
					 $scope.gridOptions = {
					 data : 'registroMedidas',
					 showGroupPanel : true,
					 enableSorting : true,
					 enableFiltering : true,
					 columnDefs : [
					
					 {
					 field : 'fecha',
					 displayName : 'Fecha de ingreso'
					 },
					 {
					 field : 'cantidad',
					 displayName : 'Registro'
					 },


					 {
					 field : 'lugarmedicionPOJO.descLugarMedicion',
					 displayName : 'Lug.Medición'
					 },
					 
					 {
					 field : 'lugarmedicionPOJO.unidadMedidaPOJO.descUnidadMedida',
					 displayName : 'Un.Medida'
					 },
					 
					 {
					 field : 'Acciones',
					 displayName : 'Acciones',
					 cellTemplate : '<p ng-click="grid.appScope.edit(row)"><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span></p>'
					 },
					 {
					 field : 'Acciones',
					 displayName : 'Acciones',
					 cellTemplate : '<p	 ng-click="grid.appScope.deleteMe(row)"><span class="glyphicon glyphicon-trash" aria-hidden="true" ></span></p>'
					 } ]
					 };
					 
					 $scope.read();
					 
						$scope.save = function(row) {
							var dialogOpts = {
								backdrop : 'static',
								keyboard : false,
								templateUrl : 'resources/usuarios/modal_Registrar_Medida.html',
								controller : 'modal_Registrar_MedidaCtrl',
								size : "sm",
								windowClass : "modal",
								resolve : {
									usuario : function() {
										return usuario
									},
									route : $route
								}
							};

							$uibModal.open(dialogOpts)

						};
						
						$scope.deleteMe = function(row) {
						 	$scope.registroMedida = {};
							 
						 	registroMedida = {

									idRegistroMedida : row.entity.idRegistroMedida,
									
									cantidad : 0,
									
									fecha: '1900-01-01',
									
									lugarmedicionPOJO : {
										
										unidadMedidaPOJO : {
											idUnidadMedida : 0
										}
									
									},

									usuarioPOJO : {
										idUsuario : 0,
						                tipoUsuarioPOJO : {
						                	idTipoUsuario : 0
						                },
									    usuarioPOJOInstructor : {
									    	idUsuario : 0
									    }
									}
									
								};
						 	
							$http.post("rest/protected/RegistrosMedidas/delete", {
								registroMedida : registroMedida
							}).then(function(response) {

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