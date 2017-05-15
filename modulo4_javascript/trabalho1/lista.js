//Exer 1
function seriesInvalidas(series){
    seriesInvalidadas = new Array;
    var data = new Date();
    for(let i = 0; i < series.length; i++){
        if(series[i].anoEstreia > data.getFullYear() || Object.values(series[1]) === "undefined" || Object.values(series[1]) === "null"){
            seriesInvalidadas.push(series[i].titulo);
        }
    }
    return seriesInvalidadas.toString();
};

console.log(seriesInvalidas(series));
//for in , propriedades do objeto
// Ex 01
// 1. criar funcao para verificar se série é inválida
// 2. aplicar criterio de verificação de série inválida para as séries originais
// 3. retornar string resultante de acordo com o formato esperado
function seriesInvalidas1(series) {
  let invalidas = series.filter(serie => {
    // for (let campo in serie) { }
    let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
    let estreiaInvalida = serie.anoEstreia > new Date().getFullYear();
    return estreiaInvalida || algumCampoInvalido;
  });
  return `Séries Inválidas: ${ invalidas.map(s => s.titulo).join(" - ") }`;
}

//

//Exer 2
var filtrarSeriesPorAno = (series, ano) =>
    series.filter(s => s.anoEstreia >= ano);
console.log(filtrarSeriesPorAno(series, 2017));

// retorna um array com todas as séries com
// ano de estreia igual ou maior que 2017.
function filtrarSeriesPorAno1(series, ano) {
  return series.filter(s => s.anoEstreia >= ano)
}

//Exer 3
// testando arrow function
var mediaEpisodios = (series) => {
    return series.reduce((total, serie) =>
        total + serie.numeroEpisodios, 0) / series.length;
};
console.log(mediaEpisodios(series));
/ numeroEpisodios
// 34.1
function mediaDeEpisodios1(series) {
  // return series
  //   .map(function(s) { return s.numeroEpisodios })
  //   .reduce(function(acc, numeroEpisodios) { return acc + numeroEpisodios }, 0) / series.length;
  return series
    .map(s => s.numeroEpisodios)
    .reduce((acc, numeroEpisodios) => acc + numeroEpisodios) / series.length;
}
//

//Exer 4
var procurarPorNome = (series, nome) =>
    series.filter(s => s.elenco.indexOf(nome) >= 0).length > 0;

console.log(procurarPorNome(series, "Luis Robinson"));

function procurarPorNome1(series, nome) {
  // indexOf
  return series.some(s => s.elenco.some(e => e.includes(nome)));
}
//
//Exer 5
var mascadaEmSerie = (serie) =>
    serie.elenco.length * 40000 + serie.diretor.length * 100000;

//console.log(mascadaEmSerie(series[0]));

//Retorna o valor total de gastos contando os diretores e o elenco
function mascadaEmSerie1(serie) {
  let custoComDiretores = serie.diretor.length * 100000;
  let custoComElenco = serie.elenco.length * 40000;
  return custoComDiretores + custoComElenco;
}
//

//Exer 6
var queroGenero = (gen, series) => {
    return series.filter(s => s.genero.indexOf(gen) >= 0)
        .map(s => s.titulo);
};

function queroGenero1(genero) {
  return series.filter(s => s.genero.includes(genero));
}
//

//console.log(queroGenero("Caos", series));

var queroTitulo = (tit, series) => {
    return series.filter(s => s.titulo.includes(tit))
        .map(s => s.titulo);
};

//console.log(queroTitulo("The", series));

//Exer 7

var creditosIlluminatis = (serie) => {
    console.log("Titulo: ", serie.titulo);
    serie.diretor.sort(ordenarPorNomeAsc);
    serie.elenco.sort(ordenarPorNomeAsc);
    console.log("DIRETORES");
    serie.diretor.forEach(imprimir);
    console.log("ELENCO");
    serie.elenco.forEach(imprimir);
};

var imprimir = (elenco) => console.log(elenco);

var ordenarPorNomeAsc = (a, b) => {
    let splitA = a.split(" ");
    let splitB = b.split(" ");
    let ultimoNomeA = splitA[splitA.length - 1];
    let ultimoNomeB = splitB[splitB.length - 1];
    if (ultimoNomeA > ultimoNomeB) {
        return 1;
    } else if (ultimoNomeA < ultimoNomeB) {
        return -1;
    } else {
        return 0;
    }
};

creditosIlluminatis(series[1]);
