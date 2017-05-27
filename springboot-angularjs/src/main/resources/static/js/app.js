var app = angular.module('app', ['ngRoute','ngResource','ui.bootstrap']);
app.config(function($routeProvider){
    $routeProvider
        .when('/leases',{
            templateUrl: '/js/lease/tmpl/leases.html',
            controller: 'LeaseController'
            // controllerAs: 'propCtrl'
        })
        .when('/lease/:leaseId',{
            templateUrl: '/js/lease/tmpl/lease.html',
            controller: 'LeaseInfoController'
        })
        .when('/properties',{
            templateUrl: '/js/property/tmpl/properties.html',
            controller: 'PropertyController'
            // controllerAs: 'propCtrl'
        })
        .when('/calculator',{
            templateUrl: '/js/calculator/tmpl/calculateBill.html',
            controller: 'CalculatorCtrl'
            // controllerAs: 'calCtrl'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});
