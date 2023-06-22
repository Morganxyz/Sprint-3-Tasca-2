public class AgenteBorsaAmerica extends AgentBorsa {

    public String idioma;
    public AgenteBorsaAmerica(Borsa borsa,String nom){
        super(nom);
        this.borsa = borsa;
        this.borsa.setLlistaAgentBorsa(this);
        this.idioma = "English";
    }
    @Override
    public void actualizar() {
        System.out.println("The current price of : " + borsa.getProducte() + " is "
                + this.cambioMoneda() + "$ USD");
    }

    @Override
    public float cambioMoneda() {

        float part= borsa.getPart();
        float partConverted = 0f;
        float convert = 1.09f;

        partConverted = (borsa.getPart()) + (borsa.getPart() * convert);

        return partConverted;
    }

    @Override
    public String toString() {
        return "Id del Agente: " + super.getId() + " // Nombre del Agente :" + super.getNom() + " // Idioma: " + this.idioma;
    }
}
