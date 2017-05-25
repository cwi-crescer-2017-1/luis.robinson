using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class Demonstrativo
    {
        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = Math.Round(salarioBase, 2);
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = Math.Round(totalProventos, 2);
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = Math.Round(totalDescontos, 2);
            TotalLiquido = Math.Round(totalLiquido, 2);
            Fgts = fgts;
        }

        public void ImprimeConsole()
        {

            /*
             * +---------------------------------------------------+
               -DEMONSTRATIVO DE FOLHA DE PAGAMENTO (CONTRA-CHEQUE)-
               +---------------------------------------------------+
               -Salário Mensalista (200hrs)                  5000,00
               -Horas Extras (50hrs)                         1250,00
               -Horas Descontadas (10hrs)                     250,00
               -Total de Proventos                           6000,00
               -INSS (10%)                                    600,00
               -IRRF (27,5%)                                 1485,00
               -Total de Descontos                           2085,00
               -Total Líquido                                3915,00
               -FGTS (11%)                                    660,00
               +---------------------------------------------------+
               -----------------------FIM---------------------------
               +---------------------------------------------------+
             * */

            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-DEMONSTRATIVO DE FOLHA DE PAGAMENTO (CONTRA-CHEQUE)-");
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine($"-Salário Mensalista               { SalarioBase}");
            Console.WriteLine($"-Horas Extras                     {HorasExtras.CalcHoras()}");
            Console.WriteLine($"-Horas Descontadas                {HorasDescontadas.CalcHoras()}");
            Console.WriteLine($"-Total de Proventos               {TotalProventos}");
            Console.WriteLine($"-INSS                             {Inss.CalcDesc()}");
            Console.WriteLine($"-IRRF                             {Irrf.CalcDesc()}");
            Console.WriteLine($"-Total de Descontos               {TotalDescontos}");
            Console.WriteLine($"-Total Líquido                    { TotalLiquido}");
            Console.WriteLine($"-FGTS                             {Fgts.CalcDesc()}");            
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-----------------------FIM---------------------------");
            Console.WriteLine("+---------------------------------------------------+");            

        }

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }


}
