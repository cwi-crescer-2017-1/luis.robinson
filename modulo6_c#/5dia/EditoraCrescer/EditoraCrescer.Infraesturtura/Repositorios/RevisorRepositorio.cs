using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
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
    }
}
