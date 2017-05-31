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

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public List<Livro> ObterPorIsbn(int isbn)
        {
            return contexto.Livros.Where(x => x.Isbn == isbn).ToList();
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros.Where(x => x.Genero == genero).ToList();
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
