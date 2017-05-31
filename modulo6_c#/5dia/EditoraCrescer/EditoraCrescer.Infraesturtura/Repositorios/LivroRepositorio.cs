using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        { }

        public List<Livro> Listar()
        {
            return contexto.Livros.ToList();
        }

        public void Salvar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public Livro Excluir(int id)
        {
            var livroRemovido = contexto.Livros.FirstOrDefault(l => l.Isbn == id);
            contexto.Livros.Remove(livroRemovido);
            return livroRemovido;
        }
    }
}
