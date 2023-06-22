import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasseBase {

    private static ClasseBase instancia;

    private List<Borsa> llistaProductes;
    private  ClasseBase(){

        this.llistaProductes = new ArrayList<>();
    }
    public static ClasseBase getInstance(){
        if(instancia == null){
            instancia = new ClasseBase();
        }
        return instancia;
    }


    public List<Borsa> getLlistaProductes() {
        return this.llistaProductes;
    }

    public void setLlistaProductes(Borsa llistaProductes) {
        this.llistaProductes.add(llistaProductes);
    }

    public void menu(){

        Scanner input = new Scanner(System.in);
        int opcio;

        System.out.println();

        do{
            System.out.println("Introduzca la opción que desea: \n1. Crear Producto\n2. Crear Agente Americano\n3. Crear Agente" +
                    " Asiático\n4. Crear Agente Europeo\n5. Modificar Cotización\n0. Salir");
            opcio = input.nextInt();


            switch(opcio){

                case 1: crearProductoBolsa();
                    break;
                case 2: crearAgenteAm();
                    break;
                case 3: crearAgenteAs();
                    break;
                case 4: crearAgenteEu();
                    break;
                case 5: modificarCotizacionProducto(localizarProducto());
                    break;
                case 0:
                    System.out.println("Saliendo");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");


            }
        }while(opcio != 0);

    }

    public void crearProductoBolsa(){

        Scanner input = new Scanner(System.in);

        String nom;
        float part;

        System.out.println("Introduzca el nombre del producto: ");
        nom = input.nextLine();
        System.out.println("Introduzca la cotización actual: ");
        part = input.nextFloat();

        Borsa b0 = new Borsa(nom,part);
        llistaProductes.add(b0);

    }

    public void crearAgenteAm(){

        Scanner input = new Scanner(System.in);

        String resp;
        String nom;

        System.out.println("Introduzca el nombre del Agente de Bolsa: ");
        nom = input.nextLine();

        verProductos();

        System.out.println("Quiere suscribirte a algún producto?  S/N: ");
        resp = input.next();

        if(resp.equalsIgnoreCase("s")){



            Borsa b0 = getLlistaProductes().get(localizarProducto());
            AgentBorsa am = new AgenteBorsaAmerica(b0,nom);
            b0.setLlistaAgentBorsa(am);

        }else{
            System.out.println("Suscripción abortada");
        }
    }
    public void crearAgenteAs(){

        Scanner input = new Scanner(System.in);

        String resp;
        String nom;

        System.out.println("Introduzca el nombre del Agente de Bolsa: ");
        nom = input.nextLine();

        verProductos();

        System.out.println("Quiere suscribirte a algún producto?  S/N: ");
        resp = input.next();

        if(resp.equalsIgnoreCase("s")){

            Borsa b0 = getLlistaProductes().get(localizarProducto());
            AgentBorsa as = new AgenteBorsaAsia(b0,nom);
            b0.setLlistaAgentBorsa(as);
        }else{
            System.out.println("Suscripción abortada");
        }

    }
    public void crearAgenteEu(){

        Scanner input = new Scanner(System.in);

        String resp;
        String nom;

        System.out.println("Introduzca el nombre del Agente de Bolsa: ");
        nom = input.nextLine();

        verProductos();

        System.out.println("Quiere suscribirte a algún producto?  S/N: ");
        resp = input.next();

        if(resp.equalsIgnoreCase("s")){

            int posProd = localizarProducto();
            Borsa b0 = getLlistaProductes().get(posProd);
            AgentBorsa am = new AgenteBorsaEuropa(b0,nom);
            b0.setLlistaAgentBorsa(am);

        }else{
            System.out.println("Suscripción abortada");
        }

    }

    public void modificarCotizacionProducto(int posProd){

        Scanner input = new Scanner(System.in);
        float newPart;

        if(posProd != -1){
            System.out.println("Introduce el nuevo valor de cotización del producto");
            newPart = input.nextFloat();
            llistaProductes.get(posProd).setPart(newPart);
        }else{
            System.out.println("Producte NO trovat!");
        }

    }

    public int localizarProducto(){

        Scanner input = new Scanner(System.in);

        int posProd = -1;
        int i = 0;
        String nom;
        boolean esc = false;

        System.out.println("Introduce el nombre del producto: ");
        nom = input.nextLine();

        while(i < llistaProductes.size() && !esc) {
            Borsa prodTrovat = llistaProductes.get(i);

            if (nom.equalsIgnoreCase(prodTrovat.getProducte())) {
                System.out.println(prodTrovat.toString());
                System.out.println("Producte trovat!");
                System.out.println("");
                posProd = i;
                esc = true;
            }
            i++;
        }
          return posProd;
    }

    public void verProductos(){

        for(int i = 0; i < llistaProductes.size();i++){
            System.out.println(getLlistaProductes().get(i).toString());
        }
    }

}
