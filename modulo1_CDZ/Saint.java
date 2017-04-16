public class  Saint {
    private String nome = "";
    private Armadura armadura;
    private boolean armaduraVestida;
    private double vida = 100.0;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    
    //construtor
    public Saint(String nome, Armadura armadura){
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
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public Double getVida(){
        return this.vida;
    }
    
    public void perderVida(Double vida){
        this.vida -= vida;  
    }
    
    public Integer getValorArmadura(){
        return this.armadura.getValorArmadura();
    }
    
}