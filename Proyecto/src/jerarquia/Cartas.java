package jerarquia;

import java.time.LocalDate;

import enumeraciones.DificultadCartas;
import enumeraciones.EstadoArticulo;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;

public class Cartas extends Juego {
	private int num_cartas;
	private DificultadCartas dificultad;
	private boolean coleccion;
	


	public Cartas(String nombre, String descripcion, double precio,
			EstadoArticulo estado, LocalDate fecha, double duracion, int edad,int numCartas,
			DificultadCartas dif, boolean coleccion)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad);
		setNum_cartas(numCartas);
		setDificultad(dif);
		setColeccion(coleccion);
	}
	int getNum_cartas() {
		return num_cartas;
	}

	void setNum_cartas(int num_cartas) {
		this.num_cartas = num_cartas;
	}

	DificultadCartas getDificultad() {
		return dificultad;
	}

	void setDificultad(DificultadCartas dificultad) {
		this.dificultad = dificultad;
	}

	boolean isColeccion() {
		return coleccion;
	}

	void setColeccion(boolean coleccion) {
		this.coleccion = coleccion;
	}
	/**
	 * El descuento se calcula en base a que sea o no coleccionable
	 */
	@Override
	public void calcularDescuento() {
		if(isColeccion())
			setDescuento(getPrecio()*0.010);
		else 
			setDescuento(0);
	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}

}