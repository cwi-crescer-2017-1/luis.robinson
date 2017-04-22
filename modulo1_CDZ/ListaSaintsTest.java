

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class ListaSaintsTest
{
     @Test public void buscarSaintExistentePorNome() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new SilverSaint ("June", "Camaleão");
        lista.adicionar(june);
        assertEquals(june, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintExistenteComRepeticaoDeNomes() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint june2 = new SilverSaint("June", "Camaleão 2");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertEquals(june2, lista.buscarPorNome("June"));
    }

    @Test public void buscarSaintInexistente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint june2 = new SilverSaint("June", "Camaleão 2");
        lista.adicionar(june2);
        lista.adicionar(june);
        assertNull(lista.buscarPorNome("San Junipero"));
    }

    @Test public void buscarSaintComListaVazia() {
        assertNull(new ListaSaints().buscarPorNome("Seiya"));
    }

    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new BronzeSaint("Misty", "Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty","Lagarto");
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        misty.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new SilverSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(100);
        june.perderVida(100);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }
    
     @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }
    
    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }
    
    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }
    
    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(new ArrayList<Saint>(), resultado);
    }
    
    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarDescendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarDescendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarDescendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(june, resultado.get(2));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(0));
    }
    
    @Test
    public void ordenarDescendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(2));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(0));
    }
    
    
    @Test
    public void ordenarAscendenteComListaApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        shun.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }
    
    @Test
    public void ordenarAscendenteComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void ordenarAscendenteComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarAscendenteComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new SilverSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = listaSaints.getSaints();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void unirDuasListas() throws Exception{
    ListaSaints lista = new ListaSaints();
    Saint june = new SilverSaint("June", "Camaleão");
    june.setGenero(Genero.FEMININO);
    june.perderVida(15.5);
    lista.adicionar(june);

    Saint dohko = new GoldSaint("Dohko", "Libra");
    dohko.perderVida(90);
    dohko.vestirArmadura();
    lista.adicionar(dohko);
    
    }
    @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }

    @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }

    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"+"\n"+"Dohko,10.0,,OURO,VIVO,NAO_INFORMADO,true";
        //assertEquals(esperado, lista.getCSV());
    }
}
