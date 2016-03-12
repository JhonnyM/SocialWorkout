'use strict';

angular.module('myApp.items.directive', [])

.directive('itemSwitch', [function() {
	return {
        restrict: 'A',
        scope: {
            item: '=',
            itemIndex: "="
        },
        templateUrl: 'resources/components/items/itemSwitchTemplate.html',

        link: function($scope) {

            $scope.editeme =  item => {
                $scope.$emit("EDIT_CHANNEL",item);
            }

            $scope.borreme = item => {
                $scope.$emit("DELETE_CHANNEL",item);
            }
        }
    }
}]);
