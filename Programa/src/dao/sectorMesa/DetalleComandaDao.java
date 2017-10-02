package dao.sectorMesa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorMesa.*;

public class DetalleComandaDao {
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
	public int agregar(DetalleComanda objeto) {
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
	
	public void actualizar(DetalleComanda objeto) throws HibernateException {
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
/* --- */
	
	
/* 2.TRAYENDO LA INFORMACION */
	//Mediante su clave primaria
	public DetalleComanda traerDetalleComandaPorId(int idDetalleComanda) throws HibernateException {
		DetalleComanda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (DetalleComanda)session.get(DetalleComanda.class, idDetalleComanda);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los DetalleComanda que hayan.
	@SuppressWarnings("unchecked")
	public List<DetalleComanda> traerDetalleComandas() throws HibernateException {
		List<DetalleComanda> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from DetalleComanda").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
