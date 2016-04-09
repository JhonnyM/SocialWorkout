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

					
					$scope.form = [ 'descMaquina', 'cantidad','minutosXPersona','personasXMaquina'];

					$scope.save = function(event) {

						var data = {};

						data = {
							descMaquina : $scope.form.descMaquina,
							cantidad : $scope.form.cantidad,
							minutosXPersona : $scope.form.minutosXPersona,
							personasXMaquina : $scope.form.personasXMaquina
						};

						console.log("$scope.data", $scope.data)
						$http.post('rest/protected/Maquinas/create',
								{maquina:data})
								.success(function(data, status, config) {
									$scope.message = data;
									$scope.dismissModal = $scope.reload();	
	
								}).error(
										function(data, status, config) {
											alert("failure message: "
													+ JSON.stringify({
														data : data
													}));
										});
					    $uibModalInstance.close();
					};
				} ]);
