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

public class PanelModificar extends PanelMostrar {

	public PanelModificar(ListIterator<Articulo> iterador) {
		super(iterador);
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
		textGenero.setEnabled(true);
		textTipo.setEnabled(true);
		textPiezas.setEnabled(true);
		textJugadores.setEnabled(true);
		numElementos.setEnabled(true);

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

		chckbxEnLaCesta.setVisible(true);
		chkbxColeccion.setEnabled(true);
		chckbxDesmontable.setEnabled(true);

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

	protected void modificarJuegoTablero(Articulo articulo) throws EdadNoValidaException {
		try {
			Principal.stock.ModificarTablero(Principal.stock.indexOf(articulo), textNombre.getText(),
						Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
						(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
						readDateSpinner(spinnerEntrada), Double.parseDouble(textFieldDuracion.getText()), 
						Integer.parseInt(textEdad.getText()), Integer.parseInt(textPiezas.getText()), 
						chkbxColeccion.isSelected(), Integer.parseInt(textJugadores.getText()),
						Double.parseDouble(textDimensiones.getText()));
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}
	}

	protected void modificarJuegoCartas(Articulo articulo) throws EdadNoValidaException {
		try {
			Principal.stock.ModificarCartas(Principal.stock.indexOf(articulo), textNombre.getText(),
							Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
							(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
							readDateSpinner(spinnerEntrada), Integer.parseInt(textEdad.getText()),
							Double.parseDouble(textFieldDuracion.getText()), Integer.parseInt(textCartas.getText()),
							(DificultadCartas) comboBoxDificultad.getSelectedItem(), chckbxColeccion.isSelected());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}
		
	}

	protected void modificarJuegoRol(Articulo articulo) throws EdadNoValidaException {
		try {
			Principal.stock.ModificarRol(Principal.stock.indexOf(articulo), textNombre.getText(),
								Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
								(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
								readDateSpinner(spinnerEntrada), Double.parseDouble(textFieldDuracion.getText()),Integer.parseInt(textEdad.getText()),
								 (GeneroRol) comboBox_Genero.getSelectedItem(), 
								(MaterialRol) comboBoxMaterialRol.getSelectedItem(), Double.parseDouble(textEdicion.getText()));
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}
		
	}

	protected void modificarFigura(Articulo articulo) throws PesoNoValidoException {
		try {
			Principal.stock.ModificarFigura(Principal.stock.indexOf(articulo), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), (double) spinnerPeso.getValue(), textTematica.getText(),
					chkbxColeccion.isSelected(), chckbxDesmontable.isSelected(), (int) numElementos.getValue());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}

	protected void modificarLibro(Articulo articulo) throws FechaNoValidaException, NombreNoValidoException {
		try {
			Principal.stock.ModificarLibro(Principal.stock.indexOf(articulo), textNombre.getText(),
					Double.parseDouble(textPrecio.getText()), Integer.parseInt(textStock.getText()),
					(EstadoArticulo) comboBoxEstado.getSelectedItem(), textDetalles.getText(),
					readDateSpinner(spinnerEntrada), Integer.valueOf(textPaginas.getText()),
					readDateSpinner(spinnerPublicacion), textAutor.getText(), chkbxColeccion.isSelected(),
					(IdiomaLibro) comboBox_Idioma.getSelectedItem(),
					(CategoriaLibro) comboBox_Genero.getSelectedItem());
		} catch (NumberFormatException | PrecioNoValidoException e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage());
		}

	}
}