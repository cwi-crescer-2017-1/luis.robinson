import java.util.Random;

public class AtaqueDuplo implements Movimento
{
    private Saint golpeador;
    private Saint golpeado;
    
   public AtaqueDuplo(Saint golpeador,Saint golpeado){
       this.golpeador = golpeador;
       this.golpeado = golpeado;
   }
   public void executar(){
       Golpe golpe = this.golpeador.getProximoGolpe();
       int danoCalculado = golpe.getFatorDano();         
        
       if (this.golpeador.getArmaduraVestida()) {
           danoCalculado *= 1 + this.golpeador.getArmadura().getCategoria().getValor();
       }
       
       if (Sortear() %3 == 0){
           this.golpeado.perderVida(danoCalculado*2);
       }else{
           this.golpeado.perderVida(danoCalculado);
           double vida = golpeador.getVida();
           vida = (vida*5)/100;
           this.golpeador.perderVida(vida);
       }
        
        
   }
   
   public int Sortear(){
       final Random random = new Random();
        final int min = 1, max = 3;
        return random.nextInt(max-min+1)+min;
    }
}


