using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    [RoutePrefix("api/Livros")]

    public class LivrosController : ApiController
    {
        private readonly LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            var livros = repositorio.ObterPorIsbn(isbn);

            return Ok(new { dados = livros });
        }

        [HttpGet]
        [Route("{genero:string}")]
        public IHttpActionResult Get(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);

            return Ok(new { dados = livros });
        }

        [HttpPost]
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

        [HttpDelete]
        [Route("{isbn:int}")]        
        public IHttpActionResult Remove(int isbn)
        {
            return Ok(repositorio.Delete(isbn));
        }

        
        
        public IHttpActionResult Alterar(int isbn, Livro livro)
        {
            if (isbn == livro.Isbn)
            {
                repositorio.Alterar(livro);
                return Ok();
            }
            else {
                return BadRequest("Sem id correto, sem livro.");
            }
            
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

