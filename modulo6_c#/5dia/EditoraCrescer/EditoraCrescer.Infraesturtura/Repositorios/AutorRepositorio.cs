using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public void Salvar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Autor Excluir(int id)
        {
            var autorExcluido = contexto.Autores.FirstOrDefault(a => a.Id == id);
            contexto.Autores.Remove(autorExcluido);
            contexto.SaveChanges();
            return autorExcluido;
        }
    }
}
