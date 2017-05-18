var modulo = angular.module('aula02', []);


modulo.controller('Exemplo01', function ($scope, $filter) {

  //console.log($locale);

  //$scope.dataDigitada = document.getElementsByName("data").value;
  $scope.converter = converter;


  function converter() {
    if (angular.isUndefined($scope.dataDigitada)) {
    return;
  }

  let pattern = '/(\d{2})\/(\d{2})\/(\d{4})/';
  let replace = '$1.$2.$3';
  let dataFormatada = $scope.dataDigitada.replace(pattern, replace);
  console.log(dataFormatada);

  let dataObjeto = new Date(dataFormatada);

  $scope.dataObjeto = dataObjeto;
  $scope.dataPronta = $filter('date')(dataObjeto, 'shortDate');


}


var instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];

$scope.instrutores = instrutores;

});

modulo.filter('mascada',function(){
  return function(nome){
        return nome.replace(/Nunes/i,'$ Nunes $');
  }
});
