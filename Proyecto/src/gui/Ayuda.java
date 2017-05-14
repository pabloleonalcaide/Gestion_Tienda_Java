package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import java.awt.TextArea;

public class Ayuda extends JDialog {

	private static Ayuda ayuda;
	private final JPanel contentPanel = new JPanel();

	Ayuda() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Ayuda");
		setModal(false);
		setBounds(100, 100, 300, 308);

		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText(
				"Ayuda para Compra Online...");
		textArea.setBounds(0, 0, 294, 283);
		getContentPane().add(textArea);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * singleton
	 * @return new Ayuda
	 */
	public static Ayuda getInstance() {
		if (ayuda == null)
			ayuda = new Ayuda();
		return ayuda;
	}
}