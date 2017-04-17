public class  Saint {
    private String nome = "";
    private Armadura armadura;
    private boolean armaduraVestida;   
    private double vida = 100.0;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private int qtdSentidosDespertados = 4;
    
    //construtor
    public Saint(String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
        
          if (this.armadura.getCategoria() == Categoria.PRATA) {
            this.qtdSentidosDespertados = 6;
        } else if (this.armadura.getCategoria() == Categoria.OURO) {
            this.qtdSentidosDespertados = 7;
            String constelacao = armadura.getConstelacao();
            if ( !constelacao.equals("Áries") && !constelacao.equals("Touro") && !constelacao.equals("Escorpião") 
            && !constelacao.equals("Virgem")
            && !constelacao.equals("Peixes")
            && !constelacao.equals("Câncer")
            ) {
                // dar erro
                throw new Exception("Constelação inválida");
            }
        } else {
            // bronze
            this.qtdSentidosDespertados = 5;
        }
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }     
    
    public Genero getGenero(){
        return this.genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
        
    public Status getStatus(){        
        return this.status;
    }
    
    public Double getVida(){
        return this.vida;
    }
    
    public void perderVida(Double dano){
        this.vida -= dano;  
    }
    
    public Integer getCategoriaValorArmadura(){
        return this.armadura.getValorArmadura();
    }
    
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
}