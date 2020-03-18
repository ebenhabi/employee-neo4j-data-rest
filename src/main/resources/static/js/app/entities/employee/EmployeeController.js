'use strict';

angular.module('employeesApp').controller('EmployeeController',
    function( EmployeeService, $scope) {

        var self = this;
        $scope.employee = {};
        $scope.employees =[];
        $scope.collaborators = [];
        $scope.supervisors = [];

        $scope.submit = submit;
        $scope.getAllEmployees = getAllEmployees;
        $scope.createEmployee = createEmployee;
        $scope.reset = reset;

        $scope.successMessage = '';
        $scope.errorMessage = '';
        
        function submit() {
            console.log('Submitting');
            
            $scope.employee.collaborators = $scope.collaborators.map(collaborator => {
				return {employeeId: null, name: collaborator};
			});
			
            $scope.employee.supervisors = $scope.supervisors.map(supervisor => {
				return {employeeId: null, name: supervisor};
			});
			
            if ($scope.employee.employeeId === undefined || $scope.employee.employeeId === null) {
                console.log('Saving New Employee', $scope.employee);
                createEmployee($scope.employee);
            } 
        }

        function createEmployee(employee) {
            console.log('About to create employee');
            EmployeeService.createEmployee(employee)
                .then(
                    function (response) {
                        console.log('Employee created successfully');
                        $scope.successMessage = 'Employee created successfully';
                        $scope.errorMessage = '';
                        $scope.employee = response.data;
                        $scope.allEmployees = response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating Employee');
                        $scope.errorMessage = 'Error while creating employee: ' + errResponse.data.errorMessage;
                        $scope.successMessage = '';
                    }
                );
        }

        function getAllEmployees(){
            return EmployeeService.getAllEmployees();
        }

        
        function reset(){
        	$scope.successMessage = '';
        	$scope.errorMessage = '';
            $scope.employee = {};
        	$scope.collaborators = [];
        	$scope.supervisors = [];
        }
    });