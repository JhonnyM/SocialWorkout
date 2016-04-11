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
											title : 'Descripción',
					                        validationMessage: 'Descripción de máquina inválida',
					                        pattern: "^[A-Za-z0-9 áéíóú.!=/-]+$",
					                        maxLength: 255
										},
										cantidad : {
											type : 'number',
											title : 'Cantidad de máquinas',
											pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
						                    validationMessage: 'Cantidad no válida'
										},
										minutosXPersona : {
											type : 'number',
											title : 'Minutos por persona',
											pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
							                validationMessage: 'Cantidad de minutos por persona no válida'
										},
										personasXMaquina : {
											type : 'number',
											title : 'Personas por máquina',
											pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
							                validationMessage: 'Cantidad de personas por máquina no válida'

										}
									},
					                required : [
					                             'descMaquina',
					                             'cantidad',
					                             'minutosXPersona',
					                             'personasXMaquina'
								               ]
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
								
				    			$scope.valid = tv4.validate($scope.maquinaForm, $scope.maquinaSchema);
				    			
				                if($scope.valid){
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
				                }else{
				                	
				                }
				                
				                };
						} ]);