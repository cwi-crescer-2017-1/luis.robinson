public class Armadura{
    private String constelacao;
    private Categoria categoria;   
    
    public Armadura(String constelacao,Categoria categoria){
        this.constelacao = constelacao;
        this.categoria = categoria;
    }
    
    public Integer getValorArmadura(){
        return this.categoria.getValor();
    }
}