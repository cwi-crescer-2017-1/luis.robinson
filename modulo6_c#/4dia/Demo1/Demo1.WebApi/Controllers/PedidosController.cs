using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        private PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Put(Pedido pedido)
        {
            List<string> mensagens;

            if (!pedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(".\n", mensagens.ToArray()));
            }
            _pedidoRepositorio.Alterar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Delete(int id)
        {
            if (id != null)
            {
                _pedidoRepositorio.Excluir(id);
                return Ok();
            }
            else
            {
                return BadRequest("Id precisa de um valor");
            }
        }

        public IHttpActionResult Get()
        {
            return Ok(_pedidoRepositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Post(Pedido pedido)
        {
            List<string> mensagens;

            if (!pedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(".\n", mensagens.ToArray()));
            }

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }
    }
}
