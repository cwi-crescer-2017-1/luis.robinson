using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Pessoa
    {
        protected double PrecoInterno = 1.0;
        internal double PropInternal;
        public const double Pi = 3.14;
        public readonly double PIreadonly = 3.14;
        public string Nome { get; set; }
        public int? Id { get; set; }
        // o ? diz que id pode ser null
        public DateTime Nascimento { get; set; }
        //prop gera propriedade com get e set. 
       
        //ctor gera o contrutor do método
        public Pessoa()
        {
            this.PrecoInterno = 3.14;

        }

    }
}
