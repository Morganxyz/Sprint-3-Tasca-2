public class AgenteBorsaEuropa extends AgentBorsa {

    private String idioma;

    public AgenteBorsaEuropa(Borsa borsa,String nom){
        super(nom);
        this.borsa = borsa;
        this.borsa.setLlistaAgentBorsa(this);
        this.idioma = "Castellano";
    }

    @Override
    public void actualizar() {
        System.out.println("La cotización actual del producto : " + borsa.getProducte() + " es de "
                + borsa.getPart() + "€ Euros");
    }

    @Override
    public float cambioMoneda() {

        float part= borsa.getPart();
        return part;
    }

    @Override
    public String toString() {
        return "Id del Agente: " + super.getId() + " // Nombre del Agente :" + super.getNom() +
                 " // Idioma: " + this.idioma;
    }
}
