﻿using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Salvar(livro);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            return Ok(repositorio.Excluir(id));
        }
    }
}
