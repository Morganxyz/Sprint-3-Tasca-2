public class AgenteBorsaAsia extends AgentBorsa {
    public String idioma;
    public AgenteBorsaAsia(Borsa borsa,String nom){
        super(nom);
        this.borsa = borsa;
        this.borsa.setLlistaAgentBorsa(this);
        this.idioma = "Chinese";
    }


    @Override
    public void actualizar() {
        System.out.println("產品的當前價格 : " + borsa.getProducte() + " 是 "
                + this.cambioMoneda() + " ¥ 元");
    }

    @Override
    public float cambioMoneda() {

        float part= borsa.getPart();
        float partConverted = 0f;
        float convert = 7.76f;

        partConverted = (borsa.getPart()) + (borsa.getPart() * convert);

        return partConverted;
    }

    @Override
    public String toString() {
        return "Id del Agente: " + super.getId() + " // Nombre del Agente :" + super.getNom() +
                " // Idioma: " + this.idioma;
    }
}
