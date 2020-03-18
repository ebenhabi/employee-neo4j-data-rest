'use strict';

angular.module('employeesApp').controller('EmployeeDetailController',
	    function( EmployeeService, $scope) {

	        var self = this;
	        $scope.employees =[];
	        
	        $scope.getAllEmployees = getAllEmployees;

	        function getAllEmployees(){
	            return EmployeeService.getAllEmployees();
	        }
	    });