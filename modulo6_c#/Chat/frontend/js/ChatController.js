var modulo = angular.module('chatCwi', ['ngRoute']);

modulo.controller('ChatController', function ($scope, heroisService) {
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
