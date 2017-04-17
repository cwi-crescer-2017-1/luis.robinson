
public class Batalha
{
    Double dano = 10.0;
    Saint primeiro;
    Saint segundo;
    
    public Batalha(Saint primeiro, Saint segundo)
    {
        this.primeiro = primeiro;
        this.segundo = segundo;       
    }
    
   public void iniciar(){
       if (primeiro.getValorArmadura() >= segundo.getValorArmadura()){
           segundo.perderVida(dano);
       } else {
           primeiro.perderVida(dano);
       }
    }
   
}
