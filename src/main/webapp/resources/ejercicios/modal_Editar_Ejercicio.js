//'use strict';

angular.module('myApp.modal_Editar_Ejercicio',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'modal_Editar_EjercicioCtrl',
		[ '$scope', '$http', '$uibModalInstance', 'ejercicio',
				function($scope, $http, $uibModalInstance, ejercicio) {
					$scope.ejercicioSchema = {
						"type" : "object",
						properties : {

							descEjercicio : {
								type : 'string',
								title : 'Descripción'
							}
						}
					};

					$scope.ejercicioForm = angular.copy(ejercicio);

					$scope.form = [ 'descEjercicio' ];

					$scope.save = function() {

						$scope.data = {};
						data = {
							idEjercicio : $scope.ejercicioForm.idEjercicio,
							descEjercicio : $scope.ejercicioForm.descEjercicio
						};

						console.log("$scope.data", $scope.data)
						$http.post('rest/protected/Ejercicios/edit', {
							ejercicio : data
						}).success(function(data, status, config) {
							$scope.message = data;
							$uibModalInstance.close();
						}).error(function(data, status, config) {
							console.log("$scope.data", $scope.data)
							alert("failure message: " + JSON.stringify({
								data : data
							}));
						});
					};
				} ]);