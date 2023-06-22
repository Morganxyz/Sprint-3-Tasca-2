public class PagoTarjeta implements Pago{
    @Override
    public void tipoPago() {
        System.out.println("No hay fondos en la tarjeta, pago cancelado!");
    }
}
