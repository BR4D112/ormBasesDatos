
import manageTransaccion.ManageTransaccion;

/**
 * @author Diego Alejandro Rubiano
 */
public class TestingUpdate {
    public static void main(String[] args) {
        ManageTransaccion man = new ManageTransaccion();
        man.updateTransaccion(23, 2342, 1, man.initSesionfactory().openSession());
    }
}
