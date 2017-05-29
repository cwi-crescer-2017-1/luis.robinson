using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ExemploWebApi.Models
{
    public class Mensagem
    {
        

        public int Id { get; set; }
        public string msg { get; set; }
        public int UserId { get; set; }
    }

}