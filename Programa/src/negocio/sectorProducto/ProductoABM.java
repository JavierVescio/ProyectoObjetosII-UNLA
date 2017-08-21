package negocio.sectorProducto;

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
	
	public void modificar(Producto producto) {
		dao.actualizar(producto);	
	}
	
	public void eliminar(int idProducto) throws Exception {
		Producto producto = dao.traerProducto(idProducto);
		if (producto==null)
			throw new Exception("El idProducto ingresado no se corresponde a ningun producto");
		dao.eliminar(producto);
	}
/* --- */
	
	
/* 2.TRAYENDO LA INFORMACION */
	public Producto traerProducto(int idProducto) throws Exception{
		Producto producto = dao.traerProducto(idProducto);
		if (producto==null)
			throw new Exception("producto nulo");
		return producto;
	}
	
	public List<Producto> traerProductos() {
		return dao.traerProductos();
	}
/* --- */
	
	
}
