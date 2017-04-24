

public class Golpe
{
   private String nome;
   private int fatorDano;
   
   public Golpe(String nome,int fatorDano){
       this.nome = nome;
       this.fatorDano = fatorDano;
   }
   
   public String getNome(){
       return this.nome;
   }
   
   public Integer getFatorDano(){
       return this.fatorDano;
   }
   
    public void setFatorDano (int fatorDano) {
        this.fatorDano = fatorDano;
    }
   
   public boolean equals(Object object){
     Golpe outroGolpe = (Golpe)object;
     
     
     return 
        this.nome.equals(outroGolpe.getNome()) 
        && this.fatorDano == outroGolpe.getFatorDano();
   }
}
