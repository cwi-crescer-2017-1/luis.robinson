
public class Batalha
{
   final Double dano = 10.0;
   private Saint primeiro;
   private Saint segundo;
   Saint saintEmAcao = null;
    
    public Batalha(Saint primeiro, Saint segundo)
    {
        this.primeiro = primeiro;
        this.segundo = segundo;       
    }
    
   public void iniciar(){
        int valor1 = this.primeiro.getArmadura().getCategoria().getValor();
        int valor2 = this.segundo.getArmadura().getCategoria().getValor();
       if (valor1 >= valor2){
           saintEmAcao = this.primeiro;
           segundo.perderVida(dano);
       } else {
           saintEmAcao = this.segundo;
           primeiro.perderVida(dano);
       }
       
       boolean nenhumMorto = true;
       while(nenhumMorto){
           saintEmAcao = this.saintEmAcao == this.primeiro ?
                            this.segundo : this.primeiro;
                            
           Movimento proximoMovimento = saintEmAcao.getProximoMovimento();
           proximoMovimento.executar();
                            
           nenhumMorto = this.primeiro.getStatus() != Status.MORTO &&
                            this.segundo.getStatus() != Status.MORTO;
        }
    }
   
}
