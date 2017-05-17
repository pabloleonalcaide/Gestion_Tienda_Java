package stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import enumeraciones.*;
import excepciones.ArticuloNoExisteException;
import excepciones.ImposibleEliminarException;
import jerarquia.Articulo;
import jerarquia.Libro;

/**
 * Stock de articulos, envoltorio de arraylist
 * 
 * @author pablo
 * 
 */
public class Stock implements Serializable {
	private ArrayList<Articulo> stock = new ArrayList();
	private boolean modificado = false;

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Ordena los articulos por orden alfabetico
	 */
	void sortByName() {
		Collections.sort(stock, new CompareName());
	}

	/**
	 * Ordena los articulos por precio
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
		stock.get(indice).setCantidad(
				stock.get(indice).getCantidad() + cantidad);
	}

	/**
	 * Remueve definitivamente el articulo del stock
	 * 
	 * @param articulo
	 * @throws ImposibleEliminarException
	 */
	public void removeFromStock(Articulo articulo)
			throws ImposibleEliminarException {
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
	 * Extrae un articulo a traves de su id
	 */
	public Articulo getArticulo(int id) {
		int indice = stock.indexOf((Articulo) new Libro(id));
		return stock.get(indice);
	}

	/**
	 * Comprueba si hay articulos en la cesta del usuario
	 * 
	 * @return
	 */
	public boolean isBasketEmpty() {
		int aux = 0;
		for (Articulo art : stock) {
			if (art.isSeleccionado())
				return false;
		}
		return true;

	}

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
	public void replenishAll() {
		for (Articulo art : stock) {
			art.setCantidad(art.getCantidad() + 10);
		}

	}

	/**
	 * devuelve un iterador del arraylist
	 * 
	 * @return
	 */
	public ListIterator<Articulo> iterator() {
		return stock.listIterator();
	}

	/**
	 * Devuelve el catálogo de artículos (nombre, tipo de articulo y precio)
	 * 
	 * @return
	 */
	public String getCatalogo() {
		StringBuilder catalogo = new StringBuilder();
		for (Articulo art : stock) {
			catalogo.append("\nArticulo: " + art.getNombre() + ", Categoria: "
					+ art.getClass().getName());
		}
		return catalogo.toString();
	}

	@Override
	public String toString() {
		return "Stock [stock=" + stock + "]";
	}
}
