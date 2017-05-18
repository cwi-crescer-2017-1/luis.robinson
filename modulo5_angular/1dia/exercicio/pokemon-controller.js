var modulo = angular.module('aula01', []);

modulo.controller('controllerFiltro', ['$scope', function($scope){
  let pokemons = [
    $scope.pokemons = {id:1, nome:"Bulbassauro" , tipo:"planta"},
    $scope.pokemons = {id:2, nome:"Ivissauro" , tipo:"planta"},
    $scope.pokemons = {id:3, nome:"Venossauro" , tipo:"planta"},
    $scope.pokemons = {id:4, nome:"Charmander" , tipo:"fogo"},
    $scope.pokemons = {id:5, nome:"Charmeleon" , tipo:"fogo"},
    $scope.pokemons = {id:6, nome:"Charezard" , tipo:"fogo"},
    $scope.pokemons = {id:7, nome:"Squirtle" , tipo:"água"},
    $scope.pokemons = {id:8, nome:"Wartortle" , tipo:"água"},
    $scope.pokemons = {id:9, nome:"Blastoise" , tipo:"água"},
    $scope.pokemons = {id:150, nome:"Mewtwo" , tipo:"Psiquico"}
  ];
$scope.pokemons = pokemons;
}]);
