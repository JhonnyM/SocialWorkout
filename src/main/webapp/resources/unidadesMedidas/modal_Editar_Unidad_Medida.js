//'use strict';

angular
		.module('myApp.modal_Editar_Unidad_Medida',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'modal_Editar_Unidad_MedidaCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						'unidadMedida',
						function($scope, $http, $uibModalInstance, unidadMedida) {
							$scope.unidadMedidaSchema = {
								"type" : "object",
								properties : {
									descUnidadMedida : {
										type : 'string',
										title : 'Descripción'
									}
								}
							};

							$scope.unidadMedidaForm = angular
									.copy(unidadMedida);

							$scope.form = [ 'descUnidadMedida' ];

							$scope.save = function() {

								$scope.data = {};
								data = {
									idUnidadMedida : $scope.unidadMedidaForm.idUnidadMedida,
									descUnidadMedida : $scope.unidadMedidaForm.descUnidadMedida
								};

								console.log("$scope.data", $scope.data)
								$http.post(
										'rest/protected/UnidadesMedidas/edit',
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