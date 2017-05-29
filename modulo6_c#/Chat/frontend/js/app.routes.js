angular.module('app').config(function ($routeProvider) {

  $routeProvider
    .when('/login', {
      controller: 'LoginController',
      templateUrl: '/home.html'
    })
    .when('/chat', {
      controller: 'ChatController',
      templateUrl: '/chat.html'
    })
    .otherwise({
      redirectTo: '/index.html'
    });
});
