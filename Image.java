import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Una clase que crea una imagen. 
 * Esta clase extiende de JPanel.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
public class Image extends JPanel {
	ImageIcon a;
	
	/**
	 * Constructor que crea una imagen con un nombre especifico
	 * @param nombre El nombre de la imagen
	 */
	public Image(String nombre) {
		a = new ImageIcon(getClass().getResource(nombre));
		setSize(a.getIconWidth(), a.getIconHeight());		
	}
	
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(a.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}

}