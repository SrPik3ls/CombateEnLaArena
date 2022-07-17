import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Una clase que representa el editor de bestias. 
 * Esta clase extiende de JFrame.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
@SuppressWarnings("serial")
public class EditorBestias extends JFrame {
	@SuppressWarnings("rawtypes")
	JComboBox cbEne;
	private JPanel contentPane;
	private ArrayList<Modelo> enemigos;
	private JTextField tfNombre;
	private JTextField tfTipo;
	private JTextField tfFV;
	private JTextField tfFD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorBestias frame = new EditorBestias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor que crea un editor de bestias con parametros por defecto
	 */
	@SuppressWarnings("rawtypes")
	public EditorBestias() {
		setTitle("Editor de Enemigos");
		enemigos = leerEnemigos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 643);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGuardar = new JMenu("Archivo");
		menuBar.add(mnGuardar);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnGuardar.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnGuardar.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cbEne = new JComboBox();
		
		JLabel lblEnemigos = new JLabel("Enemigos:");
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(cbEne, 0, 209, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(71)
								.addComponent(lblEnemigos, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEnemigos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbEne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
							.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(40))))
		);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(207, 11, 91, 20);
		desktopPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(42, 14, 75, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(42, 48, 75, 14);
		desktopPane.add(lblNivel);
		
		JLabel lblPuntosDeVida = new JLabel("Puntos de Vida:");
		lblPuntosDeVida.setBounds(42, 73, 118, 14);
		desktopPane.add(lblPuntosDeVida);
		
		JLabel lblNewLabel = new JLabel("Puntos de Ataque:");
		lblNewLabel.setBounds(42, 112, 126, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblPuntosDeDefensa = new JLabel("Puntos de Defensa:");
		lblPuntosDeDefensa.setBounds(42, 148, 118, 14);
		desktopPane.add(lblPuntosDeDefensa);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(42, 177, 91, 14);
		desktopPane.add(lblTipo);
		
		JLabel lblFraseDeVictoria = new JLabel("Frase de victoria:");
		lblFraseDeVictoria.setBounds(42, 211, 118, 14);
		desktopPane.add(lblFraseDeVictoria);
		
		JLabel lblFraseDeDerrota = new JLabel("Frase de derrota:");
		lblFraseDeDerrota.setBounds(42, 242, 126, 14);
		desktopPane.add(lblFraseDeDerrota);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(42, 328, 75, 14);
		desktopPane.add(lblBiografia);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(42, 438, 46, 14);
		desktopPane.add(lblImagen);
		
		JSlider sliderATK = new JSlider();
		sliderATK.setValue(1);
		
		sliderATK.setMinimum(1);
		sliderATK.setMaximum(10);
		sliderATK.setBounds(207, 106, 91, 20);
		desktopPane.add(sliderATK);
		
		JLabel lblSN = new JLabel("1");
		lblSN.setBounds(308, 42, 30, 20);
		desktopPane.add(lblSN);
		
		JSlider sliderNVL = new JSlider();
		sliderNVL.setValue(1);
		
		sliderNVL.setMinimum(1);
		sliderNVL.setMaximum(10);
		sliderNVL.setBounds(207, 42, 91, 20);
		desktopPane.add(sliderNVL);
		
		JSlider sliderPV = new JSlider();
		sliderPV.setValue(1);
		
		sliderPV.setMinimum(1);
		sliderPV.setMaximum(10);
		sliderPV.setBounds(207, 73, 91, 20);
		desktopPane.add(sliderPV);
		
		JSlider sliderPD = new JSlider();
		sliderPD.setValue(1);
		
		sliderPD.setMinimum(1);
		sliderPD.setMaximum(10);
		sliderPD.setBounds(207, 142, 91, 20);
		desktopPane.add(sliderPD);
		
		TextArea taB = new TextArea();
		taB.setBounds(125, 292, 198, 111);
		desktopPane.add(taB);
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		tfTipo.setBounds(207, 174, 91, 20);
		desktopPane.add(tfTipo);
		
		tfFV = new JTextField();
		tfFV.setColumns(10);
		tfFV.setBounds(207, 205, 91, 20);
		desktopPane.add(tfFV);
		
		tfFD = new JTextField();
		tfFD.setColumns(10);
		tfFD.setBounds(207, 236, 91, 20);
		desktopPane.add(tfFD);
		
		JLabel lblSPV = new JLabel("1");
		lblSPV.setBounds(308, 73, 40, 20);
		desktopPane.add(lblSPV);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.setBounds(134, 497, 132, 23);
		desktopPane.add(btnGuardar);
		
		JLabel lblSPA = new JLabel("1");
		lblSPA.setBounds(308, 109, 30, 20);
		desktopPane.add(lblSPA);
		
		JLabel lblSPD = new JLabel("1");
		lblSPD.setBounds(308, 142, 46, 20);
		desktopPane.add(lblSPD);
		
		JButton btnSelect = new JButton("Seleccionar");
		
		btnSelect.setBounds(134, 449, 146, 23);
		desktopPane.add(btnSelect);
		
		JLabel lblRuta = new JLabel("");
		lblRuta.setEnabled(false);
		lblRuta.setBounds(98, 423, 240, 14);
		desktopPane.add(lblRuta);
		contentPane.setLayout(gl_contentPane);
		insertarEnemigosCBox();
		cbEne.setSelectedIndex(0);
		cbEne.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int aux = cbEne.getSelectedIndex();
				if(aux > 0) {
					//Es aux - 1 porque en el array la posición es un número menor que en el ArrayList de Modelos.
					tfNombre.setText(enemigos.get(aux -1).getNombre());
					tfNombre.setEnabled(false);
					sliderATK.setValue(enemigos.get(aux -1).getPATKMax());
					sliderNVL.setValue(enemigos.get(aux -1).getNivel());
					sliderPD.setValue(enemigos.get(aux -1).getPDEFMax());
					sliderPV.setValue(enemigos.get(aux -1).getPvMax());
					tfTipo.setText(enemigos.get(aux -1).getTipo());
					tfFV.setText(enemigos.get(aux -1).getFraseVictoria());
					tfFD.setText(enemigos.get(aux -1).getFraseDerrota());
					taB.setText(enemigos.get(aux -1).getBiografia());
				}
				else {
					tfNombre.setText("");
					tfNombre.setEnabled(true);
					sliderATK.setValue(0);
					sliderNVL.setValue(0);
					sliderPD.setValue(0);
					sliderPV.setValue(0);
					tfTipo.setText("");
					tfFV.setText("");
					tfFD.setText("");
					taB.setText("");
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int auxPosicionEnemigo = existeEnemigo(tfNombre.getText(), enemigos);
				if(auxPosicionEnemigo == -1) {
					if(tfNombre.getText() == null || tfNombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
					}
					else if(tfTipo.getText() == null || tfTipo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "El tipo no puede estar vacío");
					}
					else {
						enemigos.add(new Modelo(tfNombre.getText(), sliderNVL.getValue(), sliderPV.getValue(), sliderATK.getValue(), sliderPD.getValue(), tfTipo.getText(), tfFV.getText(), tfFD.getText(), taB.getText(), lblRuta.getText()));
						insertarEnemigosCBox();
						cbEne.setSelectedIndex(0);
					}
				}
				else {
					enemigos.get(auxPosicionEnemigo).setPATKMax(sliderATK.getValue());
					enemigos.get(auxPosicionEnemigo).setNivel(sliderNVL.getValue());
					enemigos.get(auxPosicionEnemigo).setPDEFMax(sliderPD.getValue());
					enemigos.get(auxPosicionEnemigo).setPvMax(sliderPV.getValue());
					enemigos.get(auxPosicionEnemigo).setTipo(tfTipo.getText());
					enemigos.get(auxPosicionEnemigo).setFraseVictoria(tfFV.getText());
					enemigos.get(auxPosicionEnemigo).setFraseDerrota(tfFD.getText());
					enemigos.get(auxPosicionEnemigo).setBiografia(taB.getText());
					insertarEnemigosCBox();
				}
				
			}
		});
		sliderPD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblSPD.setText(Integer.toString(sliderPD.getValue()));
			}
		});
		sliderATK.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSPA.setText(Integer.toString(sliderATK.getValue()));
			}
		});
		sliderPV.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSPV.setText(Integer.toString(sliderPV.getValue()));
			}
		});
		sliderNVL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblSN.setText(Integer.toString(sliderNVL.getValue()));
			}
		});
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileC = new JFileChooser();
				fileC.setVisible(true);
				fileC.showOpenDialog(null);
				File file = fileC.getSelectedFile();
				//Comprueba si es una imagen.
				if((file.getPath().substring(file.getPath().length() -3, file.getPath().length()).equals("jpg")) || (file.getPath().substring(file.getPath().length() -3, file.getPath().length()).equals("png")) ) {
					lblRuta.setText(file.getPath());
				}
				else {
					JOptionPane.showMessageDialog(null, "El archivo seleccionado, no es un archivo .jpg o .png.");
				}
			}
		});

		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileOutputStream fs = new FileOutputStream("data_1.suv");
					ObjectOutputStream oos = new ObjectOutputStream(fs);
					for(int i = 0; i < enemigos.size(); i++) {
						oos.writeObject(enemigos.get(i));
					}
				}catch(Exception io) {
					io.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Metodo estatico que lee los enemigos desde un fichero
	 * @return devuelve los enemigos que se encontraban en ese fichero
	 */
	public static ArrayList<Modelo> leerEnemigos() {
		ArrayList<Modelo> arrayAuxiliarEnemigos = new ArrayList<Modelo>();
		try{
			File fichero = new File("data_1.suv");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
			//Se lee el primer objeto
			//Mientras existen objetos, los lee y los añade.
			arrayAuxiliarEnemigos = (ArrayList<Modelo>) ois.readObject();
			ois.close();
			if(arrayAuxiliarEnemigos.size() < 10) {
				throw new IOException();
			}
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(null,"Faltan archivos del juego o han sido modificados de manera ilegal. Por favor, reinstale el juego.");
			ex.printStackTrace();
			System.exit(0);
		}
		catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Faltan archivos del juego o han sido modificados de manera ilegal. Por favor, reinstale el juego.");
			e.printStackTrace();
			System.exit(0);
		}
		return arrayAuxiliarEnemigos;
	}
	
	
	/**
	 * Metodo estatico que comprueba si existe el nombre recibido en el ArrayList de Modelo
	 * @param nombre El nombre del enemigo
	 * @param enemigos La lista de enmigos existentes
	 * @return
	 */
	public static int existeEnemigo(String nombre, ArrayList<Modelo> enemigos) {
		int existir = -1;
		for(int i = 0; i < enemigos.size(); i++) {
			if(enemigos.get(i).getNombre().equals(nombre)) {
				existir = i;
				return existir;
			}
		}
		return existir;
	}
	/**
	 * Metodo que crea enemigos
	 */
	@SuppressWarnings("unchecked")
	public void insertarEnemigosCBox() {
		cbEne.removeAllItems();
		String s = "*Crear nuevo enemigo*";
		cbEne.insertItemAt(s, 0);
		for(int i = 0; i < enemigos.size(); i++) {
			cbEne.insertItemAt(enemigos.get(i).getNombre(), (i + 1));
		}
	}
}
