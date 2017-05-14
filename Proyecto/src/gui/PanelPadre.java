package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import enumeraciones.*;
import jerarquia.Articulo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ListIterator;
import java.awt.event.ItemEvent;
import java.awt.GridBagLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import jerarquia.*;

public class PanelPadre extends JFrame {
	// REFACTORIZAR --> SEPARAR POR COMPORTAMIENTO
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelPadre() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("");
		setBounds(100, 100, 732, 541);
		itArticulos = Principal.stock.iterator();
		getContentPane().setLayout(null);
		// Panel General
		{
			panelPrincipal = new JPanel();
			panelPrincipal.setBounds(12, 21, 278, 387);
			getContentPane().add(panelPrincipal);
			panelPrincipal.setLayout(new GridLayout(0, 2, 0, 0));

			lblNombre = new JLabel("Nombre");
			lblNombre.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblNombre);

			textNombre = new JTextField();
			textNombre.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(textNombre);
			textNombre.setColumns(10);

			lblPrecio = new JLabel("Precio");
			lblPrecio.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblPrecio);

			textPrecio = new JTextField();
			textPrecio.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(textPrecio);
			textPrecio.setColumns(10);

			lblDescripcion = new JLabel("Detalles");
			lblDescripcion.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblDescripcion);

			textDetalles = new JTextField();
			textDetalles.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(textDetalles);
			textDetalles.setColumns(10);

			lblEstado = new JLabel("Estado");
			lblEstado.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblEstado);

			comboBoxEstado = new JComboBox();
			comboBoxEstado.setEnabled(false);
			comboBoxEstado.setAlignmentX(Component.RIGHT_ALIGNMENT);
			comboBoxEstado.setModel(new DefaultComboBoxModel(EstadoArticulo.values()));
			panelPrincipal.add(comboBoxEstado);

			lblCantidadStock = new JLabel("Stock");
			lblCantidadStock.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblCantidadStock);

			textStock = new JTextField();
			textStock.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(textStock);
			textStock.setColumns(10);

			lblFechaEntrada = new JLabel("Entrada");
			lblFechaEntrada.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblFechaEntrada);

			SpinnerModel model1 = new SpinnerDateModel();
			spinnerEntrada = new JSpinner(model1);
			spinnerEntrada.setEnabled(false);
			spinnerEntrada.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(spinnerEntrada);

			lblNProducto = new JLabel("num Prod.");
			lblNProducto.setAlignmentX(Component.RIGHT_ALIGNMENT);
			panelPrincipal.add(lblNProducto);

			textId = new JTextField();
			textId.setAlignmentX(Component.RIGHT_ALIGNMENT);
			textId.setEditable(false);
			panelPrincipal.add(textId);
			textId.setColumns(10);

			JLabel label = new JLabel("");
			panelPrincipal.add(label);
		}

		// PANEL LIBRO
		{
			panelLibro = new JPanel();
			panelLibro.setBounds(398, 21, 306, 387);
			getContentPane().add(panelLibro);
			panelLibro.setLayout(new GridLayout(0, 2, 0, 0));
			lblPaginas = new JLabel("Paginas");
			panelLibro.add(lblPaginas);
			textPaginas = new JTextField();
			panelLibro.add(textPaginas);
			textPaginas.setColumns(10);
			lblPublicacion = new JLabel("Publicacion");
			panelLibro.add(lblPublicacion);
			spmodel = new SpinnerDateModel();
			spinnerPublicacion = new JSpinner(spmodel);
			JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerPublicacion, "dd-MM-yyyy");
			spinnerPublicacion.setEditor(dateEditor);
			panelLibro.add(spinnerPublicacion);
			lblAutor = new JLabel("Autor");
			panelLibro.add(lblAutor);
			textAutor = new JTextField();
			panelLibro.add(textAutor);
			textAutor.setColumns(10);
			lblGenero = new JLabel("Genero");
			panelLibro.add(lblGenero);
			comboBox_Genero = new JComboBox();
			comboBox_Genero.setModel(new DefaultComboBoxModel(CategoriaLibro.values()));
			panelLibro.add(comboBox_Genero);
			textColeccion = new JTextField();
			textColeccion.setVisible(false);
			textColeccion.setEnabled(false);
			panelLibro.add(textColeccion);
			textColeccion.setEditable(false);
			textColeccion.setColumns(10);
			JCheckBox chckbxColeccion = new JCheckBox("Coleccion");
			panelLibro.add(chckbxColeccion);
			lblIdioma = new JLabel("Idioma");
			panelLibro.add(lblIdioma);
			comboBox_Idioma = new JComboBox();
			comboBox_Idioma.setModel(new DefaultComboBoxModel(IdiomaLibro.values()));
			panelLibro.add(comboBox_Idioma);
			lblTipo = new JLabel("Tipo");
			panelLibro.add(lblTipo);
			textTipo = new JTextField();
			panelLibro.add(textTipo);
			textTipo.setColumns(10);
			labelEspaciador = new JLabel("");
			panelLibro.add(labelEspaciador);
		}
		// PANEL JUEGO
		{
			panelJuego = new JPanel();
			panelJuego.setBounds(398, 21, 306, 387);
			getContentPane().add(panelJuego);
			panelJuego.setLayout(new GridLayout(0, 2, 0, 0));

			lblDuracionJuego = new JLabel("Duracion");
			panelJuego.add(lblDuracionJuego);

			textFieldDuracion = new JTextField();
			panelJuego.add(textFieldDuracion);
			textFieldDuracion.setText("");
			textFieldDuracion.setColumns(10);

			lblEdad = new JLabel("Edad");
			panelJuego.add(lblEdad);

			textEdad = new JTextField();
			panelJuego.add(textEdad);
			textEdad.setColumns(10);

			lblPiezas = new JLabel("Piezas");
			panelJuego.add(lblPiezas);

			textPiezas = new JTextField();
			panelJuego.add(textPiezas);
			textPiezas.setColumns(10);

			lblDimensiones = new JLabel("Dimensiones");
			panelJuego.add(lblDimensiones);

			textDimensiones = new JTextField();
			textDimensiones.setText("");
			panelJuego.add(textDimensiones);
			textDimensiones.setColumns(10);

			lblJugadores = new JLabel("Jugadores");
			panelJuego.add(lblJugadores);

			textJugadores = new JTextField();
			textJugadores.setText("");
			panelJuego.add(textJugadores);
			textJugadores.setColumns(10);

			lblColeccionJuego = new JLabel("Coleccion");
			panelJuego.add(lblColeccionJuego);

			textColeccionJuego = new JTextField();
			panelJuego.add(textColeccionJuego);
			textColeccionJuego.setColumns(10);

			lblCartas = new JLabel("Cartas");
			panelJuego.add(lblCartas);

			textCartas = new JTextField();
			panelJuego.add(textCartas);
			textCartas.setColumns(10);

			lblDificultad = new JLabel("Dificultad");
			panelJuego.add(lblDificultad);

			comboBoxDificultad = new JComboBox();
			comboBoxDificultad.setModel(new DefaultComboBoxModel(DificultadCartas.values()));
			panelJuego.add(comboBoxDificultad);

			lblGeneroRol = new JLabel("Genero");
			panelJuego.add(lblGeneroRol);

			textGenero = new JTextField();
			panelJuego.add(textGenero);
			textGenero.setColumns(10);

			lblMaterial = new JLabel("Material");
			panelJuego.add(lblMaterial);

			comboBoxMaterialRol = new JComboBox();
			comboBoxMaterialRol.setModel(new DefaultComboBoxModel(MaterialRol.values()));
			panelJuego.add(comboBoxMaterialRol);

			lblEdicion = new JLabel("Edicion");
			panelJuego.add(lblEdicion);

			textEdicion = new JTextField();
			panelJuego.add(textEdicion);
			textEdicion.setColumns(10);
		}
		// PANEL FIGURA
		{
			panelFigura = new JPanel();
			panelFigura.setBounds(398, 21, 306, 387);
			getContentPane().add(panelFigura);
			panelFigura.setLayout(new GridLayout(8, 2, 0, 0));
			lblPeso = new JLabel("Peso");
			panelFigura.add(lblPeso);
			spinnerPeso = new JSpinner();
			spinnerPeso.setModel(new SpinnerNumberModel(new Double(1), null, null, new Double(0.1)));
			panelFigura.add(spinnerPeso);
			JLabel lblTematica = new JLabel("Tematica");
			panelFigura.add(lblTematica);
			textTematica = new JTextField();
			panelFigura.add(textTematica);
			textTematica.setColumns(10);
			JLabel label = new JLabel("");
			panelFigura.add(label);
			chkbxColeccion = new JCheckBox("Coleccion");
			chkbxColeccion.setEnabled(true);
			chkbxColeccion.setSelected(false);
			panelFigura.add(chkbxColeccion);
			JLabel lblDesmontable = new JLabel("Desmontable");
			panelFigura.add(lblDesmontable);
			chckbxDesmontable = new JCheckBox("yes/no");
			panelFigura.add(chckbxDesmontable);
			JLabel lblNumElementos = new JLabel("Num Elementos");
			panelFigura.add(lblNumElementos);

			numElementos = new JSpinner();
			numElementos.setModel(new SpinnerNumberModel(new Integer(113), null, null, new Integer(1)));
			panelFigura.add(numElementos);
		}
		// Botones de Acción (Desplazamiento, aceptar, salir, incluir en cesta,
		// tipo articulo)
		{
			btnAnterior = new JButton("Anterior");
			buttonGroup.add(btnAnterior);
			btnAnterior.setBounds(12, 471, 117, 25);
			getContentPane().add(btnAnterior);

			btnALaCesta_anadir = new JButton("A la cesta");
			buttonGroup.add(btnALaCesta_anadir);
			btnALaCesta_anadir.setBounds(150, 471, 117, 25);
			getContentPane().add(btnALaCesta_anadir);

			btnSacar_borrar = new JButton("Sacar");
			buttonGroup.add(btnSacar_borrar);
			btnSacar_borrar.setBounds(437, 471, 117, 25);
			getContentPane().add(btnSacar_borrar);

			btnSiguiente = new JButton("Siguiente");
			buttonGroup.add(btnSiguiente);
			btnSiguiente.setBounds(566, 471, 117, 25);
			getContentPane().add(btnSiguiente);
			chckbxEnLaCesta = new JCheckBox("En la cesta");
			chckbxEnLaCesta.setEnabled(false);
			chckbxEnLaCesta.setBounds(166, 440, 124, 23);
			getContentPane().add(chckbxEnLaCesta);
			// boton siguiente
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					avanzar();
				}

			});
			// boton anterior
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					retroceder();
				}

			});

			// combobox tipo de articulo
			comboBoxTipoArticulo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					identifyArticle();
				}
			});
			comboBoxTipoArticulo.setBounds(279, 471, 139, 25);
			getContentPane().add(comboBoxTipoArticulo);
			comboBoxTipoArticulo.setModel(new DefaultComboBoxModel(new String[] { "Libro", "Figura", "Juego" }));
			comboBoxTipoArticulo.setSelectedIndex(1);

			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnSalir.setBounds(289, 504, 117, 25);
			getContentPane().add(btnSalir);
		}
		panelButtons = new JPanel();
		panelButtons.setBounds(398, 415, 296, 44);
		getContentPane().add(panelButtons);
		panelButtons.setLayout(null);

		rdbtnCartas = new JRadioButton("Cartas");
		bgJuegos.add(rdbtnCartas);
		rdbtnCartas.setBounds(0, 13, 84, 23);
		panelButtons.add(rdbtnCartas);

		rdbtnTablero = new JRadioButton("Tablero");
		bgJuegos.add(rdbtnTablero);
		rdbtnTablero.setBounds(88, 13, 113, 23);
		panelButtons.add(rdbtnTablero);

		rdbtnRol = new JRadioButton("Rol");
		bgJuegos.add(rdbtnRol);
		rdbtnRol.setBounds(205, 13, 83, 23);
		panelButtons.add(rdbtnRol);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { lblNombre, textNombre, lblPrecio, textPrecio, lblDescripcion, textDetalles, lblEstado,
						lblCantidadStock, textStock, lblFechaEntrada, lblNProducto }));
	}

	/**
	 * Retrocede en el stock
	 */
	protected void retroceder() {

		mostrarArticulo(itArticulos.previous());
		if (itArticulos.hasNext()) {
			btnSiguiente.setEnabled(true);
		} else {
			btnSiguiente.setEnabled(false);
		}
		if (itArticulos.hasPrevious()) {
			btnAnterior.setEnabled(true);
		} else {
			btnAnterior.setEnabled(false);
			itArticulos.next();

		}
	}

	/**
	 * Avanza en el stock
	 */
	protected void avanzar() {
		mostrarArticulo(itArticulos.next());
		if (itArticulos.hasNext()) {
			btnSiguiente.setEnabled(true);
		} else {
			btnSiguiente.setEnabled(false);
			itArticulos.previous();
		}
		if (itArticulos.hasPrevious()) {
			btnAnterior.setEnabled(true);
		} else {
			btnAnterior.setEnabled(false);
		}

	}

	/**
	 * Muestra en la ventana el articulo
	 * 
	 * @param articulo
	 */
	private void mostrarArticulo(Articulo articulo) {
		comboBoxEstado.setSelectedItem(articulo.getEstado());
		textStock.setText(Integer.toString(articulo.getCantidad()));
		textDetalles.setText(articulo.getDescripcion());
		textNombre.setText(articulo.getNombre());
		textPrecio.setText(Double.toString(articulo.getPrecio()));
		textId.setText(Integer.toString(articulo.getId()));
		selectPanels(articulo);

	}
	/**
	 * Muestra el panel secundario oportuno y rellena el contenido
	 * @param articulo
	 */
	private void selectPanels(Articulo articulo) {
		if (articulo instanceof Libro) {
			panelButtons.setVisible(false);
			mostrarPanelLibro();
			textPaginas.setText((String.valueOf(((Libro) (articulo)).getPaginas())));
			//Buscar la manera de volcar la fecha en el spinner
			//spinnerPublicacion.setValue((LocalDate)((Libro) (articulo)).getFechaPublicacion());
			spinnerPublicacion = devolverSpinner(((Libro)(articulo)).getFecha());
			textAutor.setText(((Libro) (articulo)).getAutor());
			chkbxColeccion.setSelected(((Libro) (articulo)).isColeccion());
			comboBox_Idioma.setSelectedItem((((Libro) (articulo)).getIdioma()));
			comboBox_Genero.setSelectedItem((((Libro) (articulo)).getCategoria()));
		} else if (articulo instanceof Juego) {
			mostrarPanelJuego();
			if (articulo instanceof Rol) {
				rdbtnRol.setSelected(true);
			} else if (articulo instanceof Cartas) {
				rdbtnCartas.setSelected(true);
			} else if (articulo instanceof Tablero) {
				rdbtnTablero.setSelected(true);
			}
		} else if (articulo instanceof Figura) {
			panelButtons.setVisible(false);
			mostrarPanelFiguras();
			textTematica.setText(((Figura) (articulo)).getTematica());
			chckbxDesmontable.setSelected(((Figura) (articulo)).isDesmontable());
			chkbxColeccion.setSelected(((Figura) (articulo)).isColeccion());
			numElementos.setValue((((Figura) (articulo)).getNum_elementos()));
		}
	}

	protected void mostrarPanelLibro() {
		panelLibro.setVisible(true);
		panelJuego.setVisible(false);
		panelFigura.setVisible(false);
	}

	protected void mostrarPanelJuego() {
		panelJuego.setVisible(true);
		panelLibro.setVisible(false);
		panelFigura.setVisible(false);
	}

	protected void mostrarPanelFiguras() {
		panelFigura.setVisible(true);
		panelLibro.setVisible(false);
		panelJuego.setVisible(false);
	}

	/**
	 * Oculta el panel secundario, correspondiente a los campos particulares de
	 * cada tipo de artículo
	 */
	public void cleanRightPanel() {
		panelFigura.setVisible(false);
		panelJuego.setVisible(false);
		panelLibro.setVisible(false);
	}

	/**
	 * Identifica el tipo de Articulo y en respuesta muestra el panel
	 * correspondiente
	 */
	public void identifyArticle() {
		if (comboBoxTipoArticulo.getSelectedItem() == "Libro") {
			panelLibro.setVisible(true);
			panelFigura.setVisible(false);
			panelJuego.setVisible(false);
		} else if (comboBoxTipoArticulo.getSelectedItem() == "Figura") {
			panelLibro.setVisible(false);
			panelFigura.setVisible(true);
			panelJuego.setVisible(false);
		} else {
			panelButtons.setVisible(true);
			rdbtnCartas.setSelected(true);
			panelLibro.setVisible(false);
			panelFigura.setVisible(false);
			panelJuego.setVisible(true);
		}
	}

	/**
	 * Recoge la fecha en formato LocalDate del spinner
	 * 
	 * @param sp
	 * @return
	 */
	public LocalDate leerFecha(JSpinner sp) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) sp.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}
	public JSpinner devolverSpinner(LocalDate ld){
		 SpinnerDateModel model = new SpinnerDateModel();
	        JSpinner spinner = new JSpinner(model);
	        Calendar calendar = new GregorianCalendar(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
	        spinner.setValue(calendar.getTime());
	        return spinner;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	private final JPanel contentPanel = new JPanel();
	protected JTextField textNombre;
	protected JTextField textPrecio;
	protected JTextField textDetalles;
	protected JTextField textStock;
	protected JTextField textId;
	protected JTextField textPaginas;
	protected JTextField textAutor;
	protected JTextField textColeccion;
	protected JTextField textTipo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JButton btnSiguiente;
	protected JButton btnSacar_borrar;
	protected JButton btnALaCesta_anadir;
	protected JButton btnAnterior;
	protected JTextField textFieldDuracion;
	protected JLabel lblEdad;
	protected JTextField textEdad;
	protected JLabel lblNombre;
	protected JLabel lblPrecio;
	protected JLabel lblDescripcion;
	protected JLabel lblEstado;
	protected JLabel lblCantidadStock;
	protected JLabel lblFechaEntrada;
	protected JLabel lblNProducto;
	protected JLabel lblPaginas;
	protected JLabel lblPublicacion;
	protected JLabel lblAutor;
	protected JLabel lblGenero;
	protected JLabel lblIdioma;
	protected JLabel lblTipo;
	protected JLabel lblDuracionJuego;
	protected JPanel panelPrincipal;
	protected JPanel panelLibro;
	protected JComboBox comboBoxEstado;
	protected JComboBox comboBox_Genero;
	protected JComboBox comboBox_Idioma;
	protected int posicion;
	protected JPanel panelJuego;
	protected JPanel panelFigura;
	protected JLabel lblPiezas;
	protected JTextField textPiezas;
	protected JLabel lblDimensiones;
	protected JTextField textDimensiones;
	protected JTextField textJugadores;
	protected JTextField textColeccionJuego;
	protected JTextField textCartas;
	JComboBox comboBoxDificultad;
	protected JTextField textGenero;
	JLabel lblEdicion;
	JTextField textEdicion;
	JSpinner spinnerEntrada;
	JComboBox comboBoxTipoArticulo = new JComboBox();
	JCheckBox chckbxEnLaCesta;

	JComboBox comboBoxMaterialRol;
	JLabel lblMaterial;
	JLabel lblGeneroRol;
	JLabel lblDificultad;
	JLabel lblCartas;
	JLabel lblColeccionJuego;
	JLabel lblJugadores;
	JLabel labelEspaciador;
	SpinnerModel spmodel;
	JSpinner spinnerPublicacion;
	JLabel lblPeso;
	JTextField textTematica;
	JCheckBox chkbxColeccion;
	JSpinner spinnerPeso;
	JCheckBox chckbxDesmontable;
	final ButtonGroup bgJuegos = new ButtonGroup();
	JRadioButton rdbtnCartas;
	JRadioButton rdbtnTablero;
	JRadioButton rdbtnRol;
	JPanel panelButtons;
	ListIterator<Articulo> itArticulos;
	JSpinner numElementos;
}
