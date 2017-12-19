package dao.sectorMesa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorMesa.*;

public class OcupacionMesaDao {
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
	public int agregar(OcupacionMesa objeto) {
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
	
	public void actualizar(OcupacionMesa objeto) throws HibernateException {
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
	
	public void eliminar(OcupacionMesa objeto) throws HibernateException {
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
	public OcupacionMesa traerOcupacionMesaPorId(int idOcupacionMesa) throws HibernateException {
		OcupacionMesa objeto = null ;
		try {
			iniciaOperacion();
			objeto = (OcupacionMesa)session.createQuery("from OcupacionMesa m inner join fetch m.cliente c inner join fetch c.tipoCliente where m.idOcupacionMesa='"+idOcupacionMesa+"'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Mediante su nroOcupacionMesa
	public OcupacionMesa traerOcupacionMesaPorNroOcupacionMesa(int nroOcupacionMesa) throws HibernateException {
		OcupacionMesa objeto = null ;
		try {
			iniciaOperacion();
			objeto = (OcupacionMesa)session.createQuery("from OcupacionMesa m inner join fetch m.cliente c inner join fetch c.tipoCliente where m.nroOcupacionMesa='"+nroOcupacionMesa+"'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los OcupacionMesa que hayan.
	@SuppressWarnings("unchecked")
	public List<OcupacionMesa> traerOcupacionMesas() throws HibernateException {
		List<OcupacionMesa> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from OcupacionMesa om inner join fetch Cliente c inner join fetch Mesa m").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
