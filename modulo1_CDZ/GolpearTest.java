

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GolpearTest
{ 
    
    @Test
    public void bronzeSaintGolpearComArmaduraMultiplicaPor2 () throws Exception {
        Saint seiya = new BronzeSaint("Seyia", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Golpe golpe = new Golpe("Paulada", 10);
        seiya.vestirArmadura();
        seiya.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(seiya, hyoga);
        golpear.executar();

        assertEquals(100,seiya.getVida(), 0.01);
        assertEquals(80,hyoga.getVida(), 0.01);
    }
    
    @Test
    public void bronzeSaintGolpearSemArmadura() throws Exception {
        Saint seiya = new BronzeSaint("Seyia", "Pégaso");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Golpe golpe = new Golpe("Meteoro de pégaso", 10);        
        seiya.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(seiya, hyoga);
        golpear.executar();

        assertEquals(100,seiya.getVida(), 0.01);
        assertEquals(90,hyoga.getVida(), 0.01);
    }
    
    @Test
    public void silverSaintGolpearComArmaduraMultiplicaPor3 () throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint shina = new SilverSaint("Shina", "Cobra");
        Golpe golpe = new Golpe("Meteoro do amor", 10);
        marin.vestirArmadura();
        marin.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(marin, shina);
        golpear.executar();

        assertEquals(100,marin.getVida(), 0.01);
        assertEquals(70,shina.getVida(), 0.01);
    }
    
    @Test
    public void silverSaintGolpearSemArmadura () throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint shina = new SilverSaint("Shina", "Cobra");
        Golpe golpe = new Golpe("Meteoro do amor", 10);        
        marin.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(marin, shina);
        golpear.executar();

        assertEquals(100,marin.getVida(), 0.01);
        assertEquals(90,shina.getVida(), 0.01);
    }
    
    
    @Test
    public void goldSaintGolpearComArmaduraMultiplicaPor4 () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Saint kanon = new GoldSaint("Kanon", "Gêmeos");
        Golpe golpe = new Golpe("Explosão Galática", 10);
        saga.vestirArmadura();
        saga.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(saga, kanon);
        golpear.executar();

        assertEquals(100,saga.getVida(), 0.01);
        assertEquals(60,kanon.getVida(), 0.01);
    }
    
    @Test
    public void goldSaintGolpearSemArmadura () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Saint kanon = new GoldSaint("Kanon", "Gêmeos");
        Golpe golpe = new Golpe("Explosão Galática", 10);        
        saga.aprenderGolpe(golpe);
        Golpear golpear = new Golpear(saga, kanon);
        golpear.executar();

        assertEquals(100,saga.getVida(), 0.01);
        assertEquals(90,kanon.getVida(), 0.01);
    }
}
