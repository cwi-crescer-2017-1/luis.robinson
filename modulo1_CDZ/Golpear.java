
public class Golpear implements Movimento
{
    Golpe golpe;
    Saint golpeador ;
    Saint golpeado;
    int valorArmadura;
    int valorFatorDano;
    //construtor
    public Golpear(Saint golpeador ,Saint golpeado) throws Exception{
        this.golpeador  = golpeador ;
        this.golpeado  = golpeado ;
        // pego próximo golpe
        this.golpe = golpeador.getProximoGolpe();
    }
    
    public void executar() {
        if (golpeador .getArmaduraVestida()){
            valorArmadura = golpeador .getArmadura().getCategoria().getValor();
            //pego o valor da armadura e multiplico pelo dano.
            valorFatorDano = golpe.getFatorDano()*(valorArmadura +1);
            golpe.setFatorDano(valorFatorDano);
        } 
        
        golpeado.perderVida(golpe.getFatorDano());


    }

}
