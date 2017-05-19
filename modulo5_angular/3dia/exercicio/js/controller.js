
var modulo = angular.module('Aula02',[]);


modulo.controller('instrutoresController',function($scope){


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
			let orderAula  = []

			instrutores.forEach( instrutor =>
				instrutor.aula.forEach(aula =>
					orderAula.push({numero : aula.numero, aula : aula.nome ,nome : instrutor.nome }
			)))



			$scope.instrutores = orderAula;
})

modulo.filter('filtroAulaInstrutor',function(){
	return function(instrutor){

// se ins > 10 só precisa de um 0.
		let lpad = instrutor.numero > 10 ? '0' : '00'
		let numero = lpad + instrutor.numero
		let aula = instrutor.aula.toUpperCase();

		return `${numero} - ${aula}`

	}
})
