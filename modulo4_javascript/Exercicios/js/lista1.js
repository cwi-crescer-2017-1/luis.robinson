function daisyGame (number){
  if (number %2 == 0){
    console.log("Love me not");
  } else {
    console.log("Love me!");
  }
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
