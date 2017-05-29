package stock;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import enumeraciones.*;
import excepciones.ArticuloNoExisteException;
import excepciones.EdadNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.ImposibleEliminarException;
import excepciones.NombreNoValidoException;
import excepciones.PesoNoValidoException;
import excepciones.PrecioNoValidoException;
import jerarquia.Articulo;
import jerarquia.Cartas;
import jerarquia.Figura;
import jerarquia.Juego;
import jerarquia.Libro;
import jerarquia.Rol;
import jerarquia.Tablero;

/**
 * Stock de articulos, envoltorio de arraylist
 * 
 * @author pablo
 * 
 */
public class Stock implements Serializable {
	private ArrayList<Articulo> stock = new ArrayList<Articulo>();
	private boolean modificado = false;

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Ordena los articulos por orden alfabetico
	 * @see stock.CompareName
	 */
	void sortByName() {
		Collections.sort(stock, new CompareName());
	}

	/**
	 * Ordena los articulos por precio
	 * @see stock.ComparePrice
	 */
	void sortByPrice() {
		Collections.sort(stock, new ComparePrice());

	}

	/**
	 * Si encuentra el articulo en el stock, lo selecciona en la cesta del
	 * usuario, de lo contrario, lanza un mensaje advirtiendo
	 * 
	 * @param articulo
	 * @throws ArticuloNoExisteException
	 */
	void addToBasket(Articulo articulo) throws ArticuloNoExisteException {
		if (stock.contains(articulo))
			articulo.setSeleccionado(true);
		else
			throw new ArticuloNoExisteException("el articulo no existe");
	}

	/**
	 * si encuentra el articulo y está seleccionado por el usuario, lo vuelve de
	 * nuevo a false de lo contrario, lanza un mensaje
	 * 
	 * @param articulo
	 */
	void takeOut(Articulo articulo) {
		if (stock.contains(articulo) && articulo.isSeleccionado())
			articulo.setSeleccionado(false);
		else
			System.out.println("imposible eliminar");
	}

	/**
	 * Desmarca todos los articulos en cascada de la cesta del usuario
	 */
	void takeOutAll() {
		for (Articulo art : stock) {
			art.setSeleccionado(false);
		}
	}

	/**
	 * si el articulo no existia, lo incluye en el stock, si ya había alguno,
	 * aumenta la cantidad
	 * 
	 * @param articulo
	 * @param cantidad
	 */
	public void addToStock(Articulo articulo, int cantidad) {
		if (!stock.contains(articulo)) {
			stock.add(articulo);
		}
		int indice = stock.indexOf(articulo);
		stock.get(indice).setCantidad(stock.get(indice).getCantidad() + cantidad);
	}

	/**
	 * Remueve definitivamente el articulo del stock
	 * 
	 * @param articulo
	 * @throws ImposibleEliminarException
	 */
	public void removeFromStock(Articulo articulo) throws ImposibleEliminarException {
		if (!stock.remove(articulo))
			throw new ImposibleEliminarException("no se ha podido eliminar");
	}

	/**
	 * Comprueba y muestra las existencias de cada articulo
	 */
	String checkStock() {
		StringBuilder sb = new StringBuilder();
		for (Articulo art : stock) {
			sb.append("\n" + art.getNombre() + ": " + art.getCantidad());
			if (art.getCantidad() <= 5)
				sb.append(" (hay que comprar)");
		}
		return sb.toString();
	}

	/**
	 * Descataloga el articulo (ha dejado de comercializarse)
	 * 
	 * @param articulo
	 */
	void discontinueProduct(Articulo articulo) {
		int indice = stock.indexOf(articulo);
		stock.get(indice).setEstado(EstadoArticulo.DESCATALOGADO);
	}

	public int size() {
		return stock.size();
	}

	public boolean isEmpty() {
		return stock.isEmpty();
	}

	// Muestra articulos destacados, escogidos por el dueño ---> IMPLEMENTAR
	void showBestFive() {

	}

	/**
	 * Extrae un Libro a traves de su id
	 */
	public Articulo getLibro(int id) {
		int indice = stock.indexOf((Articulo) new Libro(id));
		return stock.get(indice);
	}

	/**
	 * Extrae un Juego de Tablero a traves de su id
	 * 
	 * @param id
	 * @return
	 */
	public Articulo getTablero(int id) {
		int indice = stock.indexOf((Articulo) new Tablero(id));
		return stock.get(indice);
	}

	/**
	 * Extrae un Juego de Cartas a traves de su id
	 * 
	 * @param id
	 * @return
	 */
	public Articulo getCartas(int id) {
		int indice = stock.indexOf((Articulo) new Libro(id));
		return stock.get(indice);
	}

	/**
	 * Extrae un Juego de Rol a través de su id
	 * 
	 * @param id
	 * @return
	 */
	public Articulo getRol(int id) {
		int indice = stock.indexOf((Articulo) new Libro(id));
		return stock.get(indice);
	}

