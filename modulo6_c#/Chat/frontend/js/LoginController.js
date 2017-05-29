var modulo = angular.module('chatCwi', ['ngRoute']);

modulo.controller('LoginController', function ($scope, heroisService) {
    $scope.herois = {};
    $scope.enviarHeroi = enviarHeroi;
    obterHerois();

    function obterHerois() {
        heroisService
        .obterHerois()
        .then(response => {
            $scope.herois = response.data;
        })
    }

    function enviarHeroi() {
        heroisService
        .enviarHeroi()
        .then(herois => {
            obterHerois();
        })
    }

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
