'use strict';


angular.module('app', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ngStorage',
    'ui.router',
    'ui.bootstrap',
    'ui.utils',
    'ui.load',
    'ui.jq',
    'oc.lazyLoad',
    'pascalprecht.translate'

]).config(['$provide','$httpProvider', function($provide,$httpProvider) {

    var loginURL = "/src/#/access/signin";
    $provide.factory('responseHttpInterceptor', function($q) {

        return {
            response: function(response) {
                // do something on success
                return response;
            },
            responseError: function(response) {
                // do something on error
                if(response.status === 401){
                    window.location.href = loginURL;
                } else if ( response.status === 404) {
                    window.location.href = "/src/#/access/404";
                }
                return $q.reject(response);
            }
        };
    });

    $httpProvider.interceptors.push('responseHttpInterceptor');

    //RESPONSE INTERCEPTOR FOR ALL THE JQUERY CALLS: EX:THE JQGRID
    $.ajaxSetup({
        beforeSend: function() {
        },
        complete: function(response) {
            if(response.status === 401){
                window.location.href =  loginURL;
            }
        }
    });

}]);
