package stock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import enumeraciones.CategoriaLibro;
import enumeraciones.EstadoArticulo;
import enumeraciones.IdiomaLibro;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import excepciones.PrecioNoValidoException;
import jerarquia.Libro;

public class Pruebas {

	
	public static void main(String[] args) {
		Stock stock = new Stock();
		Libro libro = null;
		try {
			libro = new Libro("harry potter", "libro de magos", 20, EstadoArticulo.NUEVO, LocalDate.of(2016,12,11),
					520, LocalDate.of(2016,2,3), "Rowling", true, IdiomaLibro.INGLES, CategoriaLibro.NOVELA_AVENTURAS);
			Libro libro2 = new Libro("harry potter2", "libro de magos", 10, EstadoArticulo.NUEVO, LocalDate.of(2016,12,11),
					220, LocalDate.of(2016,2,3), "Rowling", true, IdiomaLibro.INGLES, CategoriaLibro.NOVELA_AVENTURAS);
			Libro libro3 = new Libro("harry potter3", "libro de magos", 100, EstadoArticulo.NUEVO, LocalDate.of(2016,12,11),
					220, LocalDate.of(2016,2,3), "Rowling", true, IdiomaLibro.INGLES, CategoriaLibro.NOVELA_AVENTURAS);
			Libro libro4 = new Libro("harry potter4", "libro de magos", 1, EstadoArticulo.NUEVO, LocalDate.of(2016,12,11),
					220, LocalDate.of(2016,2,3), "Rowling", true, IdiomaLibro.INGLES, CategoriaLibro.NOVELA_AVENTURAS);
			stock.addToStock(libro, 5);
			System.out.println("precio: "+libro.getPrecio());
			System.out.println(libro.obtenerDescuento());
			System.out.println("total: "+libro.calcularTotal());
			System.out.println("descuento:"+libro.getDescuento());
			stock.addToStock(libro2, 5);
			stock.addToStock(libro3, 5);
			stock.addToStock(libro4, 5);
			System.out.println(libro.getPrecio());
			System.out.println(libro.calcularTotal());
			System.out.println(stock.toString());
			System.out.println("descuento" +libro.getDescuento());

			System.out.println("------------------------------------");
			stock.sortByPrice();
			
			System.out.println("--------------------------------");
			stock.sortByName();
		} catch (NombreNoValidoException e) {
			e.printStackTrace();
		} catch (PrecioNoValidoException e) {
			e.printStackTrace();
		} catch (FechaNoValidaException e) {
			e.printStackTrace();
		}
		
	}
		
}