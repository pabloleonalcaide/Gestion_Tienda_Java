package gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

import ficheros.Fichero;
import ficheros.Filtro; //Nuestra clase que maneja el filtro para la extension de los ficheros
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import java.awt.event.ActionListener;
import java.awt.Color;

import stock.Stock;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
//REFACTORIZAR --> COMPORTAMIENTO, ESTADO
//CORREGIR LOS ESPACIOS EN LA BARRA DE MENU

public class Principal {
	public static JFrame framePrincipal;
	public static Stock stock = new Stock();
	public static PanelAnadir anadir;
	Filtro filtro = new Filtro(".obj", "obj");
	protected static JMenuBar menuEmpleado;
	protected static JMenuBar menuUsuario;
	protected JButton btnWeb;
	protected JFileChooser fileChooser = new JFileChooser();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida bienvenida = new Bienvenida();
					Principal window = new Principal();
					window.framePrincipal.setVisible(false);
					cargarCatalogo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		initialize();
	}

	private void initialize() {
		framePrincipal = new JFrame();
		framePrincipal
				.setTitle("Developer's Dungeon - May the force be with Unix");
		framePrincipal.getContentPane().setBackground(Color.LIGHT_GRAY);
		framePrincipal.setBackground(Color.LIGHT_GRAY);
		framePrincipal.setBounds(100, 100, 473, 300);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.getContentPane().setLayout(null);

		menuUsuario = new JMenuBar();
		menuUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		menuUsuario.setBackground(Color.LIGHT_GRAY);
		menuUsuario
				.setToolTipText("Bienvenido a la Mazmorra del Desarrollador");
		menuUsuario.setBounds(0, 0, 461, 21);
		framePrincipal.getContentPane().add(menuUsuario);

		JMenu mnOfertas = new JMenu("Ofertas");
		mnOfertas.setToolTipText("Revisa las ofertas");
		mnOfertas.setBackground(Color.LIGHT_GRAY);
		mnOfertas.setMnemonic('O');
		menuUsuario.add(mnOfertas);

		JMenuItem mntmTodasOfertas = new JMenuItem("Todas las ofertas");
		mntmTodasOfertas.setToolTipText("Nuevo");
		mntmTodasOfertas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				InputEvent.CTRL_MASK));
		mntmTodasOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stock.isEmpty()) {
					msjEmptyStock();
				} else {
					// DialogOferta ofertas = new DialogOferta();
					// ofertas.setVisible(true);
				}
			}

		});
		mnOfertas.add(mntmTodasOfertas);

		JMenuItem mntmCategoriasOfertas = new JMenuItem("Ofertas por Categoria");
		mntmCategoriasOfertas
				.setToolTipText("Comprueba las ofertas por categoria");
		mntmCategoriasOfertas.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmCategoriasOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stock.isEmpty()) {
					msjEmptyStock();
				} else {
					// DialogOpcionesMostrar mostrarOfertas =new
					// DialogOpcionesMostrar();
					// mostrarOfertas.setVisible(true);
				}
			}
		});
		mnOfertas.add(mntmCategoriasOfertas);

		JMenu mnArticulos = new JMenu("Articulos");
		mnArticulos.setMnemonic('C');
		mnArticulos.setBackground(Color.LIGHT_GRAY);
		mnArticulos.setToolTipText("Go Shopping");
		menuUsuario.add(mnArticulos);

		JMenuItem mntmMostrarPrecio = new JMenuItem("Ordenar por Precio");
		mntmMostrarPrecio.setToolTipText("Ordenar por precio");
		mntmMostrarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelMostrar ordenaPrecio = new PanelMostrar();
				ordenaPrecio.setVisible(true);

			}
		});
		mntmMostrarPrecio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));
		mnArticulos.add(mntmMostrarPrecio);

		JMenuItem mntmMostrarNombre = new JMenuItem("Ordenar por Nombre");
		mntmMostrarNombre.setToolTipText("Ordenar por Nombre");
		mntmMostrarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (stock.isEmpty())
					msjEmptyStock();
				else {
					PanelMostrar ordenaNombre = new PanelMostrar();
					ordenaNombre.setVisible(true);
				}
			}
		});
		mntmMostrarNombre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArticulos.add(mntmMostrarNombre);

		JMenuItem mntmMostrarCategoria = new JMenuItem("Mostrar por Categoria");
		mntmMostrarCategoria.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmMostrarCategoria.setToolTipText("muestra por categoria");
		mntmMostrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnArticulos.add(mntmMostrarCategoria);

		JMenu mnCesta = new JMenu("Cesta");
		mnCesta.setMnemonic('T');
		mnCesta.setBackground(Color.LIGHT_GRAY);
		mnCesta.setToolTipText("Revisa tu cesta");
		menuUsuario.add(mnCesta);

		JMenuItem mntmVaciarCesta = new JMenuItem("Vaciar");
		mntmVaciarCesta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		mntmVaciarCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stock.isBasketEmpty()) {
					JOptionPane
							.showMessageDialog(
									null,
									"No has seleccionado nada para la cesta\n vuelve cuando hayas elegido",
									"Esta Vacia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnCesta.add(mntmVaciarCesta);

		JMenuItem mntmPorColor = new JMenuItem("Mostrar");
		mntmPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stock.isBasketEmpty()) {
					JOptionPane
							.showMessageDialog(
									null,
									"No has seleccionado nada para la cesta\n vuelve cuando hayas elegido",
									"Esta Vacia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnCesta.add(mntmPorColor);

		JMenu mnAyuda_1 = new JMenu("Ayuda");
		mnAyuda_1.setToolTipText("necesitas ayuda?");
		mnAyuda_1.setMnemonic('Y');
		mnAyuda_1.setBackground(Color.LIGHT_GRAY);
		menuUsuario.add(mnAyuda_1);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe about = new AcercaDe();
				about.setVisible(true);
			}
		});
		mnAyuda_1.add(mntmAcercaDe);
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda_1.add(mntmAyuda);

		JMenuItem menuFormulario = new JMenuItem("Formulario de Contacto");
		menuFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formulario formulario = new Formulario();
				formulario.setVisible(true);
			}
		});
		menuFormulario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
				InputEvent.CTRL_MASK));
		mnAyuda_1.add(menuFormulario);

		JMenu mnCatalogo = new JMenu("Catalogo");
		mnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Descarga el catalogo (ArrayList) en un documento txt
				descargaCatalogo();
			}
		});
		menuUsuario.add(mnCatalogo);

		menuEmpleado = new JMenuBar();
		menuEmpleado.setBounds(10, 0, 461, 21);
		framePrincipal.getContentPane().add(menuEmpleado);

		JMenu mnGestinArticulos = new JMenu("Gestion Articulos");
		mnGestinArticulos.setMnemonic('G');
		menuEmpleado.add(mnGestinArticulos);

		JMenuItem mntmAadirNuevo = new JMenuItem("Incluir nuevo");
		mntmAadirNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadir = new PanelAnadir();
				anadir.setVisible(true);
			}
		});
		mnGestinArticulos.add(mntmAadirNuevo);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelEliminar delete = new PanelEliminar();
				delete.setVisible(true);
			}
		});
		mnGestinArticulos.add(mntmEliminar);

		JMenuItem mntmBuscarYEliminar = new JMenuItem("Buscar y Eliminar");
		mntmBuscarYEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarEliminar be = new BuscarEliminar();
				be.setVisible(true);
			}
		});
		mnGestinArticulos.add(mntmBuscarYEliminar);

		JMenuItem mntmActualizarExistencias = new JMenuItem(
				"Actualizar existencias");
		mntmActualizarExistencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,
						"Aumentaremos todas las existencias\nEstas seguro?",
						"Reponer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					stock.replenishAll();
				}
			}
		});
		mnGestinArticulos.add(mntmActualizarExistencias);

		JMenu mnPedidos = new JMenu("Pedidos");
		mnPedidos.setMnemonic('P');
		menuEmpleado.add(mnPedidos);

		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mnPedidos.add(mntmMostrar);

		JMenu mnCambiarDestacados = new JMenu("Cambiar Destacados");
		mnCambiarDestacados.setMnemonic('C');
		mnCambiarDestacados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		menuEmpleado.add(mnCambiarDestacados);

		JMenu mnBbdd = new JMenu("Archivo");
		mnBbdd.setMnemonic('A');
		menuEmpleado.add(mnBbdd);

		JMenuItem mntmGuardarcambios = new JMenuItem("Guardar Cambios");
		mntmGuardarcambios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.CTRL_MASK));
		mntmGuardarcambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarCopiaComo();
			}
		});
		mnBbdd.add(mntmGuardarcambios);

		JMenuItem mntmAbrir = new JMenuItem("Abrir Copia");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recuperarCopia();
			}
		});
		mnBbdd.add(mntmAbrir);

		btnWeb = new JButton("Vista web");
		btnWeb.setBounds(166, 219, 120, 19);
		framePrincipal.getContentPane().add(btnWeb);
		btnWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuUsuario.setVisible(true);
				menuEmpleado.setVisible(false);
				btnWeb.setVisible(false);
			}
		});

	}

	// guarda el stock en un txt, pero solo los datos para clientes.
	protected void descargaCatalogo() {

	}

	/**
	 * Guarda una copia del stock actual
	 */
	protected void guardarCopiaComo() {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);

		if (JFileChooser.APPROVE_OPTION == fileChooser.showDialog(fileChooser,
				"Guardar Archivo")) {
			fileChooser.setAcceptAllFileFilterUsed(false);
			Fichero.checkFile(fileChooser.getSelectedFile());
			if (Fichero.getFichero().exists()) {
				Object[] options = { "Si", "No" };
				int option = JOptionPane
						.showOptionDialog(
								null,
								"El archivo indicado ya existe, ¿Desea Sobreescribirlo?",
								"Guardando", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
				if (option == JOptionPane.YES_OPTION) {
					try {
						Fichero.saveAs(stock, Fichero.getFichero());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null,
								"Error al guardar el archivo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"No se ha podido guardar", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				save();
			}

		}

	}
	/**
	 * Guarda el stock en un fichero
	 */
	protected void save() {
		if (Fichero.fichero.getName().equalsIgnoreCase("")) {
			guardarCopiaComo();
		} else {
			try {
				Fichero.save(stock);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,
						"Hay problemas para guardar el fichero", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Abre un inventario anterior
	 */
	protected void recuperarCopia() {
		try {
			openFileChooser();
		} catch (IOException | ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null,
					"Hay problemas para abrir el fichero", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			Fichero.newFile();
		}

	}

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void openFileChooser() throws FileNotFoundException,
			ClassNotFoundException, IOException {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(filtro);
		if (fileChooser.showDialog(fileChooser, "Abrir Fichero") == JFileChooser.APPROVE_OPTION) {
			Fichero.fichero = fileChooser.getSelectedFile();
			stock = (Stock) Fichero.open(fileChooser.getSelectedFile());
			JOptionPane.showMessageDialog(null, "Cargado con exito");
		}
	}

	/**
	 * Panel de stock vacio --> ¿metodo o desde el evento?
	 */
	private void msjEmptyStock() {
		JOptionPane.showMessageDialog(null,
				"No hay articulos,\n espera a renovar el stock");
	}

	// CARGA UN ARRAYLIST INICIAL DE ARTICULOS
	protected static void cargarCatalogo() {

	}
}