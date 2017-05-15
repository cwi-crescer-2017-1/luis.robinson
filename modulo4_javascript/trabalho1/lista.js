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
}

console.log(seriesInvalidas(series));
