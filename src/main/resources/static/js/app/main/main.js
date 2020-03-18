'use strict';

angular.module('employeesApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('home', {
                parent: 'site',
                url: '/',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'templates/main.html',
                        controller: 'MainController'
                    }
                }
            });
    });