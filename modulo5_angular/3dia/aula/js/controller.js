let app = angular.module('app', []);

app.controller('MainController', function ($scope) {

  $scope.nomes = ['Bernardo', 'Nunes'];

  $scope.incluir = function (novoNome) {

    if ($scope.meuForm.$valid) {
      $scope.nomes.push(novoNome);
    }
  }

  let instrutores = [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }
];

let aulas = [
  'OO',
  'HTML e CSS',
  'Javascript',
  'AngularJS',
  'Banco de Dados I'
];

});
