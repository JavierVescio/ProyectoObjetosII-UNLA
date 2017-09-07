package dao.sectorProducto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorProducto.*;

public class PrecioProductoDao {
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
	public int agregar(PrecioProducto objeto) {
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
	
	public void actualizar(PrecioProducto objeto) throws HibernateException {
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
	
	public void eliminar(PrecioProducto objeto) throws HibernateException {
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
	public PrecioProducto traerPrecioProductoPorId(int idPrecioProducto) throws HibernateException {
		PrecioProducto objeto = null ;
		try {
			iniciaOperacion();
			objeto = (PrecioProducto)session.createQuery("from PrecioProducto p inner join fetch p.producto inner join fetch p.tipoCliente where idPrecioProducto="+idPrecioProducto).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los productos que hayan.
	//SELECT *, MAX(p.fechaCreacion) FROM precioproducto p WHERE p.idProducto = 6 AND p.idTipoCliente = 1 ;
	@SuppressWarnings("unchecked")
	public List<PrecioProducto> traerPrecioProductoPorCliente(int idProducto, int idTipoCliente) throws HibernateException {
		List<PrecioProducto> lista=null;

		try {
			iniciaOperacion();
			String strQuery = "from PrecioProducto p inner join fetch p.producto inner join fetch p.tipoCliente where p.producto = '"+idProducto+"' and p.tipoCliente = '"+idTipoCliente+"'";
			lista = session.createQuery(strQuery).list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
