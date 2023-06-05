package manageTransaccion;

import entities.*;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
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

    public static SessionFactory getSessionTransaccion() {
        return new ManageTransaccion().initSesionfactory();
    }

    public void addTransaccion(int idTransaccion, String fecha, float totalTransaccion, String estadoTransac,
            boolean agregaPersAdq, int idPersonaAdq, boolean agregaPersonaVen, int idPersonVend, float costoTrans, float cantidProduct) {
        Transacciones aux = new Transacciones();
        Session session = null;
        Transaction trx = null;
        aux = aux.createTransaccion(idTransaccion++, "10-10-2023", 432,
                Transacciones.ESTADO_TRANSACCION.COMPRA.value,
                null, null, 0, 0);

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

    public void deleteTransaccion(int id, Session sesion) {
        try {
            Transaction trx = sesion.beginTransaction();
            String hql = "DELETE FROM TRANSACCIONES WHERE ID_TRANSACCION = :transaccionId";
            Query query = sesion.createQuery(hql);
            query.setParameter("transaccionId", id);
            query.executeUpdate();
            trx.commit();
            int filasEliminadas = query.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List<Transacciones> getTransacc(SessionFactory sessionfac) {
        Session auxSession = sessionfac.openSession();
        String jpql = "from TRANSACCIONES";
        return auxSession.createQuery(jpql).list();
    }

    public void addTransaccion(Transacciones trans) {
        Transacciones aux = trans;
        Session session = null;
        Transaction trx = null;
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

    public void updateTransaccion(float costoTransp, float cantidadUnidProd, int idTransaccion, Session session) {
        try {
            Transaction trx = session.beginTransaction();
            String hql = "UPDATE TRANSACCIONES SET  COSTO_TRANSPORTE = :costoTransp , CANTIDAD_UNID_PROD = :cantidadUnid WHERE ID_TRANSACCION = :transaccionId";
            Query query = session.createQuery(hql);
            System.out.println(session.isConnected());
            System.out.println(session.isOpen());
            query.setFloat("costoTransp", costoTransp);
            query.setParameter("cantidadUnid", cantidadUnidProd);
            query.setInteger("transaccionId", idTransaccion);
            int value = query.executeUpdate();
            trx.commit();
            JOptionPane.showMessageDialog(null, costoTransp + "\n" + cantidadUnidProd + "\n" + idTransaccion + "\n" + value);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public boolean isNotTransaccionInDB(int id) {
        Session auxSession = ManageTransaccion.getSessionTransaccion().openSession();
        String jpql = "from TRANSACCIONES where  ID_TRANSACCION = " + id;
        return auxSession.createQuery(jpql).list().isEmpty();
    }

    public Personas getPersona(boolean esComprador, int idPersona, Session sesion) {
        String jpql = "from PERSONAS where ID_PERSONA = " + idPersona;
        System.out.println(sesion.isOpen());
        System.out.println(sesion.isConnected());
        List<Personas> persona
                = sesion.createQuery(jpql).list();
        sesion.close();
        if (persona.isEmpty()) {
            System.out.println("esta vacio");
            return null;
        }
        System.out.println("hay uno");
        return persona.get(0);
    }

    public Transacciones getTransaccion(int id) {
        Session auxSession = this.initSesionfactory().openSession();
        Transaction trx = auxSession.beginTransaction();
        return (Transacciones) auxSession.get(Transacciones.class, id);
    }
}
