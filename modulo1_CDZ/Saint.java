public class  Saint {
    private String nome = "";
    private Armadura armadura;
    private boolean armaduraVestida;   
    private double vida = 100.0;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    // quem herda tem acesso ao protected
    protected int qtdSentidosDespertados;
    
    //construtor
    public Saint(String nome, Armadura armadura) throws Exception{
        this.nome = nome;
        this.armadura = armadura;
        
           
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