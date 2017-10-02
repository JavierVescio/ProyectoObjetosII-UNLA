package dao.sectorPersonal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import datos.sectorPersonal.*;

public class LogInDao {
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
	public int agregar(LogIn objeto) {
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

	public void actualizar(LogIn objeto) throws HibernateException {
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

	public void eliminar(LogIn objeto) throws HibernateException {
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
	public LogIn traerLogInPorId(int idLogIn) throws HibernateException {
		LogIn objeto = null ;
		try {
			iniciaOperacion();
			objeto = (LogIn)session.get(LogIn.class, idLogIn);
		} finally {
			session.close();
		}
		return objeto;
	}

	public LogIn traerLogInPorUsuarioContrasenia(String usuario, String contrasenia) throws HibernateException {
		LogIn objeto = null;
		try {
			iniciaOperacion();
			objeto = (LogIn)session.createQuery("from LogIn where usuario = '"+usuario+"' and contrasenia = '"+contrasenia+"'").uniqueResult();
		}
		finally {
			session.close();
		}
		return objeto;
	}

	/* --- */


	/* 3.OTRAS FUNCIONES */


	/* --- */	
}
