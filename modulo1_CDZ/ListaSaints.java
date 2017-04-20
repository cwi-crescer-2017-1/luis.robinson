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
    
    public void ordenar(TipoOrdenacao tipoOrdenacao) {
        /*
         * BubbleSort
         * Complexidade: O(n^2)
         * 
         * 
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = 
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();

                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }

    public void ordenar() {
        this.ordenar(TipoOrdenacao.ASCENDENTE);
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
    
   public String getCSV() {
        if (this.saints.isEmpty()) {
            return "";
        }

        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);

        builder.append(this.saints.get(0).getCSV());
        for (int i = 1; i < this.saints.size(); i++) {
            Saint saint = this.saints.get(i);
            //resultado += separador + saint.getCSV();
            //builder.append(String.format("%s%s", separador, saint.getCSV()));
            builder.append(separador);
            builder.append(saint.getCSV());
        }

        return builder.toString();
    }
    
    
   
   
}
