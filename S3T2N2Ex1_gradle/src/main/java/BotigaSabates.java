public class BotigaSabates {

    private String nom;
    private float preu;

    public BotigaSabates(String nom,float preu){
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return this.preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public void sell(Pago pago){
            pago.tipoPago();
    }
    @Override
    public String toString() {
        return "Nombre del producto: " + this.nom + "::" + " Precio: " + this.preu + "€";
    }
}
