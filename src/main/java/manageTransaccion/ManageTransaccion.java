package manageTransaccion;

import entities.Transacciones;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Diego Alejandro Rubiano
 */
public class ManageTransaccion {

    public SessionFactory initSesionfactory() {
        Configuration conf = new Configuration();
        return conf.configure("hibernate.cfg.xml").addAnnotatedClass(Transacciones.class).buildSessionFactory();
    }
    addTransaccion
}
