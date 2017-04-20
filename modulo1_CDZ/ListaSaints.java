import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaSaints
{

  private ArrayList<Saint> saints = new ArrayList<>(); 
  
  //Construtor
  public ListaSaints() {
        this.saints = new ArrayList<>();
    }
  
  public void adicionar(Saint saint){
      this.saints.add(saint);
   };
   
   public Saint getSaintIndice(int indice){
       return this.saints.get(indice);
   }
   
   public ArrayList<Saint> getSaints(){
      return this.saints;
   };
   
   public void removerSaint(Saint saint){
       this.saints.remove(saint);
   }
   
   public Saint buscarPorNome(String nome){
       /* for (Saint saint : saints){
           if( saint.getNome().equals(nome)){
               return saint;
            }
        }
        // se percorre o for each e não tem saints
        return null; */
        
        //java 8, lambda
        return this.saints.stream()
            .filter(s -> s.getNome().equals(nome))
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        //ArrayList<Saint> lista = new ArrayList<>();
        /*for (Saint saint : saints){
           if( saint.getCategoria().equals(categoria)){
               lista.add(saint);
            }
        }
        return lista; */
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getArmadura().getCategoria().equals(categoria))
            .collect(Collectors.toList());
        
        
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        /*ArrayList<Saint> lista = new ArrayList<>();
        for (Saint saint : this.saints){
           if( saint.getStatus().equals(status)){
               lista.add(saint);
            }
        }
        return lista;*/
         return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
        
    }
    
    public Saint getSaintMaiorVida(){
        if (saints.isEmpty()){
            //Athena está sem saints =/
            return null;
        }
        
        // incializar saints
        Saint saintMaiorVida  = saints.get(0);
        
        for (Saint saint : saints) {
            if (saint.getVida() > saintMaiorVida .getVida()) {
                saintMaiorVida  = saint;
            }
        }
        
        return saintMaiorVida ;
    }
    
    public Saint getSaintMenorVida(){
        if (saints.isEmpty()){
            //Athena está sem saints =/
            return null;
        }
        
        // incializar saints
        Saint saintMenorVida  = saints.get(0);
        
        for (Saint saint : saints) {
            if (saint.getVida() < saintMenorVida .getVida()) {
                saintMenorVida  = saint;
            }
        }
        
        return saintMenorVida ;
    }
    
    public void ordenar() {
        // Selection Sort 
        int menor;
        Saint aux;
        for (int i = 0; i < saints.size(); i++) {
            menor = i;
            aux = saints.get(i);
            while ((menor > 0) && (saints.get(menor - 1).getVida() > aux.getVida())) {
                saints.set(menor, saints.get(menor - 1));
                menor--;
            }
            saints.set(menor, aux);
        }
    }
    
    public void ordenar(TipoOrdenacao ordenacao){
        if (ordenacao.equals(TipoOrdenacao.ASCENDENTE)){
            ordenar();
        } else {
            int maior;
            Saint aux;
            for (int i = 0; i < saints.size(); i++) {
                maior = i;
                aux = saints.get(i);
                while ((maior > 0) && (saints.get(maior - 1).getVida() < aux.getVida())) {
                    saints.set(maior, saints.get(maior - 1));
                    maior--;
                }
                saints.set(maior, aux);
            }
        }
    }   
    
    
    public ListaSaints unir(ListaSaints  listaSaintsUnir){       
        // criar nova lista para retornar
        ListaSaints novaListaSaintsUnir = new ListaSaints();
        for (Saint saint: saints){                            
            novaListaSaintsUnir.adicionar(saint);                           
        }
        
        for (Saint saint: listaSaintsUnir.getSaints()){                            
            novaListaSaintsUnir.adicionar(saint);                           
        }
        
        return novaListaSaintsUnir;
    }
    public ListaSaints diff(ListaSaints  listaSaintsDiff){       
        // criar nova lista para retornar
        ListaSaints novaListaSaintsDiff = new ListaSaints();
        for (Saint saint: saints){            
                if (!listaSaintsDiff.getSaints().contains(saints)){
                    novaListaSaintsDiff.adicionar(saint);
                }            
        }
        return novaListaSaintsDiff;
    }
    
    public ListaSaints intersec(ListaSaints  listaSaintsIntersec){       
        // criar nova lista para retornar
        ListaSaints novaListaSaintIntersec = new ListaSaints();
        for (Saint saint: saints){            
                if (listaSaintsIntersec.getSaints().contains(saints)){
                    novaListaSaintIntersec.adicionar(saint);
                }            
        }
        return novaListaSaintIntersec;
    }
    
    public String getCSV(){       
        // criar nova lista para retornar
        //istaSaints listaCSV = new ListaSaints();
        StringBuilder csv  = new StringBuilder();
        for (Saint saint: saints){            
                csv.append(saint.getNome());
                csv.append(",");
                csv.append(saint.getVida());
                csv.append(",");
                csv.append(saint.getArmadura().getConstelacao().getNome());
                csv.append(",");
                csv.append(saint.getArmadura().getCategoria());
                csv.append(",");
                csv.append(saint.getStatus());
                csv.append(",");
                csv.append(saint.getGenero());
                csv.append(",");
                csv.append(saint.getArmaduraVestida());
                csv.append("/n ");
        }
        return csv.toString();
    }
    
    
   
   
}
