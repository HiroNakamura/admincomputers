var app = angular.module("app", ["ngResource"]);
 
app.controller("appController", function ($scope, $http, dataResource) {
    $http.get('http://localhost:8080/rest/departamentosRest').success(function (data) {
        $scope.datos = data;
        $scope.titulo = "Departamentos";
    });
    $scope.datosResource = dataResource.get();
})
 

app.factory("dataResource", function ($resource) {
    return $resource("http://localhost:8080/rest/departamentosRest",
        {},
        { get: { method: "GET", isArray: true }
    })
})
