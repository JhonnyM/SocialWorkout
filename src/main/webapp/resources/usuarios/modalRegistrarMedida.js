//'use strict';
angular
    .module('myApp.modalRegistrarMedida', ['ngRoute', 'ui.grid', 'schemaForm', 'ui.bootstrap'])

.controller(
    'ModalRegistrarMedidaCtrl', [
        '$scope',
        '$http',
        '$uibModalInstance',
        'usuario',
        '$route',
        function($scope, $http, $uibModalInstance, usuario, $route) {
        	
        	$scope.registroMedidaForm = {};
        	
        	$scope.lugarMedicionEscogido = {};

        	$scope.lugaresMedicion = [];

            $scope.reload = function() {
                $route.reload();
            };

            $scope.cargarLugaresMedicion = function() {
                $http.get('rest/protected/lugarMedicion/getAll2')
                    .success(function(response) {
 
                    	$scope.lugaresMedicion = response.lugaresMedicion;
                        
                        if(response.lugaresMedicion[0]==""){

                        }else{
                        
                        	$scope.lugarMedicionEscogido = response.lugaresMedicion[0].idLugarMedicion;	

                        }                        
                    });
            };

            $scope.cargarLugaresMedicion();

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

            $scope.usuarioForm = angular.copy(usuario);

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
            
            $scope.registroMedidaForm.fechaMedida = new Date();

            $scope.registroMedidaForm.registroMedida = 0;
            
            $scope.save = function() {

            	$scope.data = {};

                data = {
                    cantidad: $scope.registroMedidaForm.registroMedida,
                    fecha: $scope.registroMedidaForm.fechaMedida,
                    lugarmedicionPOJO: {
                        idLugarMedicion: $scope.lugarMedicionEscogido,
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
    			
                if($scope.valid && $scope.lugarMedicionEscogido > 0){

                console.log("$scope.data", $scope.data)
                $http.post(
                    'rest/protected/RegistrosMedidas/create', {
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
