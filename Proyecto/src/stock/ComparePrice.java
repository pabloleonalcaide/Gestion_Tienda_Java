package stock;

import java.util.Comparator;
import jerarquia.Articulo;

/**
 * Clase que implementa el interface comparator, permitiendo que el stock sea
 * ordenado por precio.
 * 
 * @author pablo leon alcaide
 *
 */
public class ComparePrice implements Comparator<Articulo> {

	ComparePrice() {

	}

	@Override
	public int compare(Articulo e1, Articulo e2) {
		if (e1.calculateFinalPrice() < e2.calculateFinalPrice()) {
			return 1;
		} else if (e2.calculateFinalPrice() < e1.calculateFinalPrice()) {
			return -1;
		} else
			return 0;
	}
}
