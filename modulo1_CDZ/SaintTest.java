

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;


public class SaintTest
{
    @After
    public void tearDown(){
        // java colletor
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        
        Saint milo = new GoldSaint("Milo", "Escorpião");
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", "Unicórnio");
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void statusInicialDeveSerVivo() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor10() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(10);
        // Assert
        assertEquals(90, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(100);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(1000);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", "Pégaso");
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", "Águia");
        assertEquals(6, marin.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint afrodite = new GoldSaint("Afrodite", "Peixes");
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", "Café");
    }
   

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }
    
    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }
    
    @Test(expected=ArithmeticException.class)
    public void getProximoMovimentoComListaVazia() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento movimento = hyoga.getProximoMovimento();
    }

    @Test
    public void getProximoMovimentoComUmMovimento() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(vestirArmadura);
        assertEquals(vestirArmadura, hyoga.getProximoMovimento());
    }
    
    @Test
    public void getProximoMovimentoDuasVezesComUmMovimento() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(vestirArmadura);
        hyoga.getProximoMovimento();
        assertEquals(vestirArmadura, hyoga.getProximoMovimento());
    }

    @Test
    public void criarUmSaintQtdSaintsDeveTerUmAMais() throws Exception {
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        assertEquals(1, Saint.getQtdSaints());
    }

    @Test
    public void criarDoisSaintQtdSaintsDeveTerDoisAMais() throws Exception {
        new BronzeSaint("Shun", "Andrômeda");
        new SilverSaint("Marin", "Águia");
        assertEquals(2, Saint.getQtdSaints());
    }

    @Test
    public void criarDuzentosSaintsQtdSaintsDeveTerDuzentosAMais() throws Exception {
        final int quantidade = 200;
        for (int i = 0; i < quantidade; i++) {
            new BronzeSaint("Bronze " + i, "Constelação " + i);
        }
        assertEquals(quantidade, Saint.getQtdSaints());
    }
    
    @Test
    public void getNewSaintsId() throws Exception{
        int valorId = Saint.getQtdSaints();
        Saint aldebaran = new GoldSaint("Aldebaran","Touro");
        int id = aldebaran.getId();     
        assertEquals(id,valorId + 1);
    }
}
