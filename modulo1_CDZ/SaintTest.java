

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest
{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida()throws Exception{
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
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        Saint seiya = new Saint("Seiya", new Armadura("Pégaso",Categoria.BRONZE));
        assertEquals(false,seiya.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroNaoInformado() throws Exception{
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,mu.getGenero());
    }
    
    @Test
    public void saintPodeMudarGenero()throws Exception{
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        mu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO,mu.getGenero());
    } 
    
    @Test
    public void aoCriarSaintNasceVivo()throws Exception{
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
        assertEquals(Status.VIVO,mu.getStatus());
    }
    
    @Test
    public void aoCriarSaintNasceComVida()throws Exception{
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));
               
        //0.01 é tolerância de erro;
        assertEquals(100.0,mu.getVida(),0.01);
    }
    
    @Test
    public void saintPodePerderVida() throws Exception{
        Saint mu = new Saint("MU",new Armadura("Aries",Categoria.OURO));        
        mu.perderVida(10.0);
        assertEquals(90.0,mu.getVida(),0.01);        
        mu.perderVida(10.0);
        assertEquals(80.0,mu.getVida(),0.01);
    }  
    
    @Test
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000.0);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint afrodite = new Saint("Afrodite", new Armadura("Peixes", Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new Saint("Bernardo", new Armadura("Café", Categoria.OURO));
    }
    
    
}
