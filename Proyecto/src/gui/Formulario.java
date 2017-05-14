package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.NombreNoValidoException;
import ficheros.Fichero;
import ficheros.Filtro;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Formulario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField formNombre;
	private JTextField formApellidos;
	private JTextField formEmail;
	private JComboBox comboBoxFormulario;
	private JTextArea textArea;
	private JLabel lblFichero;
	private Filtro filtroInput = new Filtro("pdf","pdf");
	private Filtro filtroOutput = new Filtro ("txt","txt");
	// ------------->> INTRODUCIR CAMBIO DE COLOR CUANDO EL CAMPO ES INCORRECTO 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Formulario dialog = new Formulario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Formulario() {
		setResizable(false);
		setModal(true);
		setTitle("Formulario de Contacto");
		setBounds(100, 100, 487, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre*");
			lblNombre.setBounds(24, -4, 146, 31);
			contentPanel.add(lblNombre);
		}
		{
			formNombre = new JTextField();
			formNombre.setBounds(217, 8, 197, 31);
			contentPanel.add(formNombre);
			formNombre.setColumns(10);
			formNombre.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!nombreValido()) {
						formNombre.setForeground(java.awt.Color.red);//si no es valida, se lo indicamos en rojo
						formNombre.setText(formNombre.getText());
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					formNombre.setForeground(java.awt.Color.black);
					formNombre.setText("");//una vez regresa, vuelve a ponerse negro
				}
			});
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setBounds(24, 27, 146, 31);
			contentPanel.add(lblApellidos);
		}
		{
			formApellidos = new JTextField();
			formApellidos.setBounds(217, 39, 197, 31);
			contentPanel.add(formApellidos);
			formApellidos.setColumns(6);
		}
		{
			JLabel lblDireccionEmail = new JLabel("Direccion Email*");
			lblDireccionEmail.setBounds(24, 58, 146, 31);
			contentPanel.add(lblDireccionEmail);
		}
		{
			formEmail = new JTextField();
			formEmail.setBounds(217, 70, 197, 31);
			contentPanel.add(formEmail);
			formEmail.setColumns(6);
			formEmail.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!emailValido()) {
						formEmail.setForeground(java.awt.Color.red);//si no es valida, se lo indicamos en rojo
						formEmail.setText(formEmail.getText());
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					formEmail.setForeground(java.awt.Color.black);
					formEmail.setText("");//una vez regresa, vuelve a ponerse negro
				}
			});
		}
		{
			JLabel lblTipoDeComentario = new JLabel("Tipo de comentario");
			lblTipoDeComentario.setBounds(24, 89, 146, 31);
			contentPanel.add(lblTipoDeComentario);
		}
		{
			comboBoxFormulario = new JComboBox();
			comboBoxFormulario.setBounds(217, 101, 197, 31);
			comboBoxFormulario.setModel(new DefaultComboBoxModel(new String[] {"Sugerencia", "Reclamacion", "Dejar un C.V"}));
			comboBoxFormulario.setSelectedItem(null);
			contentPanel.add(comboBoxFormulario);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(12, 174, 463, 174);
			textArea.setRows(2);
			textArea.setColumns(3);
			contentPanel.add(textArea);
		    
		}
		{
			JLabel lblComentarios = new JLabel("Comentarios*");
			lblComentarios.setBounds(24, 147, 119, 15);
			contentPanel.add(lblComentarios);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnArchivo = new JButton("A\u00f1adir archivo");
				btnArchivo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						open();
					}

					private void open() {
						try {
							openFileChooser();
						} catch (IOException | ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null, "Hay problemas para abrir el fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
							Fichero.newFile();
						}
						
					}

					
						private void openFileChooser() throws FileNotFoundException, ClassNotFoundException, IOException {
							JFileChooser open = new JFileChooser();
							open.setAcceptAllFileFilterUsed(false);
							open.addChoosableFileFilter(filtroInput);
							if (open.showDialog(open, "Abrir Fichero") == JFileChooser.APPROVE_OPTION) {
								Fichero.fichero = open.getSelectedFile();
								lblFichero.setText(open.getSelectedFile().getName());				
							}
						}
						
					}
				);
				{
					 lblFichero = new JLabel("ninguno seleccionado");
					lblFichero.setEnabled(false);
					buttonPane.add(lblFichero);
				}
				buttonPane.add(btnArchivo);
			}
			{
				JButton okButton = new JButton("Enviar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(nombreValido() && emailValido()){//Comprobamos si el nombre y el email son validos
							if(textArea.getText().length()>500||textArea.getText().length()<10  ){
								try {
									throw new NombreNoValidoException("Por favor, el comentario debe tener entre 10 y 500 caracteres");
								} catch (NombreNoValidoException e) {
									JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Fallo al enviar",JOptionPane.WARNING_MESSAGE);
								}
							}else{
								//Guarda la informacion en un fichero txt
								JOptionPane.showMessageDialog(rootPane,"Enviado con Exito \n Muy pronto atenderemos su mensaje");
								setVisible(false);
							}
						}else{
							try {
								throw new NombreNoValidoException("El nombre o email no es valido, por favor corrigelo");
							} catch (NombreNoValidoException e) {
								JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Fallo al enviar",JOptionPane.WARNING_MESSAGE);
							}
						}
						//Guarda la información del formulario en un fichero .txt
					}


				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Limpiar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					formNombre.setText("");
					formApellidos.setText("");
					formEmail.setText("");
					comboBoxFormulario.setSelectedItem(null);
					textArea.setText("");
					lblFichero.setText("ninguno seleccionado");
					Fichero.fichero =null;
					}
				});
				
				buttonPane.add(cancelButton);
			}
		}
	}					private boolean emailValido() {
		final Pattern controlEmail = Pattern
				.compile("^(\\w\\.)*[a-z0-9._%+-]+@[a-z0-9]+\\.[a-z]{2,3}(.[a-z]{2,3})*$");
		java.util.regex.Matcher mEmail =controlEmail.matcher(formEmail.getText());
		return mEmail.matches();
		
	}

	private boolean nombreValido() {
		final Pattern controlNombre = Pattern
				.compile("^\\w{5,20}");
		java.util.regex.Matcher mNombre = controlNombre.matcher(formNombre.getText());
		return mNombre.matches();
	}

}
