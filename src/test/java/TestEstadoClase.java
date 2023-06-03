
import entities.Transacciones;

/**
 * @author Diego Alejandro Rubiano
 */
public class TestEstadoClase {
    public static void main(String[] args) {
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("com")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("COM")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("VEN")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("asd")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("dfsfsd")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("asdad")?"esta":"noesta");
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("asd")?"esta":"noesta");
        
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.getEstadoTransWithString("COM"));
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.getEstadoTransWithString("VEN"));
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.getEstadoTransWithString("2asdas"));
        System.out.println(Transacciones.ESTADO_TRANSACCION.COMPRA.getEstadoTransWithString("Vasd"));
        
    }
}
