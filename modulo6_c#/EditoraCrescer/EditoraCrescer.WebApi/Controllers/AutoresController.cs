using EditoraCrescer.Infraesturtura;
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
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public HttpResponseMessage ObterAutores()
        {
            var autores = repositorio.Listar();
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autores });
        }

        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterAutorPorId(int id)
        {
            var autor = repositorio.ObterPorId(id);            
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
        }       

        [HttpPost]

        public HttpResponseMessage Post(Autor autor)
        {   repositorio.Salvar(autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage Update(int id, Autor autor)
        {            
            var autorNovo = repositorio.Alterar(id, autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autorNovo });
        }

        [Route("{id:int}")]
        [HttpDelete]
        public HttpResponseMessage Delete(int id)
        {
            repositorio.Excluir(id);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
