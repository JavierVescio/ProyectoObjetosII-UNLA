package negocio.sectorProducto;

import java.util.ArrayList;
import java.util.List;

import dao.sectorProducto.ProductoDao;
import datos.sectorProducto.*;

public class ProductoABM {
	ProductoDao dao = new ProductoDao();
	
	
/* 1.ABM */
	public int agregarPlato(String nombre, String descripcion, String imagen, String notas) {
		Producto producto = new Plato(nombre, descripcion, imagen, notas);
		return dao.agregar(producto);
	}
	
	public int agregarBebida(String nombre, String descripcion, String imagen, String notas) {
		Producto producto = new Bebida(nombre, descripcion, imagen, notas);
		return dao.agregar(producto);
	}
	
	public void modificar(Producto producto) throws Exception {
		if (producto==null)
			throw new Exception("producto nulo");
		dao.actualizar(producto);	
	}
	
	public void eliminar(int idProducto) throws Exception {
		Producto producto = dao.traerProductoPorId(idProducto);
		if (producto==null)
			throw new Exception("El idProducto ingresado no se corresponde a ningun producto");
		dao.eliminar(producto);
	}
/* --- */
	
	
/* 2.TRAYENDO LA INFORMACION */
	public Producto traerProductoPorId(int idProducto) throws Exception{
		Producto producto = dao.traerProductoPorId(idProducto);
		if (producto==null)
			throw new Exception("producto nulo");
		return producto;
	}
	
	public List<Producto> traerProductoPorNombre(String nombre) throws Exception{
		if (nombre=="")
			throw new Exception("No ha ingresado texto de busqueda");
		List<Producto> listaProducto = dao.traerProductoPorNombre(nombre);
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaProducto;
	}
	
	public List<Producto> traerProductoPorNombreBebida(String nombre) throws Exception {
		List<Producto> listaBebida;
		if (nombre=="")
			throw new Exception("No ha ingresado texto de busqueda");
		List<Producto> listaProducto = dao.traerProductoPorNombre(nombre);
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		
		listaBebida = new ArrayList<Producto>();
		for(Producto producto: listaProducto){
			if (producto instanceof Bebida){
				listaBebida.add(producto);
			}
		}
		return listaBebida;
	}
	
	public List<Producto> traerProductoPorNombrePlato(String nombre) throws Exception {
		List<Producto> listaPlato;
		if (nombre=="")
			throw new Exception("No ha ingresado texto de busqueda");
		List<Producto> listaProducto = dao.traerProductoPorNombre(nombre);
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		
		listaPlato = new ArrayList<Producto>();
		for(Producto producto: listaProducto){
			if (producto instanceof Plato){
				listaPlato.add(producto);
			}
		}
		return listaPlato;
	}
	
	public List<Producto> traerPlatos() throws Exception {
		List<Producto> listaPlato;
		List<Producto> listaProducto = traerProductos();
		
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		
		listaPlato = new ArrayList<Producto>();
		for(Producto producto: listaProducto){
			if (producto instanceof Plato){
				listaPlato.add(producto);
			}
		}
		return listaPlato;
	}
	
	public List<Producto> traerBebidas() throws Exception {
		List<Producto> listaBebidas;
		List<Producto> listaProducto = traerProductos();
		
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		
		listaBebidas = new ArrayList<Producto>();
		for(Producto producto: listaProducto){
			if (producto instanceof Bebida){
				listaBebidas.add(producto);
			}
		}
		return listaBebidas;
	}
	
	public List<Producto> traerProductos() throws Exception {
		List<Producto> listaProducto = dao.traerProductos();
		if (listaProducto.isEmpty())
			throw new Exception("No se obtuvo resultados");
		return listaProducto;
	}
/* --- */
	
	
/* 3.OTRAS FUNCIONES */
	 
	
	
/* --- */
	
	
}
