
angular.module('myApp.misRutinas', ['ngRoute', 'ui.bootstrap'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/misRutinas', {
    templateUrl: 'resources/misRutinas/misRutinas.html',
    controller: 'misRutinasCtrl'
  });  
}])

.controller('misRutinasCtrl', ['$scope','$http','$route' , function($scope,$http,$route) {
	$scope.consultar = function(event) {
		$scope.data = {};
		data = {
				idPLantillaRutinaDetalle:0,
  	    		cantidadPeso:0,
  	    		cantidadRepeticiones:0,
  	    		cantidadSeries:0,
  	    		maquinahasejercicio: {
  	    			idEjercicioXMaquina: 0
  	    		},
				plantillarutinamaestro : {
					idRutina : $scope.misRutinasTotales[event].plantillarutinamaestroPOJO.idRutina,
				}
	  	};

		$http.post('rest/protected/rutinas/getEjerciciosXRutina',{plantillaRutinaDetalle: data})
		.success(function(response) {
	   			console.log("response",response);
	   			$scope.ejercicios = response.plantillasDetalle;
	   			console.log("EJERCICIOS",$scope.ejercicios);       
	   });
	};	
	
	$scope.asignar = function(event) {
		$scope.dataNew = {};
		dataNew = {
				idRegistroRutinaXUsuario:0,
  	    		temporal:$scope.misRutinasTotales[event].plantillarutinamaestroPOJO.idRutina,
  	    };
		$http.post('rest/protected/rutinas/asignarNuevaRutina', {rutinaHasUsuarioPOJO : dataNew})
		.success(function(response) {
	   			console.log("response",response);
	   			$scope.nuevaRutina = response.plantillasDetalle;
	   			console.log("NUEVA RUTINA",$scope.nuevaRutina);      
	   			$route.reload();
	   });
	};


	$scope.usuario = {};
	 $http.post('rest/protected/users/usuarioSet')
		.success(function(response) {
			$scope.usuario = response.usuario;
			 console.log(response.usuario,"USUARIO");
		});
	$scope.ocupacion = {};
	$scope.capacidad = {};
		 $http.post('rest/protected/ocupacionActual/getAll')
			.success(function(response) {
				$scope.ocupacion = response.ocupacion[0].ocupacionGimnasio;
				$scope.capacidad = response.ocupacion[0].capacidad;
				   console.log(response.ocupacion,"OCUPACION ACTUAL");
			});
	 $scope.ocupacionParqueo = {};
	 $scope.capacidadParqueo = {};
			 $http.post('rest/protected/ocupacionActualParqueo/getAll')
				.success(function(response) {
					$scope.ocupacionParqueo = response.ocupacion[0].ocupacionParqueo;
					$scope.capacidadParqueo = response.ocupacion[0].capacidad;
					   console.log(response,"OCUPACION ACTUAL PARQUEO");
	             });
	 $scope.ocupaciones = {};
	 		 $http.post('rest/protected/promedioOcupacion/getDiaHoraUsuario')
				.success(function(response) {
					console.log(response.nulo,"AQUI VERIFICA NULO");
					if(response.nulo==0){
						$scope.ocupaciones = response.ocupacion;
						console.log(response,"PRUeBAMORTAL");
					}else{
						$scope.promedioOcupacion = "";
					}
				});		 
	 $scope.ocupacionesParqueo = {};
	 		 $http.post('rest/protected/promedioOcupacionParqueo/getDiaHoraUsuario')
				.success(function(response) {
					$scope.ocupacionesParqueo = response.ocupacion;
					console.log(response,"PromedioOcupacionParqueo");
	             });
	 		 
	 $scope.promedioTotal = {};		 
	 		$http.post('rest/protected/promedioOcupacion/getDiaTotal')
			.success(function(response) {
				console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL");
				if(response.nulo==0){
					$scope.promedioTotal = response.ocupacion;
					console.log(response,"promedioTotal");
				}else{
					$scope.promedioTotal = "";
				}
			});		
	$scope.promedioTotalParqueo = {};		 
	$http.post('rest/protected/promedioOcupacionParqueo/getDiaTotal')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL PARQUEO");
		if(response.nulo==0){
			$scope.promedioTotalParqueo = response.ocupacion;
			console.log(response,"promedioTotalParqueo");
		}else{
			$scope.promedioTotalParqueo = "";
		}
	});		
	
	$scope.promedioTotalMaquinas = {};		 
	$http.post('rest/protected/promedioRutinasMaquina/getMaquinasUsuario')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL PARQUEO");
		if(response.nulo==0){
			$scope.promedioTotalMaquinas = response.ocupacion;
			console.log(response,"MAQUINAS");
		}else{
			$scope.promedioTotalMaquinas = "";
		}
	});	
	
	$scope.misRutinasDelDia = {};		 
	$http.post('rest/protected/rutinas/getRutinasDia')
	.success(function(response) {
		console.log(response.nulo,"AQUI VERIFICA PROMEDIO TOTAL PARQUEO");
		if(response.nulo==0){
			$scope.misRutinasDelDia = response.rutinasHasUsuarioPOJO;
			console.log(response,"MisRutinasDELDIA");
		}else{
			$scope.misRutinasDelDia = "";
		}
	});	
	$scope.misRutinasTotales = {};		 
	$http.post('rest/protected/rutinas/getRutinasUsuario')
	.success(function(response) {
		console.log(response.nulo,"verificar NULO");
		if(response.nulo==0){
			$scope.misRutinasTotales = response.rutinasHasUsuarioPOJO;
			console.log(response,"MisRutinasTOTALES");
		}else{
			$scope.misRutinasTotales = "";
		}
	});	 
	
	

}]);
