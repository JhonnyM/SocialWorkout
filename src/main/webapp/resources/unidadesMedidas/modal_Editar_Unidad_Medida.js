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
						'$route',
						function($scope, $http, $uibModalInstance, unidadMedida,$route) {
							$scope.unidadMedidaSchema = {
								"type" : "object",
								properties : {
									descUnidadMedida : {
										type : 'string',
										title : 'Descripción'
									}
								}
							};
							
							$scope.reload = function(){
								 $route.reload();
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
										{unidadMedida:data}).success(
										function(data, status, config) {
											$scope.message = data;
     										$scope.dismissModal = $scope.reload();									
										}).error(
										function(data, status, config) {
											console.log("$scope.data",
													$scope.data)
											alert("failure message: "
													+ JSON.stringify({
														data : data
													}));
										});

							    $uibModalInstance.close();
							};
						} ]);