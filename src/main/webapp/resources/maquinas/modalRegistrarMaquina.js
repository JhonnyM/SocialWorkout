angular.module('myApp.modalRegistrarMaquina',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'ModalRegistrarMaquinaCtrl',
		[
				'$scope',
				'$http',
				'$uibModalInstance',
				'$route',
				function($scope, $http, $uibModalInstance,$route) {
					$scope.maquinaForm = {};
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

					
					$scope.form = [ 'descMaquina', 'cantidad','minutosXPersona','personasXMaquina'];

					$scope.save = function(event) {

						var data = {};

						data = {
							descMaquina : $scope.maquinaForm.descMaquina,
							cantidad : $scope.maquinaForm.cantidad,
							minutosXPersona : $scope.maquinaForm.minutosXPersona,
							personasXMaquina : $scope.maquinaForm.personasXMaquina
						};

		    			$scope.valid = tv4.validate($scope.maquinaForm, $scope.maquinaSchema);
	
		                if($scope.valid){
						$http.post('rest/protected/Maquinas/create',
								{maquina:data})
								.success(function(data, status, config) {
									$scope.message = data;
									$scope.dismissModal = $scope.reload();	
								    $uibModalInstance.close();	
								}).error(
										function(data, status, config) {
											alert("failure message: "
													+ JSON.stringify({
														data : data
													}));
										});
		                }else{
							
						}	
					};
				} ]);
