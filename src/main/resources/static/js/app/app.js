'use strict';

var app = angular.module('employeesApp', ['ui.router','ngStorage']);

app.constant('urls', {
	BASE: 'http://localhost:8080',
	EMPLOYEE_SERVICE_API: 'http://localhost:8080/api/employee/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('site', {
                'abstract': true,
                views: {
                    'navbar@': {
                        templateUrl: 'templates/navbar.html'
                    }
                }
            })
            .state('employee', {
            	parent: 'entity',
                url: '/employee',
                views: {
                    'content@': {
                        templateUrl: 'templates/employees.html',
                        controller: 'EmployeeController'
                    }
                }
            })
            .state('employeeDetail', {
            	parent: 'entity',
                url: '/employeeDetail',
                views: {
                    'content@': {
                        templateUrl: 'templates/employee-details.html',
                        controller: 'EmployeeDetailController'
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
        
}]);