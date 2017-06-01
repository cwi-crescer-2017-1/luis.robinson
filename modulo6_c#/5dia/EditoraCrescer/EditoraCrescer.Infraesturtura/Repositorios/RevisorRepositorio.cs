using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterPorId(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Salvar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Excluir(int id)
        {
            var revisorExcluido = contexto.Revisores.FirstOrDefault(a => a.Id == id);
            contexto.Revisores.Remove(revisorExcluido);
            contexto.SaveChanges();
            return revisorExcluido;
        }

        public Revisor Alterar(int id, Revisor revisorModificado)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Entry(revisorModificado).State = EntityState.Modified; 
            contexto.SaveChanges();
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
