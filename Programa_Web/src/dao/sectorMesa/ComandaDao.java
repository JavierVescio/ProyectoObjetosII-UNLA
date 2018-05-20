package dao.sectorMesa;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import dao.HibernateUtil;
import datos.sectorMesa.*;

public class ComandaDao {
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
	

/* 1.ABM COMANDA */
	public int agregar(Comanda objeto) {
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
	
	public void actualizar(Comanda objeto) throws HibernateException {
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
	public Comanda traerComandaPorId(int idComanda) throws HibernateException {
		Comanda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Comanda)session.get(Comanda.class, idComanda);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Mediante su clave primaria.
	public Comanda traerComandaYDetalleComandasPorId(int idComanda) throws HibernateException {
		Comanda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Comanda)session.createQuery("from Comanda c "
					+ "inner join fetch c.ocupacionMesa o "
					+ "left join fetch c.detalleComandas detalleComandas "
					+ "left join fetch detalleComandas.producto producto "
					+ "inner join fetch o.mesa m "
					+ "where c.anulada = false and c.idComanda = '"+idComanda+"'").uniqueResult();
			//Hibernate.initialize(objeto.getDetalleComandas()); Me inicializa los detalles de comanda pero no los productos que están en el detalle
			System.out.println("Salgo bien");
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Esta funcion se llama desde crearDetalleComandas  ..
	@SuppressWarnings("unchecked")
	public List<Comanda> traerComandas() throws HibernateException {
		List<Comanda> lista=null;
		List<Ticket> listaTicket=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Comanda c inner join fetch c.ocupacionMesa o inner join fetch o.cliente inner join fetch o.camarero inner join fetch o.mesa order by c.idComanda asc").list();
			
			listaTicket = session.createQuery("from Ticket t inner join fetch t.comanda").list();
			
			
			//Esto sirve para que cuando se vaya a generar el ticket, no se muestren comandas que ya tienen ticket generado
			for (Ticket ticket:listaTicket){		
				for(int x=lista.size()-1;x>=0;x--){
					if (ticket.getComanda().equals(lista.get(x))){
						lista.remove(x);
					}
				}
			}
		}finally {
			session.close();
		}
		return lista;
	}
	
	//Funcion que se llama para traerComandas desde generarTicket
	@SuppressWarnings("unchecked")
	public List<Comanda> traerComandasAptasParaGenerarTicket() throws HibernateException {
		List<Comanda> lista=null;
		List<Ticket> listaTicket=null;

		try {
			iniciaOperacion();
			//lista = session.createQuery("from Comanda c inner join fetch c.detalleComandas inner join fetch c.ocupacionMesa o inner join fetch o.cliente inner join fetch o.camarero inner join fetch o.mesa order by c.idComanda asc").list();
			lista = session.createQuery("from Comanda c inner join fetch c.ocupacionMesa o inner join fetch o.cliente inner join fetch o.camarero inner join fetch o.mesa order by c.idComanda asc").list();
			
			listaTicket = session.createQuery("from Ticket t inner join fetch t.comanda").list();
			
			
			//Esto sirve para que cuando se vaya a generar el ticket, no se muestren comandas que ya tienen ticket generado
			for (Ticket ticket:listaTicket){		
				for(int x=lista.size()-1;x>=0;x--){
					if (ticket.getComanda().equals(lista.get(x))){
						lista.remove(x);
					}
				}
			}
			
		}finally {
			session.close();
		}
		return lista;
	}
	
	
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- 
 * 
 * 
 * 
	//Traer en una lista todos los Comanda que hayan.
	@SuppressWarnings("unchecked")
	public List<Comanda> traerComandas() throws HibernateException {
		List<Comanda> lista=null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from Comanda c inner join fetch c.ocupacionMesa o inner join fetch o.cliente inner join fetch o.camarero inner join fetch o.mesa order by c.idComanda asc").list();
			
			
		}finally {
			session.close();
		}
		return lista;
	}




 * 
 * */	
}
