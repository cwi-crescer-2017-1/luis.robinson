

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
}
