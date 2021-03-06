function daisyGame (number){
  return number %2 == 0 ? 'Love me not' : 'Love me!'
  //  return `Love me${ numero %2 !== 0 ? '' : ' not'}`
};

//daisyGame(3);
//daisyGame(4);

function maiorTexto(stringao){
  var maior = "UAU";
  for (let i = 0;i < stringao.length; i++){
    if (stringao[i].length > maior.length){
      maior = stringao[i];
    }
  }
  // let morre no bloco.
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
  return function(b) {
    return a+b;
  }
};
//somar(3);
//somar(4);
//console.log("somar",somar(3)(4));

function fiboSum (number) {
  if (number === 1){
    return 1;
  }
   return fibonacci(number) + fiboSum(number - 1);
};

console.log("somar",fiboSum(10));

function fibonacci(n){
  if(n === 1 || n === 2) {
    return 1;
  }
  return fibonacci(n-1) + fibonacci(n-2);
};


function queroCafe(mascada,precos){
  let dentroDoOrcamento = [];
  precos.forEach(p => {
    if (p <= mascada){
      dentroDoOrcamento.push(p);
    }
    return dentroDoOrcamento.sort((a,b) => a-b).join(',');
  })
};

function arredondaNumero(num,casas){
  return  casas === null? num.toFixed(2) : num.toFixed(casas);
}

console.log("ar",arredondaNumero(3.1444,3));

function roundNumber(num, scale) {
  scale === null ? scale == 2 : scale == scale ;
  
  if(!("" + num).includes("e")) {
    return +(Math.round(num + "e+" + scale)  + "e-" + scale);
  } else {
    var arr = ("" + num).split("e");
    var sig = ""
    if(+arr[1] + scale > 0) {
      sig = "+";
    }
    return +(Math.round(+arr[0] + "e" + sig + (+arr[1] + scale)) + "e-" + scale);
  }
};

console.log("round",roundNumber(3.1444,3));
