package jerarquia;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enumeraciones.*;
import excepciones.*;
/**
 * Clase Libro, hereda de Articulo
 * @author pablo leon alcaide
 *
 */
public class Libro extends Articulo {


	private static final long serialVersionUID = 1L;
	private static final int PAGINAS_MINIMAS = 20;
	private int paginas;
	private LocalDate fechaPublicacion;
	private String autor;
	private boolean coleccion;
	private IdiomaLibro idioma;
	private CategoriaLibro categoria;
	// Patron para el nombre del autor
	private Pattern patronAutor = Pattern.compile("^[A-Z][A-Za-z]+.[A-Za-z]+");

	public Libro(String nombre, String descripcion, double precio, EstadoArticulo estado, LocalDate fecha, int paginas,
			LocalDate fechaPublicacion, String autor, boolean coleccion, IdiomaLibro idioma, CategoriaLibro genero,int cantidad)
			throws NombreNoValidoException, PrecioNoValidoException, FechaNoValidaException {
		super(nombre, descripcion, precio, estado, fecha,cantidad);
		setPaginas(paginas);
		setFechaPublicacion(fechaPublicacion);
		setAutor(autor);
		setColeccion(coleccion);
		setIdioma(idioma);
		setCategoria(genero);

	}
	/**
	 * Constructor por id
	 * @param id
	 */
	public Libro(int id) {
		super(id);
	}
	/**
	 * Constructor por nombre
	 * @param nombre
	 */
	public Libro(String nombre) {
		super(nombre);
	}

	/**
	 * El descuento se calcula en base al numero de paginas del libro
	 */
	@Override
	public void calcularDescuento() {
		if (getPaginas() >= 100)
			setDescuento((getPaginas() * getVariableDescuento()));
		else {
			setDescuento(0);
		}

	}
	/**
	 * 
	 * @return variable del descuento
	 */
	private double getVariableDescuento() {
		return getPaginas() * 0.00001;
	}
	/**
	 * 
	 * @return paginas
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * establecemos un minimo de paginas para considerarlo libro
	 * 
	 * @param paginas
	 */
	public void setPaginas(int paginas) {
		if (paginas > PAGINAS_MINIMAS)
			this.paginas = paginas;
		else
			this.paginas = PAGINAS_MINIMAS;
	}
	/**
	 * 
	 * @return fecha de publicacion
	 */
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	/**
	 * 
	 * @param fechaPublicacion
	 * @throws FechaNoValidaException
	 */
	public void setFechaPublicacion(LocalDate fechaPublicacion) throws FechaNoValidaException {
		if (fechaValida(fechaPublicacion))
			this.fechaPublicacion = fechaPublicacion;
		else
			throw new FechaNoValidaException("la fecha no puede ser posterior a hoy, lo siento");
	}

	/**
	 * Comprueba que la fecha de publicacion no es una fecha futura
	 * 
	 * @param fechaPublicacion
	 * @return
	 */
	private boolean fechaValida(LocalDate fechaPublicacion) {
		return LocalDate.now().isAfter(fechaPublicacion);
	}
	/**
	 * 
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * El nombre del autor comienza con Mayúscula y no contiene simbolos ni
	 * caracteres numéricos
	 * 
	 * @param autor
	 * @throws NombreNoValidoException
	 */
	public void setAutor(String autor) throws NombreNoValidoException {
		Matcher m = patronAutor.matcher(autor);
		if (m.matches())
			this.autor = autor;
		else
			throw new NombreNoValidoException("nombre invalido");
	}
	/**
	 * 
	 * @return true o false
	 */
	public boolean isColeccion() {
		return coleccion;
	}
	/**
	 * 
	 * @param coleccion
	 */
	public void setColeccion(boolean coleccion) {
		this.coleccion = coleccion;
	}
	/**
	 * 
	 * @return Idioma del libro
	 */
	public IdiomaLibro getIdioma() {
		return idioma;
	}
	/**
	 * 
	 * @param idioma
	 */
	public void setIdioma(IdiomaLibro idioma) {
		this.idioma = idioma;
	}
	/**
	 * Categoria del libro
	 * @return
	 */
	public CategoriaLibro getCategoria() {
		return categoria;
	}
	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(CategoriaLibro categoria) {
		this.categoria = categoria;
	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}

	@Override
	public String toString() {
		return super.toString() + "Libro [paginas=" + paginas + ", fechaPublicacion=" + fechaPublicacion + ", autor="
				+ autor + ", coleccion=" + coleccion + ", idioma=" + idioma + ", categoria=" + categoria + "]";
	}
}