	/**
	 * Extrae una Figura a través de su id
	 * 
	 * @param id
	 * @return
	 */
	public Articulo getFigura(int id) {
		int indice = stock.indexOf((Articulo) new Figura(id));
		return stock.get(indice);
	}

	/**
	 * Devuelve un articulo a traves de su id
	 * 
	 * @param cod
	 * @return
	 */
	public Articulo devuelvePorCódigo(int id) {
		Articulo articulo;
		for (Articulo art : stock) {
			articulo = art;
			if (articulo.getId() == id) {
				return articulo;
			}
		}
		return null;
	}
	
	public int indexOf(Articulo articulo) {
		return indexOf(articulo);
	}

	/**
	 * Comprueba si hay articulos en la cesta del usuario
	 * 
	 * @return
	 */
	public boolean isBasketEmpty() {
		for (Articulo art : stock) {
			if (art.isSeleccionado())
				return false;
		}
		return true;

	}
	/**
	 * Devuelve el stock de productos (ArrayList)
	 * @return
	 */
	public ArrayList<Articulo> getStock() {
		return this.stock;
	}

	/**
	 * Elimina un articulo a traves de su id
	 * 
	 * @param id
	 */
	public void removeArticulo(int id) {
		int indice = stock.indexOf((Articulo) new Libro(id));
		stock.remove(indice);
	}

	/**
	 * Aumenta el stock de todos los articulos en +10
	 */
	public void replenishAll() { 	//--> Pasar por parámetro la cantidad??
		for (Articulo art : stock) {
			art.setCantidad(art.getCantidad() + 10);
		}

	}

	/**
	 * devuelve un iterador del arraylist
	 * 
	 * @return
	 */
	public ListIterator<Articulo> listIterator() {
		return stock.listIterator();
	}

	/**
	 * Devuelve un iterador ordenando los articulos por nombre
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iteratorName() {
		sortByName();
		return stock.listIterator();
	}

	/**
	 * Devuelve un iterador ordenando los articulos por precio
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iteratorPrice() {
		sortByPrice();
		return stock.listIterator();
	}

	/**
	 * Devuleve un iterador de Articulos del tipo Libro
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iteratorLibro() {
		ArrayList<Articulo> listaLibros = new ArrayList<Articulo>();
		for (Articulo art : stock) {
			if (art instanceof Libro) {
				listaLibros.add(art);
			}
		}
		return listaLibros.listIterator();
	}

	/**
	 * Devuleve un iterador de Articulos del tipo Figura
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iteratorFigura() {
		ArrayList<Articulo> listaFiguras = new ArrayList<Articulo>();
		for (Articulo art : stock) {
			if (art instanceof Figura) {
				listaFiguras.add(art);
			}
		}
		return listaFiguras.listIterator();
	}

	/**
	 * Devuleve un iterador de Articulos del tipo Juego
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iteratorJuego() {
		ArrayList<Articulo> listaJuego = new ArrayList<Articulo>();
		for (Articulo art : stock) {
			if (art instanceof Juego) {
				listaJuego.add(art);
			}
		}
		return listaJuego.listIterator();
	}

	/**
	 * Devuelve el catálogo de artículos (nombre, tipo de articulo y precio)
	 * 
	 * @return
	 */
	public String getCatalogo() {
		StringBuilder catalogo = new StringBuilder();
		for (Articulo art : stock) {
			catalogo.append("\nArticulo: " + art.getNombre() + ", Categoria: " + art.getClass().getName());
		}
		return catalogo.toString();
	}

	/**
	 * Modifica los datos del Articulo Libro
	 * 
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 * @param estado
	 * @param descripcion
	 * @param fecha
	 * @param paginas
	 * @param publicacion
	 * @param autor
	 * @param coleccion
	 * @param idioma
	 * @param categoria
	 * @throws PrecioNoValidoException
	 * @throws NombreNoValidoException
	 * @throws FechaNoValidaException
	 */
	public void ModificarLibro(int index, String nombre, double precio, int cantidad, EstadoArticulo estado,
			String descripcion, LocalDate fecha, int paginas, LocalDate publicacion, String autor, boolean coleccion,
			IdiomaLibro idioma, CategoriaLibro categoria)
			throws PrecioNoValidoException, NombreNoValidoException, FechaNoValidaException {
		stock.get(index).setNombre(nombre);
		stock.get(index).setPrecio(precio);
		stock.get(index).setCantidad(cantidad);
		stock.get(index).setEstado(estado);
		stock.get(index).setDescripcion(descripcion);
		stock.get(index).setFecha(fecha);
		((Libro) stock.get(index)).setPaginas(paginas);
		((Libro) stock.get(index)).setFechaPublicacion(publicacion);
		((Libro) stock.get(index)).setAutor(autor);
		((Libro) stock.get(index)).setColeccion(coleccion);
		((Libro) stock.get(index)).setIdioma(idioma);
		((Libro) stock.get(index)).setCategoria(categoria);
	}

