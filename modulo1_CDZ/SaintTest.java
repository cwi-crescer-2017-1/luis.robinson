

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest
{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        //AAA
        //1.Arrange - montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião",Categoria.OURO);
        Saint milo = new Saint("Milo",escorpiao);
        //2.Act - invocar a ação a ser testada
        milo.vestirArmadura();
        //3.Assert - verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
        
    }    
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint seiya = new Saint("Seiya", new Armadura("Pégaso",Categoria.BRONZE));
        assertEquals(false,seiya.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroNaoInformado(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,mu.getGenero());
    }
    
    @Test
    public void saintPodeMudarGenero(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        mu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO,mu.getGenero());
    } 
    
    @Test
    public void aoCriarSaintNasceVivo(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        assertEquals(Status.VIVO,mu.getStatus());
    }
    
    @Test
    public void aoCriarSaintNasceComVida(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        Double vida = 100.0;
        assertEquals(vida,mu.getVida());
    }
    
    @Test
    public void saintPodePerderVida(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        Double vida = mu.getVida() - 10.0;
        mu.perderVida(10.0);
        assertEquals(vida,mu.getVida());
    }
    
    @Test
    public void saintPerdeVidaNaBatalha(){
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        Saint seiya = new Saint("SEIYA",new Armadura("pégaso",Categoria.BRONZE));
        Batalha batalha = new Batalha(mu,seiya,10.0);
        batalha.iniciar();    
        
        Double vida = 90.0;        
        
        assertEquals(vida,seiya.getVida());
    }
    
}
