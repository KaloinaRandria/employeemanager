var app = angular.module("employeeApp", []);

app.controller("EmployeeController", function($scope, $http) {
    $scope.employees = [];

    // Charger les employés
    $http.get("/employee/all").then(function(response) {
        $scope.employees = response.data;
    });
    

    
    // Supprimer un employé
    $scope.deleteEmployee = function(id) {
        $http.delete("/employee/delete/" + id).then(function() {
            $scope.employees = $scope.employees.filter(e => e.id !== id);
        });
    };

    // Ajouter un employé (exemple)
    $scope.newEmployee = {};
    $scope.addEmployee = function() {
        $http.post("/employee/add", $scope.newEmployee).then(function(response) {
            $scope.employees.push(response.data);
            $scope.newEmployee = {}; // reset formulaire
        });
    };
});
