package jerarquia;

import java.time.LocalDate;

import enumeraciones.EstadoArticulo;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;
/**
 * Debido a que el descuento de los juegos se calcula en sus clases hijas
 * la clase Juego se ha definido como abstract (para poder dejar los métodos del interface sin cuerpo
 * @author pablo
 *
 */
public abstract class Juego extends Articulo {
	private double duracion_horas;
	private int edad_minima;
	
	public Juego(String nombre, String descripcion, double precio,
			EstadoArticulo estado, LocalDate fecha, double duracion, int edad)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha);
		setDuracion_horas(duracion);
		setEdad_minima(edad);
	}
	
	 double getDuracion_horas() {
		return duracion_horas;
	}

	 void setDuracion_horas(double duracion_horas) {
		this.duracion_horas = duracion_horas;
	}

	 int getEdad_minima() {
		return edad_minima;
	}
/**
 * Los juegos tienen un margen de edad entre 3 y 65 años, no vendemos chupetes ni piezas de dominó
 * @param edad_minima
 * @throws EdadNoValidaException
 */
	 void setEdad_minima(int edad_minima) throws EdadNoValidaException {
		 if (isEdadValida(edad_minima))
			 throw new EdadNoValidaException("edad fuera de los limites");
		 this.edad_minima = edad_minima;
	}

private boolean isEdadValida(int edad_minima) {
	return edad_minima>65 || edad_minima<3;
}


	 //El descuento se calcula en las clases que heredan de Juego, no en la propia clase Juego
	@Override
	public abstract void calcularDescuento();

	@Override
	public abstract double obtenerDescuento();

}