package stock;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.border.Border;
/**
 * Clase que gestiona la inserción de un fondo en los Frames
 * @author pablo
 *
 */
public class FondoImagen implements Border {
	private static final long serialVersionUID = 1L;
	
	BufferedImage backImage = null;

	public FondoImagen(BufferedImage bImage) {
		backImage = bImage;
	}

	public void paintComponent(Graphics g) {
				
	}

	@Override
	public Insets getBorderInsets(Component arg0) {
		return new Insets(0, 0, 0, 0);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

	@Override
	public void paintBorder(Component arg0, Graphics g, int arg2, int arg3, int width, int heigth) {
		
		if(backImage!= null){
			g.drawImage(backImage, 0, 0, width, heigth, null);
		}
		
	}
}




