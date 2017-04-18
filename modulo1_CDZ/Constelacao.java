
import java.util.ArrayList;

public class Constelacao
{
   private String nome;
   //private Golpe[] golpes = new Golpe[3];
   private ArrayList<Golpe> golpes = new ArrayList<>();
   private int ultimaPosicaoPreenchida = 0;

    public Constelacao(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public ArrayList<Golpe> getGolpes() {
        return this.golpes;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes.add(golpe);        
    }
   
   
}