	/**
	 * Modifica los datos del Articulo Figura
	 * 
	 * @param index
	 * @param peso
	 * @param tematica
	 * @param coleccion
	 * @param desmontable
	 * @param numElementos
	 * @throws PrecioNoValidoException
	 * @throws PesoNoValidoException
	 */
	public void ModificarFigura(int index, String nombre, double precio, int cantidad, EstadoArticulo estado,
			String descripcion, LocalDate fecha, Double peso, String tematica, boolean coleccion, boolean desmontable,
			int numElementos) throws PrecioNoValidoException, PesoNoValidoException {
		stock.get(index).setNombre(nombre);
		stock.get(index).setPrecio(precio);
		stock.get(index).setCantidad(cantidad);
		stock.get(index).setEstado(estado);
		stock.get(index).setDescripcion(descripcion);
		stock.get(index).setFecha(fecha);
		((Figura) stock.get(index)).setPeso(peso);
		((Figura) stock.get(index)).setTematica(tematica);
		((Figura) stock.get(index)).setColeccion(coleccion);
		((Figura) stock.get(index)).setDesmontable(desmontable);
		((Figura) stock.get(index)).setNum_elementos(numElementos);

	}

	/**
	 * Modifica los datos del Articulo Juego-Rol
	 * 
	 * @param index
	 * @param duracion 
	 * @param edad 
	 * @param genero 
	 * @param material 
	 * @param edicion 
	 * @throws PrecioNoValidoException 
	 * @throws EdadNoValidaException 
	 */
	public void ModificarRol(int index,String nombre, double precio, int cantidad, EstadoArticulo estado,
			String descripcion,LocalDate fecha, double duracion, int edad, GeneroRol genero, MaterialRol material, Double edicion) throws PrecioNoValidoException, EdadNoValidaException {
		stock.get(index).setNombre(nombre);
		stock.get(index).setPrecio(precio);
		stock.get(index).setCantidad(cantidad);
		stock.get(index).setEstado(estado);
		stock.get(index).setDescripcion(descripcion);
		stock.get(index).setFecha(fecha);
		((Juego) stock.get(index)).setDuracion(duracion);
		((Juego) stock.get(index)).setEdad(edad);
		((Rol) stock.get(index)).setGenero(genero);
		((Rol) stock.get(index)).setMaterial(material);
		((Rol) stock.get(index)).setEdicion(edicion);

	}

	/**
	 * Modifica los datos del Articulo Juego-Cartas
	 * 
	 * @param index
	 * @param edad
	 * @param duracion
	 * @param numCartas 
	 * @param dificultad 
	 * @param coleccion 
	 * @throws PrecioNoValidoException
	 * @throws EdadNoValidaException
	 */
	public void ModificarCartas(int index, String nombre, double precio, int cantidad, EstadoArticulo estado,
			String descripcion, LocalDate fecha, int edad, double duracion, int numCartas, DificultadCartas dificultad, boolean coleccion)
			throws PrecioNoValidoException, EdadNoValidaException {
		stock.get(index).setNombre(nombre);
		stock.get(index).setPrecio(precio);
		stock.get(index).setCantidad(cantidad);
		stock.get(index).setEstado(estado);
		stock.get(index).setDescripcion(descripcion);
		stock.get(index).setFecha(fecha);
		((Juego) stock.get(index)).setDuracion(duracion);
		((Juego) stock.get(index)).setEdad(edad);
		((Cartas) stock.get(index)).setNum_cartas(numCartas);
		((Cartas) stock.get(index)).setDificultad(dificultad);
		((Cartas) stock.get(index)).setColeccion(coleccion);
		
	}

	/**
	 * Modifica los datos del Articulo Juego-Tablero
	 * 
	 * @param index
	 * @param duracion
	 * @param edad
	 * @param piezas 
	 * @param coleccion 
	 * @param jugadores 
	 * @param dimensiones 
	 * @throws PrecioNoValidoException
	 * @throws EdadNoValidaException
	 */
	public void ModificarTablero(int index, String nombre, double precio, int cantidad, EstadoArticulo estado,
			String descripcion, LocalDate fecha, double duracion, int edad, int piezas, boolean coleccion, int jugadores, double dimensiones)
			throws PrecioNoValidoException, EdadNoValidaException {
		stock.get(index).setNombre(nombre);
		stock.get(index).setPrecio(precio);
		stock.get(index).setCantidad(cantidad);
		stock.get(index).setEstado(estado);
		stock.get(index).setDescripcion(descripcion);
		stock.get(index).setFecha(fecha);
		((Juego) stock.get(index)).setDuracion(duracion);
		((Juego) stock.get(index)).setEdad(edad);
		((Tablero) stock.get(index)).setNum_piezas(piezas);
		((Tablero) stock.get(index)).setDimensiones(dimensiones);
		((Tablero) stock.get(index)).setNum_jugadores(jugadores);
		((Tablero) stock.get(index)).setColeccion(coleccion);

	}

	@Override
	public String toString() {
		return "Stock [stock=" + stock + "]";
	}
}
