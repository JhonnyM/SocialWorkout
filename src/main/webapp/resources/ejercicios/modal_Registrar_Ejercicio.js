angular.module('myApp.modal_Registrar_Ejercicio',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'modal_Registrar_EjercicioCtrl',
		[ '$scope', '$http', '$uibModalInstance',
				function($scope, $http, $uibModalInstance) {
					$scope.ejercicioSchema = {
						"type" : "object",
						properties : {

							descEjercicio : {
								type : 'string',
								title : 'Descripción'
							}
						}
					};

					$scope.form = [ 'descEjercicio' ];

					$scope.save = function(event) {

						var data = {};

						data = {
							descEjercicio : $scope.form.descEjercicio
						};

						$http.post('rest/protected/Ejercicios/create', {
							ejercicio : data
						}).success(function(data, status, config) {
							$scope.message = data;
							$uibModalInstance.close();
						}).error(function(data, status, config) {
							alert("failure message: " + JSON.stringify({
								data : data
							}));
						});
					};
				} ]);