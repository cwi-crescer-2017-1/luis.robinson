using Microsoft.VisualStudio.TestTools.UnitTesting;
using FolhaPagamento;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolhaPagamento.Tests
{
    [TestClass()]
    public class DemonstrativoTests
    {
        [TestMethod()]
        public void SalarioBaseTest()
        {

            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(5000, demo.SalarioBase);           
        }

        [TestMethod()]
        public void HorasExtrasTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(1250.0, demo.HorasExtras.CalcHoras(), 0.10);           
           
        }

        [TestMethod()]
        public void HorasDescontadasTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(250.0, demo.HorasDescontadas.CalcHoras(), 0.10);            
        }

        [TestMethod()]
        public void TotalProventosTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(6000.0, demo.TotalProventos, 0.10);
        }

        [TestMethod()]
        public void InssTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(600, demo.Inss.CalcDesc(), 0.10);
        }

        [TestMethod()]
        public void IrrfTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(1485.00, demo.Irrf.CalcDesc(), 0.10);           
            
        }

        [TestMethod()]
        public void TotalDescontosTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(2085.00, demo.TotalDescontos, 0.10);
            
        }

        [TestMethod()]
        public void TotalLiquidoTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(3915.00, demo.TotalLiquido, 0.10);        
       
        }

        [TestMethod()]
        public void FgtsTest()
        {
            Demonstrativo demo = new GeradorDeDemonstrativo().GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(660.00, demo.Fgts.CalcDesc(), 0.10);

        }
    }
}