public class ConvUsd implements ConvertidorMoneda{
    @Override
    public void convMon(Producto producto) {

        System.out.println("El producto " + producto.getNom() + " tiene un precio de:  " + (producto.getPreu() * 1.09) + "$USD.");
        System.out.println("");
    }
}
