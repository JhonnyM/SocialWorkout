angular.module('myApp.modalRegistrarEjercicio',
		[ 'ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap' ])

.controller(
		'ModalRegistrarEjercicioCtrl',
		[ '$scope', '$http', '$uibModalInstance','$route',
				function($scope, $http, $uibModalInstance,$route) {
					$scope.ejercicioForm = {};
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

					$scope.reload = function(){
						 $route.reload();
					};
					
					$scope.form = [ 'descEjercicio' ];

					$scope.save = function(event) {

						var data = {};

						data = {
							descEjercicio : $scope.ejercicioForm.descEjercicio
						};

		    			$scope.valid = tv4.validate($scope.ejercicioForm, $scope.ejercicioSchema);
		                if($scope.valid){
						$http.post('rest/protected/Ejercicios/create', {
							ejercicio : data
						}).success(function(data, status, config) {
							$scope.message = data;
							$uibModalInstance.close();
							$scope.dismissModal = $scope.reload();								
							
						}).error(function(data, status, config) {
							alert("failure message: " + JSON.stringify({
								data : data
							}));
						});
						
		                }else{
		                	
		                }
					};
				} ]);