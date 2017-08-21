package dao.sectorProducto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import dao.HibernateUtil;
import datos.sectorProducto.Producto;

public class ProductoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	

/* 1.ABM */
	//Agregar
	public int agregar(Producto objeto) {
		int id=0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	//Actualizar
	public void actualizar(Producto objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	//Eliminar
	public void eliminar(Producto objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
/* --- */
	
	
/* 2.TRAYENDO LA INFORMACION */
	//Mediante su clave primaria
	public Producto traerProducto(int idProducto) throws HibernateException {
		Producto objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Producto)session.get(Producto.class, idProducto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los productos que hayan.
	@SuppressWarnings("unchecked")
	public List<Producto> traerProductos() throws HibernateException {
		List<Producto> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Producto").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
}
