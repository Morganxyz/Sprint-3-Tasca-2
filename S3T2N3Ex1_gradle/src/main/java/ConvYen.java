public class ConvYen implements ConvertidorMoneda{
    @Override
    public void convMon(Producto producto) {

        System.out.println("El producto " + producto.getNom() + " tiene un precio de:  " + (producto.getPreu() * 5.89) + "Yen.");
        System.out.println("");

    }
}
