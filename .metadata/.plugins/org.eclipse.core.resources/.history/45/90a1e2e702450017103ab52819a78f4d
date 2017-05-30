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

	public PanelModificar(ListIterator<Articulo> iterador) {
		super(iterador);
		habilitarCampos();
		setTitle("Modificar articulo");
		btnALaCesta_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarArticulo(articuloMostrado);
					JOptionPane.showMessageDialog(getContentPane(), "Modificado con exito");
				} catch (EdadNoValidaException | FechaNoValidaException | PesoNoValidoException | NumberFormatException
						| PrecioNoValidoException | NombreNoValidoException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "No se ha podido modificar");
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
		textDetalles.setEnabled(true);
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
			modificarLibro(articulo);

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
	 */
	protected void modificarJuegoTablero(Articulo articulo) throws EdadNoValidaException {
		Tablero tablero = (Tablero) articulo;
		try {
			Principal.stock.ModificarTablero(Principal.stock.indexOf(tablero), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), Double.parseDouble(textFieldDuracion.getText()),
					Integer.parseInt(textEdad.getText()), Integer.parseInt(textPiezas.getText()),
					checkColeccion.isSelected(), Integer.parseInt(textJugadores.getText()),
					Double.parseDouble(textDimensiones.getText()));
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}
	}

	/**
	 * Modifica un articulo de tipo cartas
	 * 
	 * @param articulo
	 * @throws EdadNoValidaException
	 */
	protected void modificarJuegoCartas(Articulo articulo) throws EdadNoValidaException {
		Cartas cartas = (Cartas) articulo;
		try {
			Principal.stock.ModificarCartas(Principal.stock.indexOf(cartas), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), Integer.parseInt(textEdad.getText()),
					Double.parseDouble(textFieldDuracion.getText()), Integer.parseInt(textCartas.getText()),
					(DificultadCartas) comboBoxDificultad.getSelectedItem(), chckbxColeccion.isSelected());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}

	/**
	 * Modifica un articulo de tipo rol
	 * 
	 * @param articulo
	 * @throws EdadNoValidaException
	 */
	protected void modificarJuegoRol(Articulo articulo) throws EdadNoValidaException {
		Rol rol = (Rol) articulo;
		try {
			Principal.stock.ModificarRol(Principal.stock.indexOf(rol), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), Double.parseDouble(textFieldDuracion.getText()),
					Integer.parseInt(textEdad.getText()), (GeneroRol) comboBox_Genero.getSelectedItem(),
					(MaterialRol) comboBoxMaterialRol.getSelectedItem(), Double.parseDouble(textEdicion.getText()));
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}

	/**
	 * Modifica un articulo de tipo Figura
	 * 
	 * @param articulo
	 * @throws PesoNoValidoException
	 */
	protected void modificarFigura(Articulo articulo) throws PesoNoValidoException {
		Figura figura = (Figura) articulo;
		try {
			Principal.stock.ModificarFigura(Principal.stock.indexOf(figura), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), (double) spinnerPeso.getValue(), textTematica.getText(),
					checkColeccion.isSelected(), checkDesmontable.isSelected(), (int) textNumElementos.getValue());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}

	/**
	 * Modifica un articulo de tipo libro
	 * 
	 * @param articulo
	 * @throws FechaNoValidaException
	 * @throws NombreNoValidoException
	 */
	protected void modificarLibro(Articulo articulo) throws FechaNoValidaException, NombreNoValidoException {
		Libro libro = (Libro) articulo;
		try {
			Principal.stock.ModificarLibro(Principal.stock.indexOf(libro), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), Integer.valueOf(textPaginas.getText()),
					readDateSpinner(spinnerPublicacion), textAutor.getText(), checkColeccion.isSelected(),
					(IdiomaLibro) comboBox_Idioma.getSelectedItem(),
					(CategoriaLibro) comboBox_Genero.getSelectedItem());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}
}