
import manageTransaccion.ManageTransaccion;

/**
 * @author Diego Alejandro Rubiano
 */
public class TestingaddTransacc {
    public static void main(String[] args) {
        ManageTransaccion man = new ManageTransaccion();
        System.out.println(man.getPersona(true, 112, man.initSesionfactory().openSession()).toString());
    }
}
