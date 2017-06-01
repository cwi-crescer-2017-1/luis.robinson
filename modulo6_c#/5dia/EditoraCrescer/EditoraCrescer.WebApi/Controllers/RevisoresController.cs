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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private RevisorRepositorio repositorio = new RevisorRepositorio();


        [HttpGet]
        public HttpResponseMessage Get()
        {
            var revisores = repositorio.Listar();
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisores });

        }

        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterPorId(int id)
        {
            var revisor = repositorio.ObterPorId(id);            
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }


        [HttpPost]
        public HttpResponseMessage Post(Revisor revisor)
        {            
            repositorio.Salvar(revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage AlterarRevisor(int id, Revisor revisor)
        {            
            repositorio.Alterar(id, revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
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
