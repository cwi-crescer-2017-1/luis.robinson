
public class Batalha
{
   private Double dano = 10.0;
   private Saint primeiro;
   private Saint segundo;
    
    public Batalha(Saint primeiro, Saint segundo)
    {
        this.primeiro = primeiro;
        this.segundo = segundo;       
    }
    
   public void iniciar(){
       if (primeiro.getCategoriaValorArmadura() >= segundo.getCategoriaValorArmadura()){
           segundo.perderVida(dano);
       } else {
           primeiro.perderVida(dano);
       }
    }
   
}
