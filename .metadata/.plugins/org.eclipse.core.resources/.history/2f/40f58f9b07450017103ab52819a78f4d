package jerarquia;

import java.time.LocalDate;

import enumeraciones.EstadoArticulo;
import enumeraciones.GeneroRol;
import enumeraciones.MaterialRol;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;
/**
 * @author pablo
 *
 */
public class Rol extends Juego {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GeneroRol genero;
	MaterialRol material;
	double edicion;
	
	public Rol(String nombre, String descripcion, double precio,
			EstadoArticulo estado, LocalDate fecha, double duracion,
			int edad, GeneroRol genero, MaterialRol material, double edicion)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad);
		setGenero(genero);
		setMaterial(material);
		setEdicion(edicion);
	}

	public GeneroRol getGenero() {
		return genero;
	}

	public void setGenero(GeneroRol genero) {
		this.genero = genero;
	}

	public MaterialRol getMaterial() {
		return material;
	}

	public void setMaterial(MaterialRol material) {
		this.material = material;
	}

	public double getEdicion() {
		return edicion;
	}

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
