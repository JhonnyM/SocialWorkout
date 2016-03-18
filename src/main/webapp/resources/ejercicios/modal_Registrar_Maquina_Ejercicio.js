angular
		.module('myApp.modal_Registrar_Maquina_Ejercicio',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'modal_Registrar_Maquina_EjercicioCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						'ejercicio',
						function($scope, $http, $uibModalInstance, ejercicio) {

							$scope.maquinas = [];
						    $scope.maquinasSeleccionadas = [];

							$scope.requestObject = {
								"pageNumber" : 0,
								"pageSize" : 0,
								"sortBy" : [ "" ],
								"searchColumn" : "string",
								"searchTerm" : "",
								"ejercicio" : {}
							};

							$scope.ejercicioForm = angular.copy(ejercicio);
						
							$scope.setMachine = function(maquinas){
								console.log("maquinas_2",$scope.maquinas.length);
								
								for(i = 0; i< $scope.maquinas.length; i++){
									for (j=0; j<$scope.maquinas[i].maquinahasejercicios.length;j++){
										if($scope.maquinas[i].maquinahasejercicios[j].maquinaPOJO.idMaquina == maquinas[i].idMaquina
											&& $scope.maquinas[i].maquinahasejercicios[j].ejercicioPOJO.idEjercicio == ejercicio.idEjercicio){
											console.log("fail");
											$scope.toggle(maquinas[i],$scope.maquinasSeleccionadas);										
											
										}
									}
								}	
							};

							$scope.read = function() {
							    $scope.maquinasSeleccionadas.length = 0;
								$http
										.get('rest/protected/Maquinas/getAll')
										.then(
												function(response) {

													console.log("response",response)
													$scope.maquinas = response.data.maquinas;
													console.log("maquinas_1",$scope.maquinas.length);
													$scope.setMachine($scope.maquinas);
												},
												function() {
													alert("Error obteniendo la informacion de los eventos")
												});
							};

							$scope.read();

							
							$scope.toggle = function(maquina,maquinasSeleccionadas) {

								var idx = maquinasSeleccionadas
										.indexOf(maquina);
								if (idx > -1)
									maquinasSeleccionadas.splice(idx, 1)
								else
									maquinasSeleccionadas.push(maquina);
							};

							$scope.exists = function(maquina,maquinasSeleccionadas) {

								return maquinasSeleccionadas.indexOf(maquina) > -1;

							};

							
							$scope.save = function() {

								$scope.data = {};
								$scope.ejercicio = {};
								$scope.maquinahasejercicios = [];

								for (i = 0; i < $scope.maquinasSeleccionadas.length; i++) {

									data = [ {

										maquina : {
											idMaquina : $scope.maquinasSeleccionadas[i].idMaquina
										},

										ejercicio : {
											idEjercicio : $scope.ejercicioForm.idEjercicio
										}

									} ];

									$scope.maquinahasejercicios.push(data);

								}
								;

								for (i = 0; i < $scope.maquinasSeleccionadas.length; i++) {

									$scope.ejercicio = {
										idEjercicio : $scope.ejercicioForm.idEjercicio,
										descEjercicio : $scope.ejercicioForm.descEjercicio,
										maquinahasejercicios : [ {
											maquinaPOJO : {
												idMaquina : $scope.maquinasSeleccionadas[i].idMaquina
											},

											ejercicioPOJO : {
												idEjercicio : $scope.ejercicioForm.idEjercicio
											}
										} ]
									};

									console.log($scope.ejercicio)
									
									$http
											.post(
													'rest/protected/Ejercicios/assignMachine',
													{
														ejercicio : $scope.ejercicio
													})
											.success(
													function(data, status,
															config) {
														$scope.message = data;
														$uibModalInstance
																.close();
													})
											.error(
													function(data, status,
															config) {
														alert("failure message: "
																+ JSON
																		.stringify({
																			data : data
																		}));
													});

								}
								;

							}
						} ]);