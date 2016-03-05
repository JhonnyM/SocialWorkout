//'use strict';

angular
		.module('myApp.modal_Editar_Parametro',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'Modal_Editar_ParametroCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						'parametro',
						function($scope, $http, $uibModalInstance, parametro) {
							$scope.ParametroSchema = {
								"type" : "object",
								properties : {
									nombreNegocio : {
										type : 'string',
										title : 'Gimnasio'
									},
									cantidadDiasCalculoPromedios : {
										type : 'number',
										title : 'Cantidad dias'
									}
								}
							};

							$scope.parametroForm = angular.copy(parametro);

							$scope.form = [ 'nombreNegocio',
									'cantidadDiasCalculoPromedios' ];

							$scope.save = function() {

								$scope.data = {};
								data = {
									idRegistroParametro : $scope.parametroForm.idRegistroParametro,
									nombreNegocio : $scope.parametroForm.nombreNegocio,
									cantidadDiasCalculoPromedios : $scope.parametroForm.cantidadDiasCalculoPromedios
								};

								$http.post('rest/protected/parametros/edit',
										data).success(
										function(data, status, config) {
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
