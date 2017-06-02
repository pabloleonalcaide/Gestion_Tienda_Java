package stock;

import java.util.Comparator;

import jerarquia.Articulo;
/**
 * Clase que implementa el interface comparator, permitiendo 
 * que el stock sea ordenado por precio.
 * @author pablo leon alcaide
 *
 */
public class CompareName implements Comparator <Articulo> {

		
		CompareName(){
		}
		 @Override
		    public int compare(Articulo e1, Articulo e2) {
				return e1.getNombre().toLowerCase().compareTo(e2.getNombre().toLowerCase());

		    }
		
	}


