using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            // concatena mensagem de erro.
            foreach (var Item in Itens) {
                if(Item.Quantidade < 1)
                {
                    mensagens.Add($"{Item.ProdutoId} sem estoque.");
                }
            }

            return mensagens.Count() == 0;
        }
    }
}
