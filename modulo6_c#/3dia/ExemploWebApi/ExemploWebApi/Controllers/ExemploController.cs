using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    // app start tem um arquivo com os comandos
    // Exemplo,pois o controller no final é automático
    public class ExemploController : ApiController
    {
        public HttpResponseMessage Get(string cor)
        {
            var response = new HttpResponseMessage(HttpStatusCode.OK);
            response.Content = new StringContent($"<html><body style=\"background-color:{cor};color: white;\">Hello World</body></html>");
            response.Content.Headers.ContentType = new MediaTypeHeaderValue("text/html");
            return response;
        }
    }




}
