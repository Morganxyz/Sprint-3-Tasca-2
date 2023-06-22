import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasseBase {

    private static ClasseBase instance;

    private List<BotigaSabates> llistaProductes;

    private List<BotigaSabates>llistaProductesFactura;

    private ClasseBase (){

        this.llistaProductes = new ArrayList<>();
        this.llistaProductesFactura = new ArrayList();
    }

    public static ClasseBase getInstance(){
        if(instance ==  null){
            instance = new ClasseBase();
        }
        return instance;
    }

    public List<BotigaSabates> getLlistaProductes() {
        return this.llistaProductes;
    }

    public void setLlistaProductes(BotigaSabates llistaProductes) {
        this.llistaProductes.add(llistaProductes);
    }

    public List<BotigaSabates> getLlistaProductesFactura() {
        return this.llistaProductesFactura;
    }

    public void setLlistaProductesFactura(BotigaSabates llistaProductesFactura) {
        this.llistaProductesFactura.add(llistaProductesFactura);
    }

    public void menu(){

        Scanner input = new Scanner(System.in);

        int opcion;


        do{
            System.out.println("Introduce la opción deseada: \n1. Crear Producto\n2. Ver Productos\n3. Añadir a Cesta" +
                    "\n4. Ver Cesta\n5. Validar compra\n0. Salir");
            opcion = input.nextInt();

            switch(opcion){
                case 1:  crearProductos();
                    break;
                case 2:  verTodosProductos();
                    break;
                case 3:  anadirProductosCesta();
                    break;
                case 4:  verProductosCesta();
                    break;
                case 5:  metodosPago();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    System.out.println("");
                    break;
                default:
                    System.out.println("La opción escogida no es válida");
                    System.out.println("");
            }


        }while(opcion != 0);

    }

    public int localizarProducto(){

        Scanner input = new Scanner(System.in);

        int i = 0;
        int posProd = -1;
        String nom;
        boolean esc = false;

        verTodosProductos();

        System.out.println("Introduce el nombre del zapato para añadir: ");
        nom = input.nextLine();

        while(i < llistaProductes.size() && !esc){
            BotigaSabates prodTrovat = getLlistaProductes().get(i);

            if(nom.equalsIgnoreCase(prodTrovat.getNom())){
                System.out.println("Producte Trovat!");
                System.out.println("");
                esc = true;
                posProd = i;

            }
            i++;
        }
        return posProd;
    }

    public void anadirProductosCesta(){

        int posProd = localizarProducto();

        if(posProd != -1){
            setLlistaProductesFactura(getLlistaProductes().get(posProd));
        }else{
            System.out.println("Producte NO Trovat!");
            System.out.println("");
        }
    }

    public void verTodosProductos(){

        llistaProductes.forEach(x -> System.out.println(x.toString()));
    }

    public void verProductosCesta(){
        llistaProductesFactura.forEach(x -> System.out.println(x.toString()));
    }

    public void crearProductos(){

        Scanner input = new Scanner(System.in);

        String nom;
        float preu;

        System.out.println("Introduce el nombre del producto para la tienda: ");
        nom = input.nextLine();
        System.out.println("Introduce el precio de venta");
        preu = input.nextFloat();

        BotigaSabates bs0 = new BotigaSabates(nom,preu);
        setLlistaProductes(bs0);

    }

    public void metodosPago(){

        Scanner input = new Scanner(System.in);

        int opcio;

        System.out.println("Introduce el método de pago:  \n1. Pay Pal\n2. Targeta Crèdit\n3. Deute Bancari\n0. Salir");
        opcio = input.nextInt();

        switch(opcio){

            case 1: metodoPayPal(calcularCesta(llistaProductesFactura));
                break;
            case 2: metodoTargCred(calcularCesta(llistaProductesFactura));
                break;
            case 3: metodoDeutBanc(calcularCesta(llistaProductesFactura));
                break;
            case 0:
                System.out.println("Saliendo");
                System.out.println("");
                break;
            default:
                System.out.println("Opción escogida no válida");
                System.out.println("");

        }
    }

    public void metodoPayPal(float factura){

        System.out.println("El total de la factura es de " + factura + "€");

        Pago db = new PagoDeudaBancaria();
        for(int i = 0; i < llistaProductesFactura.size();i++){
            getLlistaProductesFactura().get(i).sell(db);
        }
    }
    public void metodoTargCred(float factura){

        System.out.println("El total de la factura es de " + factura + "€");

        Pago db = new PagoTarjeta();
        for(int i = 0; i < llistaProductesFactura.size();i++){
            getLlistaProductesFactura().get(i).sell(db);
        }

    }
    public void metodoDeutBanc(float factura){

        System.out.println("El total de la factura es de " + factura + "€");
        Pago db = new PagoPayPal();

        for(int i = 0; i < llistaProductesFactura.size();i++){
            getLlistaProductesFactura().get(i).sell(db);
        }
    }

    public float calcularCesta(List<BotigaSabates> llistaProductesFactura) {

        float facturaFinal = 0f;

        for (int i = 0; i < llistaProductesFactura.size(); i++) {
            float factura = getLlistaProductesFactura().get(i).getPreu();
            facturaFinal += factura;
            }
        return facturaFinal;
        }
    }

