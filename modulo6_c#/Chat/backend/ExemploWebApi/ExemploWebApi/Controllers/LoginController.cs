using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class LoginController : ApiController
    {
        private static List<Usuario> usuarios = new List<Usuario>();
        private static int contador = 1; // id começa do primeiro.
        private static object @lock = new object();

        public IEnumerable<Usuario> Get(string nome = null, string senha, int? id = null)
        { // só para listar os users
            return usuarios.Where(x => 
                (id == null || x.Id == id) &&
                (nome == null || x.Nome == nome) &&
                ( x.Senha == senha) 
            );
        }

        public IHttpActionResult Post(Usuario user)
        {
            if (user == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    usuarios.Add(user);
                    user.Id = contador++;
                }

                return Ok(user);
            }
        }
    }
}
