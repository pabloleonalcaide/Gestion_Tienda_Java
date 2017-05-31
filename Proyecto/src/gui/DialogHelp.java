package gui;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextArea;

public class DialogHelp extends JDialog {


	private static final long serialVersionUID = 1L;
	private static DialogHelp ayuda;
	private final JPanel contentPanel = new JPanel();

	DialogHelp() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Ayuda");
		setModal(false);
		setBounds(100, 100, 300, 308);

		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText(
				"Ayuda...\n Implementar Anotaciones, explicaciones, etc");
		textArea.setBounds(0, 0, 294, 283);
		getContentPane().add(textArea);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * singleton
	 * @return new Ayuda
	 */
	public static DialogHelp getInstance() {
		if (ayuda == null)
			ayuda = new DialogHelp();
		return ayuda;
	}
}