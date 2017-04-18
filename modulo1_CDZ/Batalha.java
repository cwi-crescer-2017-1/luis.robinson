
public class Batalha
{
   final Double dano = 10.0;
   private Saint primeiro;
   private Saint segundo;
    
    public Batalha(Saint primeiro, Saint segundo)
    {
        this.primeiro = primeiro;
        this.segundo = segundo;       
    }
    
   public void iniciar(){
        int valor1 = this.primeiro.getArmadura().getCategoria().getValor();
        int valor2 = this.segundo.getArmadura().getCategoria().getValor();
       if (valor1 >= valor2){
           segundo.perderVida(dano);
       } else {
           primeiro.perderVida(dano);
       }
    }
   
}
