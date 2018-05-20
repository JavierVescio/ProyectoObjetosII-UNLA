package dao.sectorMesa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorMesa.*;

public class TicketDao {
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
	public int agregar(Ticket objeto) {
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
	
	public void actualizar(Ticket objeto) throws HibernateException {
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
	
	public void eliminar(Ticket objeto) throws HibernateException {
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
	public Ticket traerTicketPorId(int idTicket) throws HibernateException {
		Ticket objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Ticket)session.get(Ticket.class, idTicket);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Ticket traerTicketPorIdConComandaYPersonal(int idTicket) throws HibernateException {
		Ticket objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Ticket)session.createQuery("from Ticket t "
					+ "inner join fetch t.personal p "
					+ "inner join fetch t.comanda comanda "
					+ "inner join fetch comanda.ocupacionMesa ocupacionMesa "
					+ "inner join fetch ocupacionMesa.cliente cliente "
					+ "inner join fetch ocupacionMesa.camarero camarero "
					+ "inner join fetch ocupacionMesa.mesa mesa "
					+ "inner join fetch comanda.detalleComandas detalleComandas "
					+ "inner join fetch detalleComandas.producto producto "
					+ "where t.idTicket='"+idTicket+"'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Traer en una lista todos los Ticket que hayan.
	@SuppressWarnings("unchecked")
	public List<Ticket> traerTickets() throws HibernateException {
		List<Ticket> lista=null;

		try {
			iniciaOperacion();
			
			lista = session.createQuery("from Ticket t "
					+ "inner join fetch t.personal personal "
					+ "inner join fetch t.comanda comanda "
					+ "inner join fetch comanda.ocupacionMesa ocupacionMesa "
					+ "inner join fetch ocupacionMesa.cliente cliente "
					+ "inner join fetch ocupacionMesa.camarero camarero "
					+ "inner join fetch ocupacionMesa.mesa mesa").list();
		}finally {
			session.close();
		}
		return lista;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}
