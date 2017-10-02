package dao.sectorPersonal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorPersonal.*;

public class TipoPersonalDao {
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
	public int agregar(TipoPersonal objeto) {
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
	
	public void actualizar(TipoPersonal objeto) throws HibernateException {
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
	
	public void eliminar(TipoPersonal objeto) throws HibernateException {
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
	public TipoPersonal traerTipoPersonalPorId(int idTipoPersonal) throws HibernateException {
		TipoPersonal objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TipoPersonal)session.get(TipoPersonal.class, idTipoPersonal);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los TipoPersonal que hayan.
	@SuppressWarnings("unchecked")
	public List<TipoPersonal> traerTipoPersonals() throws HibernateException {
		List<TipoPersonal> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from TipoPersonal").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
