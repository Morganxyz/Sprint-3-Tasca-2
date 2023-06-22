import java.util.LinkedList;
import java.util.List;

public class Borsa {

    private List<AgentBorsa> llistaAgentBorsa;
    private String producte;
    private float part;

    public Borsa(String producte,float part){
        this.producte = producte;
        this.part = part;
        this.llistaAgentBorsa = new LinkedList<>();
    }

    public String getProducte() {
        return this.producte;
    }

    public void setProducte(String producte) {
        this.producte = producte;
    }

    public float getPart() {
        return this.part;
    }

    public List<AgentBorsa> getLlistaAgentBorsa() {
        return this.llistaAgentBorsa;
    }

    public void setLlistaAgentBorsa(AgentBorsa llistaAgentBorsa) {
        this.llistaAgentBorsa.add(llistaAgentBorsa);
    }

    public void setPart(float part) {
        this.part = part;
        comunicadoAgentes();
    }

    public void comunicadoAgentes(){

        llistaAgentBorsa.forEach(x -> x.actualizar());
        }

    @Override
    public String toString() {
        return "Producte: " + this.producte + " // Cotización: " + this.part + "€.";
    }
}

