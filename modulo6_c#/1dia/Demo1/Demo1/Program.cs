using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            /*


            // instanciar
            Pessoa pessoa = new Pessoa();
            pessoa.Id = 1;
            pessoa.Id = null;
            pessoa.Nascimento = new DateTime(1982, 10, 29);
            pessoa.Nome =
                String.Concat("Giovani Decusati", " oi ");

            pessoa.Nome = $"Giovani Decusati {pessoa.Id}";
            pessoa.Nome = $"Giovani Decusati" + pessoa.Id;

            char letra = 'C';

            if (pessoa.Id == null)
            {
                Console.WriteLine("Não tem valor");
            }
            else
            {
                Console.WriteLine("Tem valor");
            }
            // ctrl + k + d = alinhamento
            // ou
            var pessoa2 = new Pessoa();

            Console.WriteLine("Informe peso");
            var entradaPeso = Console.ReadLine();
             

            Console.WriteLine("Informe altura");
            var entradaAltura = Console.ReadLine();

            //var peso = double.Parse(entradaPeso);
            var peso = 0D;
            // toca no out o que tentou tocar
            if (!double.TryParse(entradaPeso, out peso))
                Console.WriteLine("Entrada Inválida");
            
            
            var altura = double.Parse(entradaAltura);

            var calculoIMC = new CalculoIMC(altura, peso);
            var imc = calculoIMC.CalcularIMC();

            Console.WriteLine($"Seu imc é:{imc}");
            Console.WriteLine(pessoa.Nome);
            Console.ReadKey();

            /*
             * Armazene os dados de entrada em um vetor de inteiros 
             
            List<int> entradas = new List<int>();
            //var entradas = new int[] { };
            int number;
            while (true)
            {
                Console.WriteLine("Digite um valor");
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }
                
                if (!int.TryParse(entrada, out number))
                {
                    Console.WriteLine("Entrada Inválida");
                }
                else
                {
                    // não rola, pq array não é dinâmico em size.
                    // temq ue reconstruir ele toda vez, ou usar list.
                    entradas.Add(number);
                        
                    Console.WriteLine(number);
                    
                }

            }
                */

            Dictionary<int, string> example = new Dictionary<int, string>();
            example.Add(1, "teste");
           
            //Console.WriteLine(example[1]);

            String value;
            if (example.TryGetValue(1, out value))
            {
                example[1] = value + 1;
                Console.WriteLine(example[1]);
            }

            Console.ReadKey();

        }
    }
}
