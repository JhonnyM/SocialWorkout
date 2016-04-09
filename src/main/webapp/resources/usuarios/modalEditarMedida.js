//'use strict';
angular
    .module('myApp.modalEditarMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalEditarMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'usuario',
        'registroMedida',
        '$route',
        function($scope, $http, $uibModalInstance, usuario, registroMedida, $route) {

            $scope.registroMedidaSchema = {
                    "type": "object",
                    properties: {

                        fechaMedida: {
                            title: 'Fecha de medición'
                        },

                        registroMedida: {
                            type: 'number',
                            title: 'Registro',
                            minimum : 0,
    						pattern : "^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$",
    	                    validationMessage: 'Registro de medida no válido'

                        }
                    },
                    
                   required: ['fechaMedida', 'registroMedida']
                };

            $scope.reload = function() {
                $route.reload();
            };

            $scope.lugaresMedicion = [];
            $scope.usuarioForm = angular.copy(usuario);
            $scope.registroMedidaForm = angular.copy(registroMedida);
            $scope.registroMedidaForm.fechaMedida = new Date(registroMedida.fecha);
            $scope.registroMedidaForm.registroMedida = $scope.registroMedidaForm.cantidad;
            $scope.lugarMedicionRegistro = $scope.registroMedidaForm.lugarmedicionPOJO.idLugarMedicion

	            $scope.form = [{
	                "title": "Fecha de medición:",
	                "key": "fechaMedida",
	                "type": "date",
	                "onChange": "validarFecha(form)"
		        },
		            'registroMedida'
		        ];


            $scope.validarFecha = function(form){
            	
            	var todayDate = new Date();
            	
                if($scope.registroMedidaForm.fechaMedida > todayDate || $scope.registroMedidaForm.fechaMedida == null){
                	$scope.registroMedidaForm.fechaMedida = todayDate
                }else{
                	
                }
            }
            
            $scope.cargarLugaresMedicion = function() {
                $http.get('rest/protected/lugarMedicion/getAll2')
                    .success(function(response) {
                        console.log("response", response)
                        $scope.lugaresMedicion = response.lugaresMedicion;
                        console.log("$scope.lugaresMedicion", $scope.lugaresMedicion)
                    });
            };

            $scope.cargarLugaresMedicion();

            $scope.save = function() {
                $scope.data = {};

                data = {
                    idRegistroMedida: $scope.registroMedidaForm.idRegistroMedida,
                    cantidad: $scope.registroMedidaForm.registroMedida,
                    fecha: $scope.registroMedidaForm.fecha,
                    lugarmedicionPOJO: {
                        idLugarMedicion: $scope.lugarMedicionRegistro,
                        unidadMedidaPOJO: {
                            idUnidadMedida: 0
                        }

                    },

                    usuarioPOJO: {
                        idUsuario: $scope.usuarioForm.idUsuario,
                        tipoUsuarioPOJO: {
                            idTipoUsuario: 0
                        },
                        usuarioPOJOInstructor: {
                            idUsuario: 0
                        }
                    }

                };

                $scope.valid = tv4.validate($scope.registroMedidaForm, $scope.registroMedidaSchema);
    			
                if($scope.valid){
                
                console.log("$scope.data", $scope.data)
                $http.post(
                    'rest/protected/RegistrosMedidas/edit', {
                        registroMedida: data
                    }).success(
                    function(data, status, config) {
                        $scope.message = data;
                        $scope.dismissModal = $scope.reload();
                        $uibModalInstance.close();

                    }).error(
                    function(data, status, config) {
                        console.log("$scope.data",
                            $scope.data)
                        alert("failure message: " +
                            JSON.stringify({
                                data: data
                            }));
                    });
                }else{
                	
                }
                
                };
        }
    ]);