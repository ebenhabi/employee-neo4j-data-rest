'use strict';

angular.module('employeesApp').factory('EmployeeService',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            	loadAllEmployees(): loadAllEmployees(),
            	getAllEmployees: getAllEmployees,
                createEmployee: createEmployee
            };

            return factory;

            function loadAllEmployees() {
                console.log('Fetching all employees');
                var deferred = $q.defer();
                $http.get(urls.EMPLOYEE_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all employees');
                            $localStorage.employee = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading employees');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllEmployees(){
            	loadAllEmployees();
                return $localStorage.employee;
            }

            function createUser(employee) {
                console.log('Creating employees');
                var deferred = $q.defer();
                $http.post(urls.EMPLOYEE_SERVICE_API, employee)
                    .then(
                        function (response) {
                        	$localStorage.employee = response.data;
                            //loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating employees : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
      
        });