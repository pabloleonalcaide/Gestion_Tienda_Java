package jerarquia;

import java.time.LocalDate;

import enumeraciones.EstadoArticulo;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;

public class Tablero extends Juego {

	int num_piezas;
	double dimensiones;
	int num_jugadores;
	boolean coleccion;

	public Tablero(String nombre, String descripcion, double precio, EstadoArticulo estado, LocalDate fecha,
			double duracion, int edad, int piezas, double dimension, int jugadores, boolean coleccion)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad);
	}

	

	int getNum_piezas() {
		return num_piezas;
	}

	void setNum_piezas(int num_piezas) {
		this.num_piezas = num_piezas;
	}

	double getDimensiones() {
		return dimensiones;
	}

	void setDimensiones(double dimensiones) {
		this.dimensiones = dimensiones;
	}

	int getNum_jugadores() {
		return num_jugadores;
	}

	void setNum_jugadores(int num_jugadores) {
		this.num_jugadores = num_jugadores;
	}

	boolean isColeccion() {
		return coleccion;
	}

	void setColeccion(boolean coleccion) {
		this.coleccion = coleccion;
	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}
	/**
	 * El descuento se aplica en base a si es un juego coleccionable o no
	 */
	@Override
	public void calcularDescuento() {
		if (isColeccion())
			setDescuento(getPrecio() * 0.013);
		else
			setDescuento(0);
	}
}
