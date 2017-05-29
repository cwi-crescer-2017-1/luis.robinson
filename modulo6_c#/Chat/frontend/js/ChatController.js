var modulo = angular.module('chatCwi', ['ngRoute']);

modulo.controller('ChatController', function ($scope, heroisService) {
    $scope.herois = {};
    $scope.enviarMensagem = enviarMensagem;
    obterMensagem();

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
