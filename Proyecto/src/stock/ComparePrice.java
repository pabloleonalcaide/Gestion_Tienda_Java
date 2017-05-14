package stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jerarquia.Articulo;

/**
 * Clase que implementa el interface comparator, permitiendo que el stock sea
 * ordenado por precio.
 * 
 * @author pablo
 *
 */
public class ComparePrice implements Comparator<Articulo> {

	ComparePrice() {

	}

	@Override
	public int compare(Articulo e1, Articulo e2) {
		if (e1.calcularTotal() < e2.calcularTotal()) {
			return 1;
		} else if (e2.calcularTotal() < e1.calcularTotal()) {
			return -1;
		} else
			return 0;
	}
}
