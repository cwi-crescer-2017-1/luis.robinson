var modulo = angular.module('chatCwi', ['ngRoute']);

modulo.controller('LoginController', function ($scope, heroisService) {
    $scope.herois = {};
    $scope.enviarLogin = enviarLogin;
    obterLogin();

    function obterLogin() {
        heroisService
        .obterHerois()
        .then(response => {
            $scope.herois = response.data;
        })
    }

    function enviarLogin() {
        heroisService
        .enviarHeroi()
        .then(herois => {
            obterHerois();
        })
    }

});
