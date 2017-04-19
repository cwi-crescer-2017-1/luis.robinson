

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class ConstelacaoTest
{
    @Test
    public void adicionarUmGolpe() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe golpes = new Golpe("Outra dimensão",10);
        gemeos.adicionarGolpe(golpes);
        assertEquals(golpes, gemeos.getGolpes().get(0));

    }

    @Test
    public void adicionarDoisGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));        
    }

    @Test
    public void adicionarTresGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 60);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);

        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));
        assertEquals(sataImperial, gemeos.getGolpes().get(2));
    }

    @Test
    public void adicionarQuatroGolpes() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 60);
        Golpe coleraCafeIntenso = new Golpe("Cólera Café intenso",80);
        
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        gemeos.adicionarGolpe(sataImperial);
        gemeos.adicionarGolpe(coleraCafeIntenso);
        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));
        assertEquals(sataImperial, gemeos.getGolpes().get(2));
        assertEquals(coleraCafeIntenso, gemeos.getGolpes().get(3));}
}