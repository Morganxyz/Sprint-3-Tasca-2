public abstract class AgentBorsa {

    private String nom;;
    public static int idSiguiente = 1;
    private int id;

    protected Borsa borsa;

    public AgentBorsa(String nom){
        this.nom = nom;
        this.id = idSiguiente;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return this.id;
    }

    public abstract void actualizar();
    public abstract float cambioMoneda();
}
