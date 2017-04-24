import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class  Saint {    
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected int qtdSentidosDespertados;
    private int acumuladorProximoGolpe = 0;
    private int contGolpes = 0,acumuladorProximoMovimento = 0;
    private ArrayList<Movimento> movimentos = new ArrayList<>();

    protected Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Categoria getCategoria(){
        return armadura.getCategoria();
    }

    // camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return this.status;
    }

    public double getVida() {
        return this.vida;
    }

    public void perderVida(double dano) {

        if (dano < 0) {
            throw new InvalidParameterException("dano");
            //throw new IllegalArgumentException("dano");
        }

        if (vida - dano < 1) {
            this.status = Status.MORTO;
            this.vida = 0;
        } else {
            //this.vida = this.vida - dano;
            this.vida -= dano;
        }
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }
    
    private Constelacao getConstelacao() {
        return this.armadura.getConstelacao();
    }
    
    public ArrayList<Golpe> getGolpes() {
        return getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        ArrayList<Golpe> golpes = getGolpes();
        int posicao = this.acumuladorProximoGolpe % golpes.size();
        this.acumuladorProximoGolpe++;
        return golpes.get(posicao);
    }
    public String getCSV() {
        
        // Interpolação de Strings: return `${nome},${vida},${status}`;
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
        
        /*return  
            this.nome + "," +
            this.vida + "," +
            this.getConstelacao().getNome() + "," +
            this.armadura.getCategoria() + "," +
            this.status + "," +
            this.genero + "," +
            this.armaduraVestida;*/
    }
    
    public void adicionarMovimento(Movimento movimento){
         this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento(){
        int posicao = this.acumuladorProximoMovimento % this.movimentos.size();
        this.acumuladorProximoMovimento++;
        return movimentos.get(posicao);
        
    }
    
    // "agendando" execução do golpe no saint passado por parâmetro
    // o golpe de fato só será executado na batalha.
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }

    
    
    
    

}
