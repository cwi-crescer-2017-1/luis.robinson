document.addEventListener('DOMContentLoaded', function() {
    let btnPesquisar = document.getElementById('btnPesquisar');
    btnPesquisar.onclick = function() {
        carregarPokemon(document.getElementById("idPokemon").value);
    }
});


var carregarPokemon = (idPokemon) => {
    let url = "http://pokeapi.co/api/v2/pokemon/" + idPokemon + "/";
    fetch(url).then(response => {
        response.json().then(json => {
            let pokemon = new Pokemon(json);
            pokemon.render();
            pokemon.renderStats();
        })
    });
};

// fetch("http://pokeapi.co/api/v2/pokemon/5/").then(response => response.json())
//   .then(json => {
//     console.log("JSON 1", json)
//     fetch("http://pokeapi.co/api/v2/pokemon/6/").then(response => response.json())
//       .then(json => {
//         console.log("JSON 2", json)
//         fetch("http://pokeapi.co/api/v2/pokemon/7/").then(response => response.json())
//           .then(json => {
//             console.log("JSON 3", json)
//           })
//       })
//   })

// let urls = [
//   "http://pokeapi.co/api/v2/pokemon/5/",
//   "http://pokeapi.co/api/v2/pokemon/6/",
//   "http://pokeapi.co/api/v2/pokemon/7/"
// ]
// urls.forEach(url => {
//   fetch(url)
//     .then(response => response.json())
//     .then(json => {
//       console.log(json);
//       console.log(json.sprites.front_default);
//       let div = document.getElementById('detalhesPokemon');
//       let img = document.createElement('img');
//       img.src = json.sprites.front_default;
//       div.append(img);
//     })
// })
