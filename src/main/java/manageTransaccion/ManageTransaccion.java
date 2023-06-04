package manageTransaccion;

import entities.*;
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
        return conf.configure("hibernate.cfg.xml")
                .addAnnotatedClass(Lugar.class)
                .addAnnotatedClass(Transacciones.class)
                .addAnnotatedClass(Personas.class).buildSessionFactory();
    }
    private int idTransaccion;

    public ManageTransaccion() {
        this.idTransaccion = 2;
    }

    public void addTransaccion() {
        Transacciones aux = new Transacciones();
        Session session = null;
        Transaction trx = null;
        Transacciones.ESTADO_TRANSACCION.COMPRA.isInEstadoTrans("");
        aux = aux.createTransaccion
        (idTransaccion++, "10-10-2023", 432,
                Transacciones.ESTADO_TRANSACCION.COMPRA.value,
                null, null, 0, 0);
        System.out.println(aux.getFechaTransaccion());
        try {
            session = initSesionfactory().openSession();
            trx = session.beginTransaction();
            session.save(aux);
            trx.commit();
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
