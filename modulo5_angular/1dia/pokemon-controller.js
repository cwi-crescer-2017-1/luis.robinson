var modulo = angular.module('aula01', []);

modulo.controller('FindPokemon', $scope => {
    $scope.pokemon = {
        nome: 'Gastly',
        tipo: 'Fantasma'
    }

})

modulo.controller('FindImgPokemon',$scope =>{
    $scope.pokemon = {

        sprite: 1
    }
})


;