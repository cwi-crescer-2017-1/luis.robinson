
public class Batalha
{
    Double dano = 10.0;
    Saint first;
    Saint second;
    
    public Batalha(Saint first, Saint second,Double dano)
    {
        this.first = first;
        this.second = second;
        this.dano = dano;       
    }
    
   public void iniciar(){
       if (first.getValorArmadura() >= second.getValorArmadura()){
           second.perderVida(dano);
       } else {
           first.perderVida(dano);
       }
    }
   
}
