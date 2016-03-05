angular
		.module('myApp.modal_Registrar_Unidad_Medida',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'modal_Registrar_Unidad_MedidaCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						function($scope, $http, $uibModalInstance) {
							$scope.unidadMedidaSchema = {
								"type" : "object",
								properties : {
									descUnidadMedida : {
										type : 'string',
										title : 'Descripción'
									}
								}
							};

							$scope.form = [ 'descUnidadMedida' ];

							$scope.save = function() {

								$scope.data = {};

								data = {
									descUnidadMedida : $scope.form.descUnidadMedida
								};

								console.log("$scope.data", $scope.data)
								$http.post('rest/protected/UnidadesMedidas/create',
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
