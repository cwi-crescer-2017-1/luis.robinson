﻿using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {

        string stringConexao =
                "Server=13.65.101.67;User Id=luis.robinson;Password=123456;Database=aluno23db";


        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE Pedido 
                             SET NomeCliente = @nome 
                           WHERE Id = @pedidoId";

                    comando.Parameters.AddWithValue("nome", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("pedidoId", pedido.Id);
                    comando.ExecuteNonQuery();                    
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO 
                                            Pedido (NomeCliente) 
                                            VALUES (@nome)";
                    comando.Parameters.AddWithValue("nome", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                    comando.Parameters.Clear();

                    foreach (var Item in pedido.Itens)
                    {
                        //Cria os itens do pedido
                        comando.CommandText = @"INSERT INTO
                                                 ItemPedido (ProdutoId, PedidoId, Quantidade) 
                                                     VALUES (@Id, @pedidoId, @quantidade)";

                        comando.Parameters.AddWithValue("Id", Item.Id);
                        comando.Parameters.AddWithValue("produtoId", Item.ProdutoId);
                        comando.Parameters.AddWithValue("quantidade", Item.Quantidade);
                        comando.ExecuteNonQuery();
                        comando.Parameters.Clear();
                        
                        //Atualiza estoque.
                        comando.CommandText = @"UPDATE Produto
                                                   SET Estoque = Estoque -  @quantidade 
                                                 WHERE Id = @itemProdutoId";

                        comando.Parameters.AddWithValue("quantidade", Item.Quantidade);
                        comando.Parameters.AddWithValue("itemProdutoId", Item.ProdutoId);
                        comando.Parameters.Clear();
                    }
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var commando = conexao.CreateCommand())
                {
                    commando.CommandText =
                        @"DELETE 
                            FROM Pedido 
                           WHERE Id = @Id";

                    commando.Parameters.AddWithValue("Id", id);
                    commando.ExecuteNonQuery();

                    
                    
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            List<Pedido> pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id,
                                 NomeCliente 
                            FROM Pedido";

                    var dataReader = comando.ExecuteReader();

                    // popula a lista de pedidos
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = new List<ItemPedido>();

                        pedidos.Add(pedido);
                    }


                    foreach (var pedido in pedidos)
                    {
                        comando.CommandText = @"SELECT PedidoId,
                                                       ProdutoId, 
                                                       Quantidade
                                                  FROM ItemPedido 
                                                 WHERE PedidoId = @pedidoId";

                        comando.Parameters.AddWithValue("pedidoId", pedido.Id);
                        dataReader = comando.ExecuteReader();
                        comando.Parameters.Clear();

                        while (dataReader.Read())
                        {                            
                            var pedidoItem = new ItemPedido();

                            pedidoItem.Id = (int)dataReader["Id"];
                            pedidoItem.ProdutoId = (int)dataReader["ProdutoId"];
                            pedidoItem.Quantidade = (int)dataReader["Quantidade"];

                            pedido.Itens.Add(pedidoItem);
                        }
                    }
                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = new Pedido();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id, 
                                 NomeCliente 
                            FROM Pedido 
                           WHERE Id = @id";

                    comando.Parameters.AddWithValue("id", id);

                    var dataReader = comando.ExecuteReader();

                    // teoricamente só pode haver um ID.
                    if (dataReader.Read())
                    {
                        pedido.Id = id;
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        pedido.Itens = new List<ItemPedido>();

                        comando.CommandText = @"SELECT PedidoId, 
                                                       ProdutoId, 
                                                       Quantidade
                                                  FROM ItemPedido 
                                                 WHERE PedidoId = @pedidoId";

                        comando.Parameters.AddWithValue("pedidoId", pedido.Id);

                        dataReader = comando.ExecuteReader();

                        while (dataReader.Read())
                        {
                            var itemPedido = new ItemPedido();

                            itemPedido.Id = (int)dataReader["Id"];
                            itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                            itemPedido.Quantidade = (int)dataReader["Quantidade"];                            

                            pedido.Itens.Add(itemPedido);
                        }
                    }

                    
                }
            }
            return pedido;        
    }
    }
}
