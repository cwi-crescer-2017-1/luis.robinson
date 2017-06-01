using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public Autor ObterPorId(int id)
        {
            Autor autor = contexto.Autores.FirstOrDefault(x => x.Id == id);            
            return autor;
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

        public Autor Alterar(int id, Autor autorModificado)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Entry(autorModificado).State = EntityState.Modified; 
            contexto.SaveChanges();
            return contexto.Autores.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
