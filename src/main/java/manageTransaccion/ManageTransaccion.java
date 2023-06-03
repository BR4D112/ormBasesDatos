package manageTransaccion;

import entities.Transacciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Diego Alejandro Rubiano
 */
public class ManageTransaccion {

    public SessionFactory initSesionfactory() {
        Configuration conf = new Configuration();
        return conf.configure("hibernate.cfg.xml").addAnnotatedClass(Transacciones.class).buildSessionFactory();
    }
    private int idTransaccion;

    public ManageTransaccion() {
        this.idTransaccion = 1;
    }

    public void addTransaccion() {
        Transacciones aux = new Transacciones();
        Session session = null;
        Transaction trx = null;
        Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("");
        aux = aux.createTransaccion(idTransaccion++, "", 0, Transacciones.ESTADO_TRANSACCION.COMPRA.value, 0, 0, 0, 0);
        try {
            session = initSesionfactory().openSession();
            trx = session.beginTransaction();
            session.save(aux);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (trx != null && trx.isActive()) {
                trx.rollback();
            }
        }
    }
}
