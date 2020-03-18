'use strict';

angular.module('employeesApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('error', {
                parent: 'site',
                url: '/error',
                views: {
                    'content@': {
                        templateUrl: 'templates/error.html'
                    }
                }
            });
    });
