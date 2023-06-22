public class PagoDeudaBancaria implements Pago{


    @Override
    public void tipoPago() {
        System.out.println("Hemos contactado con tu banco y nos dicen que ya tienes demasiadas deudas, pago cancelado!");
    }
}
