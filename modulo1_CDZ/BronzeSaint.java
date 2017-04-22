

public class BronzeSaint extends Saint
{
    
    //filho tem que ter os mesmos contrutores do pai
    public BronzeSaint(String nome, String nomeConstelacao)throws Exception{        
        super(nome, new Armadura(new Constelacao(nomeConstelacao), Categoria.BRONZE));
        this.qtdSentidosDespertados = 5;
       
    }
   
   
}
