package gui;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextArea;
/**
 * Despliega la ventana de ayuda, que permite seguir navegando sin necesidad de cerrarla previamente
 * @author pablo
 *
 */
public class DialogHelp extends JDialog {


	private static final long serialVersionUID = 1L;
	private static DialogHelp ayuda;
	private final JPanel contentPanel = new JPanel();

	DialogHelp() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Ayuda");
		setModal(false);
		setBounds(100, 100, 464, 444);

		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		
		textArea.setText(
				"\t----GUIA DE AYUDA----\n\n"
				+ "---Notas Previas---\n"
				+ "Por comodidad para pruebas, existe un fichero en la raiz llamado\n"
				+ "\'stock.obj\' que contiene un conjunto de artículos ya creados.\n"
				+ "igualmente, indicar que hasta que un stock no esté cargado, la\n"
				+ "opción descargar catálogo no podrá generar el fichero \'catalogo.txt\' \n"
				+ "\n\t---SECCIÓN ADMINISTRADOR---\n"
				+ "Archivo -->\n"
				+ "Permite gestionar nuestro stock,pudiendo abrir uno existente,\n"
				+ "iniciar uno nuevo o guardar el actual\n"
				+ "\nGestión -->\n"
				+ "El menú de Gestión nos ofrece la posibilidad de añadir, mostrar,\n "
				+ "modificar o eliminar artículos, alterando la estructura de la \n"
				+ "ventana en función del tipo de artículo. Por otra parte, se\n"
				+ "ofrece la posibilidad de eliminar por código o recorriendo el stock."
				+ "\nActualizar existencias permite añadir una cantidad determinada "
				+ "\nde todos los artículos del stock\n"
				+ "\nPedidos -->\n"
				+ "se abriría un fichero de texto que almacena los pedidos realizados\n"
				+ "por los usuarios, (ver Clientes)\n"
				+ "\nCambiar Destacados -->\n"
				+ "pendiente de completar, modificaría los artículos que se mostrarían\n"
				+ "como destacados en el área de clientes\n"
				+ "\n\t---SECCIÓN CLIENTES---\n"
				+ "\nOfertas -->\n"
				+ "Muestra los artículos con mejores ofertas en ese momento\n"
				+ "\nArtículos -->\n"
				+ "Muestra los artículos del stock ordenados por precio o por nombre\n"
				+ "Además de permitir mostrarlos siendo clasificados en función de su\n"
				+ "categoría así como descargar el catálogo en un fichero txt\n"
				+ "\nCesta -->\n"
				+ "Permite comprobar los articulos que hemos añadido a la cesta\n"
				+ "(artículos seleccionados), y desde ahí realizar un pedido\n"
				+ "o bien vaciar la cesta si finalmente no se \n\tquiere comprar nada\n"
				+ "\nContacto -->\n"
				+ "\t1- Acerca de: muestra información referente\n\t"
				+ "al proyecto y da acceso a su repositorio\n"
				+ "\t2- Ayuda: la presente ayuda, (usted está aquí)\n"
				+ "\t3- Formulario: permite enviar un formulario, que se\n\t"
				+ "recoge en un fichero \'formulario.txt\' \n\ten la raíz del proyecto.");
		textArea.setBounds(0, 0, 454, 434);
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