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
