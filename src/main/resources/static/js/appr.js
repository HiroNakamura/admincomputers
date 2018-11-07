var appr = angular.module("app", ["ngRoute"]);
appr.config(function($routeProvider) {
    $routeProvider
    .when("/about", {
        templateUrl : "about.html"
    })
});
