angular.module('myApp.modal_Registrar_Maquina',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'modal_Registrar_MaquinaCtrl',
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
							}
						}
					};

					$scope.reload = function(){
						 $route.reload();
					};

					
					$scope.form = [ 'descMaquina', 'cantidad' ];

					$scope.save = function(event) {

						var data = {};

						data = {
							descMaquina : $scope.form.descMaquina,
							cantidad : $scope.form.cantidad
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
