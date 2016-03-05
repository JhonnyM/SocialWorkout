angular.module('myApp.modal_Registrar_Maquina',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'modal_Registrar_MaquinaCtrl',
		[
				'$scope',
				'$http',
				'$uibModalInstance',
				function($scope, $http, $uibModalInstance) {
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

					$scope.form = [ 'descMaquina', 'cantidad',
							'personasXMaquina', 'minutosXPersona' ];

					$scope.save = function(event) {

						var data = {};

						data = {
							descMaquina : $scope.form.descMaquina,
							cantidad : $scope.form.cantidad,
							personasXMaquina : $scope.form.personasXMaquina,
							minutosXPersona : $scope.form.minutosXPersona
						};

						console.log("$scope.data", $scope.data)
						$http.post('rest/protected/Maquinas/create', data)
								.success(function(data, status, config) {
									$scope.message = data;
									$uibModalInstance.close();		
								}).error(
										function(data, status, config) {
											alert("failure message: "
													+ JSON.stringify({
														data : data
													}));
										});
					};
				} ]);
