using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class ChatController : ApiController
    {
        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static int contador = 1; // id começa do primeiro.
        private static object @lock = new object();

        public IEnumerable<Mensagem> Get(string msg, int userid, int? id = null)
        { // só para listar os users
            return mensagens.Where(x =>
                (id == null || x.Id == id) &&
                (msg == null || x.Msg == msg) &&
                (x.UserId == userid)
            );
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    mensagens.Add(mensagem);
                    mensagem.Id = contador++;
                }

                return Ok(mensagem);
            }
        }
    }
}
