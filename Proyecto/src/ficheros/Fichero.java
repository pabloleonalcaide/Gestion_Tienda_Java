package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Pattern;
/**
 * Clase que gestiona el manejo de ficheros
 * @author pablo
 *
 */
//DEBERIA CREAR OTRA CLASE FICHERO PARA GUARDAR FICHEROS TXT O EN ESTA MISMA?
public class Fichero implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Pattern patron = Pattern.compile("^((\\w)+(\\.obj))$");
	public static File fichero = new File("SinTitulo");

	/**
	 * @param fichero
	 */
	public static void setFichero(String fichero) {
		if (fichero==null)
			fichero="SinTitulo";
		Fichero.fichero = new File(fichero);
	}

	/**
	 * @return
	 */
	public static File getFichero() {
		return fichero;
	}
	/**
	 * Crear un nuevo fichero
	 */
	public static void newFile(){
		setFichero("SinTitulo.obj");
	}

	/**
	 * Guarda el fichero preguntando previamente donde y con que nombre
	 * 
	 * @param objeto
	 * @param nombre
	 * @throws IOException
	 */
	public static void saveAs(Object objeto, File nombre) throws IOException {
		fichero = checkFile(nombre);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
			out.writeObject(objeto);
		}
	}

	/**
	 * guarda el fichero en la misma ubicacion y bajo el mismo nombre
	 * 
	 * @param objeto
	 * @throws IOException
	 */
	public static void save(Object objeto) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
			out.writeObject(objeto);
		}
	}

	/**
	 * abre un concesionario previamente guardado
	 * 
	 * @param archivo
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object open(File archivo) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
			return in.readObject();
		}
	}

	/**
	 * Comprueba que el nombre del fichero cumple el patr�n establecido y le a�ade la extension elegida (.obj)
	 * 
	 * @param fichero2
	 * @return
	 */
	public static File checkFile(File ficheroUsuario) {
		if (patron.matcher(ficheroUsuario.getName()).matches()) {
			return ficheroUsuario;
		} else {
			setFichero(ficheroUsuario.getAbsolutePath() + ".obj");
			return fichero;
		}

	}
	}


