

import entities.Producto;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Diego A
 */
public class ORM_bases_datos_transacciones {

    public void listCargos(SessionFactory factory) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println(session.isOpen());
            System.out.println(session.isConnected());
            List cargos = session.createQuery("from PRODUCTOS").list();
            for (Iterator iterator = cargos.iterator(); iterator.hasNext();) {
                Producto prodGet = (Producto) iterator.next();
                System.out.println("Nombre cargo: " + prodGet.getNombre_producto());
                System.out.println("Id cargo: " + prodGet.getId_producto());
            }
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public static void main(String[] args) {
        SessionFactory sesionFactoryMain = null;
        Session factory_sesion = null;
        Transaction transaccion = null;
        try {
            Configuration cofg = new Configuration();
            sesionFactoryMain = cofg.configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Producto.class)
                    .buildSessionFactory();
            factory_sesion = sesionFactoryMain.openSession();
            transaccion = factory_sesion.beginTransaction();
            Producto prod = new Producto();

            //save
            prod.setId_producto(8);
            prod.setNombre_producto("DIEGO");
            prod.setPrecio_producto(12f);
            prod.setDescripcion_producto("esta es una desc");

            factory_sesion.save(prod);
            
            transaccion.commit();
            System.out.println("producto agregado");
            new ORM_bases_datos_transacciones().listCargos(sesionFactoryMain);

        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.println("Error en un check de la base de datos");
        } finally {
            if (sesionFactoryMain != null) {
                sesionFactoryMain.close();
            }
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
}
