
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClasseBase {

    private List<Producto> listaProductos;

    private static ClasseBase instance;

    private ClasseBase(){
        this.listaProductos = new LinkedList<>();
    }

    public static ClasseBase getInstance(){
        if(instance == null){
            return new ClasseBase();
        }
        return instance;
    }

    public void menu(){

        Scanner input = new Scanner(System.in);
        int opcio;

        do{
            System.out.println("Introduzca la opción deseada: \n1. Crear Producto\n2. Ver Productos\n0. Salir. ");
            opcio = input.nextInt();

            switch(opcio){

                case 1: crearProducto();
                    break;
                case 2: verProductos();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opción escogida no es válida");
                    System.out.println("");
            }

        }while(opcio != 0);
    }

    public void crearProducto(){

        Scanner input = new Scanner(System.in);

        String nom;
        float preu;

        System.out.println("Introduzca el nombre del producto: ");
        nom = input.nextLine();
        System.out.println("Introduzca el precio del producto: ");
        preu = input.nextFloat();

        Producto p0 = new Producto(nom,preu);
        listaProductos.add(p0);

        System.out.println("Producto registrado en sistema");


    }
    public void verProductos(){

        Scanner input = new Scanner(System.in);

        int opcio;

        do{
            System.out.println("Escoja el tipo de moneda: \n1. USD\n2. Yen\n0. Salir");
            opcio = input.nextInt();

            switch(opcio){

                case 1: verUsd();
                    break;
                case 2: verYen();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opción escogida no es válida");
                    System.out.println("");

            }
        }while(opcio != 0);

    }

    public void verUsd(){

        for(int i = 0; i < listaProductos.size();i++){
            Producto ptrovat = listaProductos.get(i);
            ptrovat.ejecutar(new ConvUsd());
        }
    }

    public void verYen(){

        for(int i = 0; i < listaProductos.size();i++){
            Producto ptrovat = listaProductos.get(i);
            ptrovat.ejecutar(new ConvYen());
        }
    }

}
