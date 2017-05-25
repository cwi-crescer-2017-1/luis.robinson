using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }
        public double CalcDesc()
        {
            return Math.Round(Valor * (Aliquota / 100),2);
        }
        

        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
        public double Inss { get; private set; }
        public double Irrf { get; private set; }
        public double Fgts { get; private set; }
    }

}
