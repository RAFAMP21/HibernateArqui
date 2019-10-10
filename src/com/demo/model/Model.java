package com.demo.model;

import com.demo.model.persistencia.Proveedor;
import com.demo.model.persistencia.Zona;
import com.demo.model.persistencia.Presentacion;
import com.demo.model.persistencia.Producto;
import com.demo.model.persistencia.Marca;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Model {

    static public boolean registrar(Marca marca) {
        boolean band = false;
        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(marca);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean registrar(Proveedor proveedor) {
        boolean band = false;
        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(proveedor);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean registrar(Presentacion presentacion) {
        boolean band = false;
        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(presentacion);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean registrar(Zona zona) {
        boolean band = false;
        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(zona);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean registrar(Producto producto) {
        boolean band = false;
        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(producto);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public List<Marca> listarMarca() {
        Session session = null;
        List<Marca> lista = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String consulta = "from Marca";
            lista = session.createQuery(consulta).list();

            tx.commit();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return lista;
    }

    static public List<Proveedor> listarProveedor() {
        Session session = null;
        List<Proveedor> lista = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String consulta = "from Proveedor";
            lista = session.createQuery(consulta).list();

            tx.commit();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return lista;
    }

    static public List<Presentacion> listarPresentacion() {
        Session session = null;
        List<Presentacion> lista = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String consulta = "from Presentacion";
            lista = session.createQuery(consulta).list();

            tx.commit();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return lista;
    }

    static public List<Zona> listarZona() {
        Session session = null;
        List<Zona> lista = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String consulta = "from Zona";
            lista = session.createQuery(consulta).list();

            tx.commit();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return lista;
    }

    static public List<Producto> listarProducto() {
        Session session = null;
        List<Producto> lista = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            String consulta = "from Producto";
            org.hibernate.Query query = session.createQuery(consulta);
            lista = query.list();
            lista.get(0).getMarca().getDescripcion();
            lista.get(0).getPresentacion().getDescripcion();
            lista.get(0).getProveedor().getDescripcion();
            lista.get(0).getZona().getDescripcion();
            tx.commit();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            
            session.close();
        }

        return lista;
    }

    static public Marca buscarMarca(int ID) {
        Session session = null;
        Marca marca = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Marca marca where marca.idMarca = :idmarca");
            query.setParameter("idmarca", ID);

            marca = (Marca) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return marca;
    }

    static public Proveedor buscarProveedor(int ID) {
        Session session = null;
        Proveedor proveedor = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Proveedor proveedor where proveedor.idProveedor = :idproveedor");
            query.setParameter("idproveedor", ID);

            proveedor = (Proveedor) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return proveedor;
    }

    static public Presentacion buscarPresentacion(int ID) {
        Session session = null;
        Presentacion presentacion = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Presentacion presentacion where presentacion.idPresentacion = :idpresentacion");
            query.setParameter("idpresentacion", ID);

            presentacion = (Presentacion) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return presentacion;
    }

    static public Zona buscarZona(int ID) {
        Session session = null;
        Zona zona = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Zona zona where zona.idZona = :idzona");
            query.setParameter("idzona", ID);

            zona = (Zona) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return zona;
    }

    
    static public Producto buscarProducto(int ID) {
        Session session = null;
        Producto producto = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Producto producto where producto.idProducto = :idproducto");
            query.setParameter("idproducto", ID);

            producto = (Producto) query.list().get(0);
            producto.getMarca().getDescripcion();
            producto.getZona().getDescripcion();
            producto.getPresentacion().getDescripcion();
            producto.getProveedor().getDescripcion();
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return producto;
    }

    
    static public Marca buscarMarcaDesc(String descripcion) {
        Session session = null;
        Marca marca = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Marca marca where marca.descripcion = :desc");
            query.setParameter("desc", descripcion);

            marca = (Marca) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return marca;
    }

    static public Proveedor buscarProveedorDesc(String descripcion) {
        Session session = null;
        Proveedor proveedor = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Proveedor proveedor where proveedor.descripcion = :desc");
            query.setParameter("desc", descripcion);

            proveedor = (Proveedor) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return proveedor;
    }

    static public Presentacion buscarPresentacionDesc(String descripcion) {
        Session session = null;
        Presentacion presentacion = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Presentacion presentacion where presentacion.descripcion = :desc");
            query.setParameter("desc", descripcion);

            presentacion = (Presentacion) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return presentacion;
    }

    static public Zona buscarZonaDesc(String descripcion) {
        Session session = null;
        Zona zona = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("from Zona zona where zona.descripcion = :desc");
            query.setParameter("desc", descripcion);

            zona = (Zona) query.list().get(0);
            tx.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return zona;
    }

    static public boolean modificar(Marca marca) {
        boolean band = false;

        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.update(marca);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean modificar(Proveedor proveedor) {
        boolean band = false;

        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.update(proveedor);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean modificar(Presentacion presentacion) {
        boolean band = false;

        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.update(presentacion);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean modificar(Zona zona) {
        boolean band = false;

        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.update(zona);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    static public boolean modificar(Producto producto) {
        boolean band = false;

        Session session = null;

        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.update(producto);
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

        return band;
    }

    
    
    static public boolean eliminarMarca(int ID) {
        boolean band = false;
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("delete from Marca marca where marca.idMarca = :idmarca");
            query.setParameter("idmarca", ID);
            query.executeUpdate();
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return band;
    }

    static public boolean eliminarProveedor(int ID) {
        boolean band = false;
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("delete from Proveedor proveedor where proveedor.idProveedor = :idproveedor");
            query.setParameter("idproveedor", ID);
            query.executeUpdate();
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return band;
    }

    static public boolean eliminarPresentacion(int ID) {
        boolean band = false;
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("delete from Presentacion presentacion where presentacion.idPresentacion = :idpresentacion ");
            query.setParameter("idpresentacion ", ID);
            query.executeUpdate();
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return band;
    }

    static public boolean eliminarZona(int ID) {
        boolean band = false;
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("delete from Zona zona where zona.idZona = :idzona");
            query.setParameter("idzona", ID);
            query.executeUpdate();
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return band;
    }

    static public boolean eliminarProducto(int ID) {
        boolean band = false;
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            org.hibernate.Query query = session.createQuery("delete from Producto producto where producto.idProducto = :idproducto");
            query.setParameter("idproducto", ID);
            query.executeUpdate();
            tx.commit();
            session.close();
            band = true;

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return band;
    }

}
