var modulo = angular.module('herois-app', []);

modulo.controller('HeroisController', function ($scope, heroisService) {
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

    function obterMensagem() {
        heroisService
        .obterHerois()
        .then(response => {
            $scope.herois = response.data;
        })
    }

    function enviarMensagem() {
        heroisService
        .enviarHeroi()
        .then(herois => {
            obterHerois();
        })
    }







});
