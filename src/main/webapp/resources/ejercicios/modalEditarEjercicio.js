//'use strict';

angular.module('myApp.modalEditarEjercicio',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'ModalEditarEjercicioCtrl',
		[ '$scope', '$http', '$uibModalInstance', 'ejercicio', '$route',
				function($scope, $http, $uibModalInstance, ejercicio, $route) {
				$scope.ejercicioSchema = {
						"type" : "object",
						properties : {
	
							descEjercicio : {
								type : 'string',
								title : 'Descripción',
		                        validationMessage: 'Descripción de ejercicio inválido',
		                        pattern: "^[A-Za-z0-9 áéíóú.!=/-]+$",
		                        maxLength: 255
	
							}
						},
		                required : [
		                             'descEjercicio'
					               ]
	
					};

					$scope.reload = function() {
						$route.reload();
					};

					$scope.ejercicioForm = angular.copy(ejercicio);

					$scope.form = [ 'descEjercicio' ];

					$scope.save = function() {

						$scope.data = {};
						data = {
							idEjercicio : $scope.ejercicioForm.idEjercicio,
							descEjercicio : $scope.ejercicioForm.descEjercicio
						};

		    			$scope.valid = tv4.validate($scope.ejercicioForm, $scope.ejercicioSchema);
		                if($scope.valid){
						$http.post('rest/protected/Ejercicios/edit', {
							ejercicio : data
						}).success(function(data, status, config) {
							$scope.message = data;
							$scope.dismissModal = $scope.reload();	
						    $uibModalInstance.close();	
						}).error(function(data, status, config) {
							console.log("$scope.data", $scope.data)
							alert("failure message: " + JSON.stringify({
								data : data
							}));
						});
					
		                }else{
		                	
		                }
		                };
				} ]);