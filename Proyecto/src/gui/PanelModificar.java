package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import enumeraciones.CategoriaLibro;
import enumeraciones.DificultadCartas;
import enumeraciones.EstadoArticulo;
import enumeraciones.GeneroRol;
import enumeraciones.IdiomaLibro;
import enumeraciones.MaterialRol;
import excepciones.EdadNoValidaException;
import excepciones.FechaNoValidaException;
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
 * Ventana que permite buscar un articulo y modificarlo
 * 
 * @author pablo
 *
 */
public class PanelModificar extends PanelMostrar {


	private static final long serialVersionUID = 1L;

	public PanelModificar(ListIterator<Articulo> iterador) {
		super(iterador);
		habilitarCampos();
		setTitle("Modificar articulo");
		comboBoxTipoArticulo.setEnabled(false);
		btnALaCesta_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarArticulo(articuloMostrado);
					JOptionPane.showMessageDialog(getContentPane(), "Modificado con exito");
				} catch (EdadNoValidaException | FechaNoValidaException | PesoNoValidoException | NumberFormatException
						| PrecioNoValidoException | NombreNoValidoException e1) {
					JOptionPane.showMessageDialog(getContentPane(), e1.getMessage(),"Error al Modificar",JOptionPane.ERROR_MESSAGE);
				}
			}

		});

	}

	/**
	 * Habilita los campos para permitir su modificacion
	 */
	protected void habilitarCampos() {
		textPaginas.setEnabled(true);
		textAutor.setEnabled(true);
		textNombre.setEnabled(true);
		textDescripcion.setEnabled(true);
		textTematica.setEnabled(true);
		textPrecio.setEditable(true);
		textEdicion.setEnabled(true);
		textStock.setEnabled(true);
		textId.setEnabled(false);
		textCartas.setEnabled(true);
		chbxColeccionJuego.setEnabled(true);
		textDimensiones.setEnabled(true);
		textEdad.setEnabled(true);
		textFieldDuracion.setEnabled(true);
		comboBox_Genero.setEnabled(true);
		comboBoxCategoriaLibro.setEnabled(true);
		textPiezas.setEnabled(true);
		textJugadores.setEnabled(true);
		textNumElementos.setEnabled(true);

		btnALaCesta_anadir.setVisible(true);
		btnALaCesta_anadir.setText("Modificar");
		btnSacar_borrar.setVisible(false);
		btnAnterior.setEnabled(false);

		spinnerEntrada.setEnabled(true);
		spinnerPeso.setEnabled(true);
		spinnerPublicacion.setEnabled(true);

		comboBoxEstado.setEnabled(true);
		comboBox_Idioma.setEnabled(true);
		comboBox_Genero.setEnabled(true);
		comboBoxTipoArticulo.setVisible(true);
		comboBoxDificultad.setEnabled(true);
		comboBoxMaterialRol.setEnabled(true);

		checkEnLaCesta.setVisible(true);
		checkColeccion.setEnabled(true);
		checkDesmontable.setEnabled(true);
	}

	/**
	 * Modifica un articulo
	 * 
	 * @param articulo
	 * @throws NumberFormatException
	 * @throws PrecioNoValidoException
	 * @throws FechaNoValidaException
	 * @throws NombreNoValidoException
	 * @throws EdadNoValidaException
	 * @throws PesoNoValidoException
	 */
	protected void modificarArticulo(Articulo articulo) throws NumberFormatException, PrecioNoValidoException,
			FechaNoValidaException, NombreNoValidoException, EdadNoValidaException, PesoNoValidoException {

		if (articulo instanceof Libro) {
			modificarLibro();

		} else if (articulo instanceof Juego) {
			if (articulo instanceof Rol) {
				modificarJuegoRol(articulo);
			} else if (articulo instanceof Cartas) {
				modificarJuegoCartas(articulo);
			} else if (articulo instanceof Tablero) {
				modificarJuegoTablero(articulo);
			}
		} else if (articulo instanceof Figura) {
			modificarFigura(articulo);
		}

	}

	/**
	 * Modifica un articulo de tipo tablero
	 * 
	 * @param articulo
	 * @throws EdadNoValidaException
	 * @throws PrecioNoValidoException
	 * @throws NumberFormatException
	 */
	protected void modificarJuegoTablero(Articulo articulo)
			throws EdadNoValidaException, NumberFormatException, PrecioNoValidoException {
		it.set(new Tablero(textNombre.getText(), textDescripcion.getText(), Double.parseDouble(textPrecio.getText()),
				(EstadoArticulo) comboBoxEstado.getSelectedItem(), readDateSpinner(spinnerEntrada),
				Double.parseDouble(textFieldDuracion.getText()), Integer.parseInt(textEdad.getText()),
				Integer.parseInt(textPiezas.getText()), Integer.parseInt(textJugadores.getText()),
				Integer.parseInt(textJugadores.getText()), checkColeccion.isSelected(),Integer.parseInt(textStock.getText())));

	}

	/**
	 * Modifica un articulo de tipo cartas
	 * 
	 * @param articulo
	 * @throws EdadNoValidaException
	 * @throws PrecioNoValidoException
	 * @throws NumberFormatException
	 */
	protected void modificarJuegoCartas(Articulo articulo)
			throws EdadNoValidaException, NumberFormatException, PrecioNoValidoException {
		it.set(new Cartas(textNombre.getText(), textDescripcion.getText(), Double.parseDouble(textPrecio.getText()),
				(EstadoArticulo) comboBoxEstado.getSelectedItem(), readDateSpinner(spinnerEntrada),
				Double.parseDouble(textFieldDuracion.getText()), Integer.parseInt(textEdad.getText()),
				Integer.parseInt(textCartas.getText()), (DificultadCartas) comboBoxDificultad.getSelectedItem(),
				chckbxColeccion.isSelected(),Integer.parseInt(textStock.getText())));
	}

	/**
	 * Modifica un articulo de tipo rol
	 * 
	 * @param articulo
	 * @throws EdadNoValidaException
	 * @throws PrecioNoValidoException
	 * @throws NumberFormatException
	 */
	protected void modificarJuegoRol(Articulo articulo)
			throws EdadNoValidaException, NumberFormatException, PrecioNoValidoException {
		it.set(new Rol(textNombre.getText(), textDescripcion.getText(), Double.parseDouble(textPrecio.getText()),
				(EstadoArticulo) comboBoxEstado.getSelectedItem(), readDateSpinner(spinnerEntrada),
				Double.parseDouble(textFieldDuracion.getText()), Integer.parseInt(textEdad.getText()),
				(GeneroRol) comboBox_Genero.getSelectedItem(), (MaterialRol) comboBoxMaterialRol.getSelectedItem(),
				Double.parseDouble(textEdicion.getText()),Integer.parseInt(textStock.getText())));

	}

	/**
	 * Modifica un articulo de tipo Figura
	 * 
	 * @param articulo
	 * @throws PesoNoValidoException
	 * @throws PrecioNoValidoException
	 * @throws NumberFormatException
	 */
	protected void modificarFigura(Articulo articulo)
			throws PesoNoValidoException, NumberFormatException, PrecioNoValidoException {
		it.set(new Figura(textNombre.getText(), textDescripcion.getText(), Double.parseDouble(textPrecio.getText()),
				(EstadoArticulo) comboBoxEstado.getSelectedItem(), readDateSpinner(spinnerEntrada),
				(double) spinnerPeso.getValue(), textTematica.getText(), checkDesmontable.isSelected(),
				checkColeccion.isSelected(), (int) textNumElementos.getValue(),Integer.parseInt(textStock.getText())));
	}

	/**
	 * Modifica un articulo de tipo libro
	 * 
	 * @param articulo
	 * @throws FechaNoValidaException
	 * @throws NombreNoValidoException
	 * @throws PrecioNoValidoException 
	 * @throws NumberFormatException 
	 */
	protected void modificarLibro() throws FechaNoValidaException, NombreNoValidoException, NumberFormatException, PrecioNoValidoException {
		it.set(new Libro(textNombre.getText(), textDescripcion.getText(), Double.parseDouble(textPrecio.getText()),
				(EstadoArticulo) comboBoxEstado.getSelectedItem(), readDateSpinner(spinnerEntrada),
				Integer.valueOf(textPaginas.getText()), readDateSpinner(spinnerPublicacion), textAutor.getText(),
				checkColeccion.isSelected(), (IdiomaLibro) comboBox_Idioma.getSelectedItem(),
				(CategoriaLibro) comboBoxCategoriaLibro.getSelectedItem(),Integer.parseInt(textStock.getText())));

	}
}