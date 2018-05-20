package dao.sectorMesa;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorMesa.*;

public class MesaDao {
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
	public int agregar(Mesa objeto) {
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
	
	public void actualizar(Mesa objeto) throws HibernateException {
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
	
	public void eliminar(Mesa objeto) throws HibernateException {
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
	public Mesa traerMesaPorId(int idMesa) throws HibernateException {
		Mesa objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Mesa)session.createQuery("from Mesa where idMesa='"+idMesa+"'").uniqueResult();
			Hibernate.initialize(objeto.getUnidades());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los Mesa que hayan.
	@SuppressWarnings("unchecked")
	public List<Mesa> traerMesas() throws HibernateException {
		List<Mesa> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Mesa order by nroMesa").list();
		}finally {
			session.close();
		}
		return lista;
	}

/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
