angular
		.module('myApp.modal',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'Modal_Registrar_Maquina_Controller',
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

							$scope.form = [ 'descMaquina', 'descUnidadMedida',
									'personasXMaquina', 'minutosXPersona' ];

							$scope.saveMaquina = function(event) {

								var data = {};

								data = {
									descMaquina : $scope.form.descMaquina,
									descUnidadMedida : $scope.form.descUnidadMedida,
									personasXMaquina : $scope.form.personasXMaquina,
									minutosXPersona : $scope.form.minutosXPersona
								};

								console.log("$scope.data", $scope.data)
								$http.post('rest/protected/Maquinas/create',
										data).success(
										function(data, status, config) {
											$scope.message = data;

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
