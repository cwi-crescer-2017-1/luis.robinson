

public class Constelacao
{
   private String nome;
   private Golpe[] golpes = new Golpe[3];
   
   public Constelacao(String nome){
       this.nome = nome;
   }
   
   public Golpe[] getGolpes(){
       return this.golpes;
   }
   
   public void adicionarGolpe(Golpe golpe){
       for(int i = 0;i < this.golpes.length;i++){
           Golpe golpeAtual = this.golpes[i];
           // no continuem não segue o if de baixo
           if(i == 0){
               continue;
           }
           if(golpeAtual == null){
             this.golpes[i] = golpe;
             break;
           }
       }
   }
   
   
}
