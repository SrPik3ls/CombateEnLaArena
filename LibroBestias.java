import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.TextArea;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

/**
 * Una clase que representa el libro de bestias. 
 * Esta clase extiende de JFrame.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
public class LibroBestias extends JFrame {
	/*ImageIcon icono;
	Fondo imagenesPanel;*/
	private JPanel contentPane;
	//ArrayList de enemigos
	public ArrayList<Modelo> enemigos = new ArrayList<Modelo>();
	
	public int cont = 0;
	String[] imagen = {"dolan.png", "sanic.jpg","cortex.jpg","shadow.jpg","reaper.jpg","kun.jpg","chronus.jpg","apoleo.jpg"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibroBestias frame = new LibroBestias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor por defecto del libro de bestias
	 */
	public LibroBestias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibroDeBestias = new JLabel("LIBRO DE BESTIAS");
		lblLibroDeBestias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblLibroDeBestias.setBounds(124, 11, 239, 29);
		contentPane.add(lblLibroDeBestias);
		
		JLabel lblNivelBestia = new JLabel("Nivel Bestia:");
		lblNivelBestia.setBounds(183, 97, 146, 14);
		contentPane.add(lblNivelBestia);
		
		JLabel lblNivel = new JLabel("");
		lblNivel.setBounds(339, 97, 46, 14);
		contentPane.add(lblNivel);
		
		JLabel lblNombreBestia = new JLabel("Nombre Bestia:");
		lblNombreBestia.setBounds(183, 72, 146, 14);
		contentPane.add(lblNombreBestia);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(339, 72, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblVidaMax = new JLabel("Vida Max.:");
		lblVidaMax.setBounds(183, 122, 146, 14);
		contentPane.add(lblVidaMax);
		
		JLabel lblVida = new JLabel("");
		lblVida.setBounds(339, 122, 46, 14);
		contentPane.add(lblVida);
		
		JLabel lblAtaqueMax = new JLabel("Ataque Max.:");
		lblAtaqueMax.setBounds(183, 147, 146, 14);
		contentPane.add(lblAtaqueMax);
		
		JLabel lblAtaque = new JLabel("");
		lblAtaque.setBounds(339, 147, 46, 14);
		contentPane.add(lblAtaque);
		
		JLabel lblDefensaMax = new JLabel("Defensa Max.:");
		lblDefensaMax.setBounds(183, 172, 146, 14);
		contentPane.add(lblDefensaMax);
		
		JLabel lblDefensa = new JLabel("");
		lblDefensa.setBounds(339, 172, 46, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblTipoBestia = new JLabel("Tipo Bestia:");
		lblTipoBestia.setBounds(183, 197, 146, 14);
		contentPane.add(lblTipoBestia);
		
		JLabel lblTipo = new JLabel("");
		lblTipo.setBounds(339, 197, 46, 14);
		contentPane.add(lblTipo);
		
		/*icono = new ImageIcon(imagen[imgCont]);
		imagenesPanel = new Fondo(imagen[0]);
		imagenesPanel.setBounds(44, 76, 141, 135);
		contentPane.add(imagenesPanel);*/
		//
		//MOSTRAMOS AL PRIMER BICHO DEL ARRAYLIST
		//
		
		//
		//EVENTO BOTON SIGUIENTE PARA PASAR AL SIGUEITNE BICHO
		//
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*imagenesPanel.setForeground(imagen[imgCont]);
				imagenesPanel.setBounds(44, 76, 141, 135);
				contentPane.add(imagenesPanel);
				imgCont++;*/
				
				if(cont == enemigos.size()) {
					JOptionPane.showMessageDialog(null, "No hay más enemigos");
				}else {
					cont++;
					lblNombre.setText(enemigos.get(cont).getNombre());
					lblNivel.setText(String.valueOf(enemigos.get(cont).getNivel()));
					lblAtaque.setText(String.valueOf(enemigos.get(cont).getPATK()));
					lblDefensa.setText(String.valueOf(enemigos.get(cont).getPDEF()));
					lblVida.setText(String.valueOf(enemigos.get(cont).getPvMax()));
					lblTipo.setText(enemigos.get(cont).getTipo());
				}
			}
		});
		btnSiguiente.setBounds(339, 259, 89, 23);
		contentPane.add(btnSiguiente);
		
		//
		//LO MISMO QUE EL SIGUIENTE PERO AL REVES
		//
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(cont == 0) {
					JOptionPane.showMessageDialog(null, "No hay más enemigos");
				}else {
					cont--;
					lblNombre.setText(enemigos.get(cont).getNombre());
					lblNivel.setText(String.valueOf(enemigos.get(cont).getNivel()));
					lblAtaque.setText(String.valueOf(enemigos.get(cont).getPATK()));
					lblDefensa.setText(String.valueOf(enemigos.get(cont).getPDEF()));
					lblVida.setText(String.valueOf(enemigos.get(cont).getPvMax()));
					lblTipo.setText(enemigos.get(cont).getTipo());
				}
			}
		});
		btnAnterior.setBounds(44, 259, 89, 23);
		contentPane.add(btnAnterior);
		
		//
		//PANEL PARA METER IAMGENES DE BICHOS
		//
		
	
		
	}
}