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

//Exer 2
var filtrarSeriesPorAno = (series, ano) =>
    series.filter(s => s.anoEstreia >= ano);
console.log(filtrarSeriesPorAno(series, 2017));

//Exer 3
// testando arrow function
var mediaEpisodios = (series) => {
    return series.reduce((total, serie) =>
        total + serie.numeroEpisodios, 0) / series.length;
};
console.log(mediaEpisodios(series));

//Exer 4
var procurarPorNome = (series, nome) =>
    series.filter(s => s.elenco.indexOf(nome) >= 0).length > 0;

console.log(procurarPorNome(series, "Luis Robinson"));

//Exer 5
var mascadaEmSerie = (serie) =>
    serie.elenco.length * 40000 + serie.diretor.length * 100000;

//console.log(mascadaEmSerie(series[0]));

//Exer 6
var queroGenero = (gen, series) => {
    return series.filter(s => s.genero.indexOf(gen) >= 0)
        .map(s => s.titulo);
};

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
