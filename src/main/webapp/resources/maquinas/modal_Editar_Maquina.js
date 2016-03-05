//'use strict';

angular
		.module('myApp.modal_Editar_Maquina',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'modal_Editar_MaquinaCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						'maquina',
						function($scope, $http, $uibModalInstance, maquina) {
							$scope.maquinaSchema = {
									"type" : "object",
									properties : {

										descMaquina : {
											type : 'string',
											title : 'Descripción'
										},
										cantidad : {
											type : 'number',
											title : 'Cantidad de máquinas'
										},
										personasXMaquina : {
											type : 'number',
											title : 'Cantidad de personas por máquina'
										},
										minutosXPersona : {
											type : 'number',
											title : 'Minutos por máquina'
										}
									}
								};

							$scope.maquinaForm = angular
									.copy(maquina);

							$scope.form = [ 'descMaquina', 'cantidad',
											'personasXMaquina', 'minutosXPersona' ];

							$scope.save = function() {

								$scope.data = {};
								data = {
									idMaquina : $scope.maquinaForm.idMaquina,
									descMaquina : $scope.maquinaForm.descMaquina,
									cantidad : $scope.maquinaForm.cantidad,
									personasXMaquina : $scope.maquinaForm.personasXMaquina,								
									minutosXPersona : $scope.maquinaForm.minutosXPersona
								};
								

								console.log("$scope.data", $scope.data)
								$http.post(
										'rest/protected/Maquinas/edit',
										data).success(
										function(data, status, config) {
											$scope.message = data;
											$uibModalInstance.close();		
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
						} ]);