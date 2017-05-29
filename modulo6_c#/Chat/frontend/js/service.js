modulo.factory("loginService", function ($http) {
    return ({
        obterHerois: obterHerois,
        enviarHeroi: enviarHeroi
    });

    function obterHerois() {
        return $http.get("http://localhost:24206/api/Login");
    }

    function enviarHeroi() {
        return $http({
            method: "post",
            url: "http://localhost:24206/api/Login",
            data: {
                "Id": 0,
                "Nome": "Giovani",
                "Poder": {
                    "Nome": "Threads",
                    "Dano": 9999
                }
            }
        });
    }
});

modulo.factory("chatService", function ($http) {
    return ({
        obterHerois: obterHerois,
        enviarHeroi: enviarHeroi
    });

    function obterHerois() {
        return $http.get("http://localhost:24206/api/Chat");
    }

    function enviarHeroi() {
        return $http({
            method: "post",
            url: "http://localhost:24206/api/Chat",
            data: {
                "Id": 0,
                "Nome": "Giovani",
                "Poder": {
                    "Nome": "Threads",
                    "Dano": 9999
                }
            }
        });
    }
});
