using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto;

        public LivroRepositorio()
        {
            contexto = new Contexto();
        }

        public List<object> Obter()
        {
            //return contexto.Livros.ToList();

            return contexto.Livros.Select(x => new {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                Capa = x.UrlCapa,   
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero }).ToList<object>();
        }

        public List<Livro> ObterPorIsbn(int isbn)
        {
            return contexto.Livros.Where(x => x.Isbn == isbn).ToList();
        }

        public dynamic ObterPorGenero(string genero)
        {
            //contains case sensitive
            //return contexto.Livros.Where(x => x.Genero.Contains(genero)).ToList();

            return contexto.Livros.Select(x => new {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                Capa = x.UrlCapa,
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero })
                .Where(x => x.Genero.Contains(genero)).ToList();
        }

        public dynamic ObterLancamentos(DateTime data)
        {
            DateTime semana = data.AddDays(-7);

            return contexto.Livros
                .Where (x => x.DataPublicacao > semana)
                .Select (x => new { Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.UrlCapa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero })
                .ToList();
        }



        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        public Livro Delete(int isbn)
        {
            Livro livroExcluido = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livroExcluido);
            contexto.SaveChanges();
            return livroExcluido;
        }

        public void Alterar(Livro livro)
        {
            //Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();            
        }

        public void Dispose()
        {
            contexto.Dispose();
            //base.Dispose(disposing);
        }
            
    }
        
  }
