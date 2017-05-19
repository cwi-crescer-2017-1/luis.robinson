let app = angular.module('app', []);

app.controller('MainController', function ($scope) {

  $scope.nomes = ['Bernardo', 'Nunes'];

  $scope.incluir = function (novoNome) {

    if ($scope.meuForm.$valid) {
      $scope.nomes.push(novoNome);
    }
  };

  $scope.instrutores = [
  {
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }
];

$scope.aulas = [
  'OO',
  'HTML e CSS',
  'Javascript',
  'AngularJS',
  'Banco de Dados I'
];



});
