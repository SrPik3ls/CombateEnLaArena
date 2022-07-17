
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Una clase que genera imagenes. 
 * Esta clase extiende de JPanel.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
public class Fondo extends JPanel {
	ImageIcon a;

	/**
	 * Constructor de la clase fondo que recibe el parametro nombre
	 * @param nombre El nombre del fondo
	 */
	public Fondo(String nombre) {
		a = new ImageIcon(getClass().getResource(nombre));	
		setSize(a.getIconWidth(), a.getIconHeight());		
	}
	
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(a.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}

	/**
	 * Metodo que añade un fondo y recibe un nombre
	 * @param string El nombre del fondo
	 */
	public void add(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo que cambia el fondo por el parametro recibido
	 * @param string Nombre del fondo
	 */
	public void setForeground(String string) {
		// TODO Auto-generated method stub
		
	}

}
