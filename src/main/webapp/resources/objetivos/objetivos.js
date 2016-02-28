'use strict';

angular.module('myApp.objetivos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/objetivos', {
    templateUrl: 'resources/objetivos/objetivos.html',
    controller: 'ObjetivosCtrl'
  });
}])

.controller('ObjetivosCtrl', ['$scope','$http',function($scope,$http) {
	$scope.objetivos = [];
	$scope.requestObject = {"pageNumber": 0,"pageSize": 0, "sortBy": [""],"searchColumn": "string","searchTerm": "","objetivo": {}};
	$http.post('rest/protected/objetivos/getAll',$scope.requestObject).success(function(response) {
	console.log("response",response)
	$scope.objetivos = response.objetivoList;
	console.log("$scope.objetivos",$scope.objetivos)
		
	});

	$scope.saveObjetivo = function(event){
    	
    	var data = {};
    	console.log($scope.requestObject.desc);
    	//Objeto JSON que lleva solo el tipo
    	data = {
    			objetivo : $scope.requestObject.desc
    	};
    	
    	$http.post('rest/protected/objetivos/create', data)
    	.success(function(data, status, config) {
            $scope.message = data;
          }).error(function(data, status, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        }); 
    };
	
}]);