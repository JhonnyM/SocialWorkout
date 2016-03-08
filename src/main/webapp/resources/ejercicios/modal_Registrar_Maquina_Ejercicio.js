angular
		.module('myApp.modal_Registrar_Maquina_Ejercicio',
				[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

		.controller(
				'modal_Registrar_Maquina_EjercicioCtrl',
				[
						'$scope',
						'$http',
						'$uibModalInstance',
						function($scope, $http, $uibModalInstance) {

							$scope.maquinas = {};
							$scope.selected = [];

							$scope.requestObject = {
								"pageNumber" : 0,
								"pageSize" : 0,
								"sortBy" : [ "" ],
								"searchColumn" : "string",
								"searchTerm" : "",
								"maquina" : {}
							};

							$scope.read = function() {
								$http
										.get('rest/protected/Maquinas/getAll')
										.then(
												function(response) {

													console.log("response",
															response)
													$scope.maquinas = response.data.maquinas;
												},
												function() {
													alert("Error obteniendo la informacion de los eventos")
												});
							};

							$scope.read();

							$scope.toggle = function(maquina, maquinas) {
								var idx = maquinas.indexOf(maquina);
								if (idx > -1)
									maquinas.splice(idx, 1);
								else
									maquinas.push(maquina);
							};
							$scope.exists = function(maquina, maquinas) {
								return maquinas.indexOf(maquina) > -1;
							};

						} ]);