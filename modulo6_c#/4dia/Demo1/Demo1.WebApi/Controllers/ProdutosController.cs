
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;

namespace Demo1.WebApi.Controllers
{
    public class ProdutosController : ApiController
    {
        ProdutoRepositorio _produtoRepositorio = new ProdutoRepositorio();
        //criar produto
        public IHttpActionResult Post(Produto produto)
        {

            var mensagens = new List<string>();
            if (produto.Validar(out mensagens))
                return BadRequest(string.Join(".", mensagens.ToArray()));

             
                //return Ok(string.Empty);
                  return Ok(produto);
        }

        public IHttpActionResult Get(Produto produto)
        {
            var produtos = _produtoRepositorio.Listar();
            //return Ok(string.Empty);
            return Ok(produto);
        }
    }
}