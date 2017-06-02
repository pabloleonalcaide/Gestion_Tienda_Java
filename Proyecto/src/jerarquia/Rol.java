package jerarquia;

import java.time.LocalDate;
import enumeraciones.EstadoArticulo;
import enumeraciones.GeneroRol;
import enumeraciones.MaterialRol;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;
/**
 * Clase Rol, que hereda de Juego, y ésta de Artículo
 * @author pablo
 *
 */
public class Rol extends Juego {

	private static final long serialVersionUID = 1L;
	private GeneroRol genero;
	private MaterialRol material;
	private double edicion;
	
	public Rol(String nombre, String descripcion, double precio,
			EstadoArticulo estado, LocalDate fecha, double duracion,
			int edad, GeneroRol genero, MaterialRol material, double edicion,int cantidad)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad,cantidad);
		setGenero(genero);
		setMaterial(material);
		setEdicion(edicion);
	}
	/**
	 * Constructor por id
	 * @param id
	 */
	public Rol(int id) {
		super(id);
	}
	/**
	 * 
	 * @return Genero de Rol
	 */
	public GeneroRol getGenero() {
		return genero;
	}
	/**
	 * 
	 * @param genero de rol
	 */
	public void setGenero(GeneroRol genero) {
		this.genero = genero;
	}
	/**
	 * 
	 * @return material de rol
	 */
	public MaterialRol getMaterial() {
		return material;
	}
	/**
	 * 
	 * @param material de rol
	 */
	public void setMaterial(MaterialRol material) {
		this.material = material;
	}
	/**
	 * 
	 * @return edicion de juego
	 */
	public double getEdicion() {
		return edicion;
	}
	/**
	 * 
	 * @param edicion
	 */
	public void setEdicion(double edicion) {
		this.edicion = edicion;
	}
	/**
	 * Descuento del 50% en ediciones por encima de la 2.0
	 */
	@Override
	public void calcularDescuento() {
		if (getEdicion()>2.0)
			setDescuento(getPrecio()*0.5);
		else setDescuento(0);

	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}

}
