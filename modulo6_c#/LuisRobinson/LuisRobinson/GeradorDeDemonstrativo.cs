using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    public class GeradorDeDemonstrativo : IFolhaPagamento
    {
        public GeradorDeDemonstrativo() {

        }

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double SalarioBase = salarioBase;
            double HorasConvencao = horasCategoria;
            double HorasExtras = horasExtras;
            double HorasDescontadas = horasDescontadas;

            // Totais
            var TotalHorasExtras = new HorasCalculadas(HorasExtras, SalarioBase / HorasConvencao);
            var TotalHorasDescontadas = new HorasCalculadas(HorasDescontadas, SalarioBase / HorasConvencao);


            double totalSalario = (SalarioBase + TotalHorasExtras.CalcHoras() - TotalHorasDescontadas.CalcHoras());

            double aliquota = 0.0;

            // regras de alíquota
            if (totalSalario < 1000)
            {
                aliquota = 8.0;
            }

            else if (totalSalario < 1500)
            {
                aliquota = 9.0;
            }

            else
            {
                aliquota =  10.0;
            }
            
                        
            // regras de INSS
            var INSS = new Desconto(aliquota, totalSalario);
            double valIRRF = totalSalario - INSS.CalcDesc();

            //regras de IRRF
            if (valIRRF < 1710.18)
            {
                aliquota = 0;
            }

            else if (valIRRF < 2563.91)
            {
                aliquota = 7.5;
            }

            else if (valIRRF < 3418.59)
            {
                aliquota = 15.0;
            }

            else if (valIRRF < 4271.59)
            {
                aliquota = 22.5;
            }

            else
            {
                aliquota = 27.5;
            }

            Desconto IRRF = new Desconto(aliquota, valIRRF);

            //Descontos
            double totalDescontos = INSS.CalcDesc() + IRRF.CalcDesc();
            double totalLiquido = totalSalario - totalDescontos;

            //FGTS
            Desconto FGTS = new Desconto(11, totalSalario);

            return new Demonstrativo(SalarioBase, HorasConvencao, TotalHorasExtras, TotalHorasDescontadas,
            totalSalario, INSS, IRRF, totalDescontos, totalLiquido, FGTS);
            

        }
    }


}
