﻿using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebApi.Controllers
{
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Salvar(autor);
            return Ok();
        }

        public IHttpActionResult Delete(int id)
        {
            return Ok(repositorio.Excluir(id));
        }
    }
}
