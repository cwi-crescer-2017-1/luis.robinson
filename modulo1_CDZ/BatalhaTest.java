

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BatalhaTest
{
   @Test
    public void primeiroSaintPerdeVidaNaBatalha(){
        Saint seiya = new Saint("SEIYA",new Armadura("Pégaso",Categoria.BRONZE));
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));        
        Batalha batalha = new Batalha(mu,seiya);
        batalha.iniciar();            
        Double vida = 90.0;        
        assertEquals(vida,seiya.getVida());
    }
    
    @Test
    public void segundoSaintPerdeVidaNaBatalha(){
        Saint aldebaran = new Saint("ALDEBARAN",new Armadura("Touro",Categoria.OURO));
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));        
        Batalha batalha = new Batalha(aldebaran,mu);
        batalha.iniciar();            
        Double vida = 90.0;        
        assertEquals(vida,mu.getVida());
    }
    
    public void primeiroSaintPerdeVidaNaBatalhaMesmoIiniciandoAtaque(){
        Saint marin = new Saint("ÁGUIA",new Armadura("Águia",Categoria.PRATA));
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));        
        Batalha batalha = new Batalha(marin,mu);
        batalha.iniciar();            
        Double vida = 90.0;        
        assertEquals(vida,marin.getVida());
    }
}
