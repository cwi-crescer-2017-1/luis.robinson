function daisyGame (number){
  return number %2 == 0 ? 'Love me not' : 'Love me!'
  //  return 'Love me${ numero %2 !== 0 ? '' : ' not'}'
};

//daisyGame(3);
//daisyGame(4);

function maiorTexto(stringao){
  var maior = "UAU";
  for (var i = 0;i < stringao.length; i++){
    if (stringao[i].length > maior.length){
      maior = stringao[i];
    }
  }
  console.log("The big one is:",maior);
}

//var fruits = ["Banana", "Orange", "Apple", "Mango"];
//maiorTexto(fruits);

var instrutor = [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ] ;

function funcInstrutor(instrutor) {
   console.log('olá querido instrutor:', instrutor)
 };

function imprime(instrutor, funcao){
  if (typeof funcao !== 'function'){

    console.log("Não é uma function");
  } else {
    for (var i = 0;i < instrutor.length; i++){
        funcao(instrutor[i]);
    }
  }
};

//imprime(instrutor,funcInstrutor);

function somar (a){
  return function somar (b) {
    return a+b;
  }
};
//somar(3);
//somar(4);
//console.log("somar",somar(3)(4));

function fiboSum (number) {

   return number <= 1 ? number
        // viva lá recursividad.
        : fiboSum(number - 1) + fiboSum(number - 2);
};

console.log("somar",fiboSum(10));
