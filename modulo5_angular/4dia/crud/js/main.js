var app = angular.module('app',['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'AulaControl',
      templateUrl: 'aulas.html'
    })
    .when('/aulas/:idUrl', {
      controller: 'AulasControl',
      templateUrl: 'aulas.html'
    })
    // falta criar
    .when('/instrutores',{
      controller: 'InstrutoresControl',
      templateUrl: 'instrutores.html'
    })
    // falta criar
    .when('/instrutores/:idUrl',{
      controller: 'InstrutoresController',
      templateUrl: 'instrutores.html'
    })    
    .otherwise({
      redirectTo: '/index.html'
    });
});
