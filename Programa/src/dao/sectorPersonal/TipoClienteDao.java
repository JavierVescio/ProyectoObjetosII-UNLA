package dao.sectorPersonal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorPersonal.*;

public class TipoClienteDao {
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
	public int agregar(TipoCliente objeto) {
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
	
	public void actualizar(TipoCliente objeto) throws HibernateException {
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
	
	public void eliminar(TipoCliente objeto) throws HibernateException {
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
	public TipoCliente traerTipoClientePorId(int idTipoCliente) throws HibernateException {
		TipoCliente objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TipoCliente)session.get(TipoCliente.class, idTipoCliente);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los TipoCliente que hayan.
	@SuppressWarnings("unchecked")
	public List<TipoCliente> traerTipoClientes() throws HibernateException {
		List<TipoCliente> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from TipoCliente").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
