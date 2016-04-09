//'use strict';

angular
		.module('myApp.modalEditarMaquina',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'ModalEditarMaquinaCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						'maquina',
						'$route',
						function($scope, $http, $uibModalInstance, maquina,$route) {
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
										minutosXPersona : {
											type : 'number',
											title : 'Minutos por persona'
										},
										personasXMaquina : {
											type : 'number',
											title : 'Personas por máquina'
										}
									}
								};
							
							$scope.reload = function(){
								 $route.reload();
							};

							$scope.maquinaForm = angular
									.copy(maquina);

							$scope.form = [ 'descMaquina', 'cantidad','minutosXPersona','personasXMaquina'];

							$scope.save = function() {

								$scope.data = {};
								data = {
									idMaquina : $scope.maquinaForm.idMaquina,
									descMaquina : $scope.maquinaForm.descMaquina,
									cantidad : $scope.maquinaForm.cantidad,
									minutosXPersona : $scope.maquinaForm.minutosXPersona,
									personasXMaquina : $scope.maquinaForm.personasXMaquina

								};
								

								console.log("$scope.data", $scope.data)
								$http.post(
										'rest/protected/Maquinas/edit',
										{maquina:data}).success(
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