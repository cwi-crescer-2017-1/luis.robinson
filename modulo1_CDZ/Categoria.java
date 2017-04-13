

public enum Categoria
{
    BRONZE(1), PRATA(2), OURO(3);
    
    private int valor;
    
    private Categoria(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
}
