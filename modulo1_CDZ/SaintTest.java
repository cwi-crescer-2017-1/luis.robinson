

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
        GoldSaint milo = new GoldSaint("Milo",escorpiao);
        //2.Act - invocar a ação a ser testada
        milo.vestirArmadura();
        //3.Assert - verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true,resultado);
        
    }    
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception{
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura("Pégaso",Categoria.BRONZE));
        assertEquals(false,seiya.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroNaoInformado() throws Exception{
        GoldSaint mu = new GoldSaint("MU",new Armadura("Áries",Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,mu.getGenero());
    }
    
    @Test
    public void saintPodeMudarGenero()throws Exception{
        GoldSaint mu = new GoldSaint("MU",new Armadura("Áries",Categoria.OURO));
        mu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO,mu.getGenero());
    } 
    
    @Test
    public void aoCriarSaintNasceVivo()throws Exception{
        GoldSaint mu = new GoldSaint("MU",new Armadura("Áries",Categoria.OURO));
        assertEquals(Status.VIVO,mu.getStatus());
    }
    
    @Test
    public void aoCriarSaintNasceComVida()throws Exception{
        GoldSaint mu = new GoldSaint("MU",new Armadura("Áries",Categoria.OURO));
               
        //0.01 é tolerância de erro;
        assertEquals(100.0,mu.getVida(),0.01);
    }
    
    @Test
    public void saintPodePerderVida() throws Exception{
        GoldSaint mu = new GoldSaint("MU",new Armadura("Áries",Categoria.OURO));        
        mu.perderVida(10.0);
        assertEquals(90.0,mu.getVida(),0.01);        
        mu.perderVida(10.0);
        assertEquals(80.0,mu.getVida(),0.01);
    }  
    
    @Test
    public void perderDanoComValorMenos1000() throws Exception {
        // Arrange
        BronzeSaint shiryu = new BronzeSaint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000.0);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        BronzeSaint seiya = new BronzeSaint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        SilverSaint marin = new SilverSaint("Marin", new Armadura("Águia", Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        GoldSaint afrodite = new GoldSaint("Afrodite", new Armadura("Peixes", Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura("Café", Categoria.OURO));
    }
    
    
}
