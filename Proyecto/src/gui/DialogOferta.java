package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jerarquia.Articulo;
import stock.Stock;

import javax.swing.JTextPane;

public class DialogOferta extends JDialog {
	JTextPane textOfertas;
	private final JPanel contentPanel = new JPanel();
	private Stock stockOfertas = new Stock();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogOferta dialog = new DialogOferta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogOferta() {
		buscarOfertas();
		setTitle("Menu Ofertas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textOfertas = new JTextPane();
		textOfertas.setEnabled(false);
		textOfertas.setEditable(false);
		textOfertas.setBounds(10, 23, 422, 239);
		contentPanel.add(textOfertas);
	}

	private void buscarOfertas() {
		StringBuilder contenido = new StringBuilder();
		for(Articulo art:Principal.stock.getStock()){
			if(art.getDescuento()>0.5){
				stockOfertas.addToStock(art, 1);
				contenido.append(art.getNombre()+", precio: "+art.getPrecio()+"\n");
			}
		
		}
		if(contenido.length()==0)
			textOfertas.setText("no tenemos ofertas");
		else
			textOfertas.setText(contenido.toString());
		
	}

}
