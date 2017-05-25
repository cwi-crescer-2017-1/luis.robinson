using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento
{
    class Program
    {
        static void Main(string[] args)
        {           
            
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            demo.ImprimeConsole();


            Console.ReadKey();
        }
    }
}
