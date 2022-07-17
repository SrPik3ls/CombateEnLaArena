import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Esta es la clase Principal, la cual va a ejecutar todo y va a ser la pantalla principal.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */

public class Main {
	
	public static void main(String[] args) {
		Luchador jugador; 
		ArrayList<Modelo> enemigos = leerEnemigos();
		ArrayList<Luchador> ranking = leerRanking();
		// Ejecución del programa
		int inicio;
		do {
			String [] opciones = {"Jugar", "Cargar Partida", "Editar Enemigos", "Ver el Ranking", "Salir"};
			inicio = JOptionPane.showOptionDialog(null, "¿Qué deseas hacer?", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (inicio == 0) {
					JOptionPane.showMessageDialog(null, "Bienvenido a Combate en la Arena");
					jugador = new Luchador(JOptionPane.showInputDialog(null, "Para comenzar introduce tu nombre: "), 1, 10, 2, 2, "Heroe");
					JOptionPane.showMessageDialog(null, "Vamos a repasar tu personaje: ");
					JOptionPane.showMessageDialog(null, "Tu personaje es un " + jugador.getTipo() + " con nombre " + jugador.getNombre());
					JOptionPane.showMessageDialog(null,"Es hora de empezar el juego");
					do{
						String [] eleccion = {"Combatir", "Guardar Partida", "Ver Libro de Bestias", "Salir"};
						int elecc = JOptionPane.showOptionDialog(null, "¿Qué quieres hacer?", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccion, eleccion[0]);
						switch(elecc) {
						case 0:
							Modelo enemigoActual = seleccionarEnemigo(jugador,  enemigos);
							JOptionPane.showMessageDialog(null,"En este combate te enfrentarás contra: " + enemigoActual.getNombre() + " que es de tipo... " + enemigoActual.getTipo());
							@SuppressWarnings("unused") 
							Combate combateActual = new Combate(jugador.getCombatesGanados(), jugador, enemigoActual);
							break;
						case 1:
							guardarPartida(jugador);
							break;
						case 2:
							LibroBestias libro = new LibroBestias();
							libro.setVisible(true);
							break;
						case 3:
							System.exit(0);
							break;
						}
					}while(jugador.getPv() > 0 && jugador.getCombatesGanados() != 10);
					if(jugador.getPv() <= 0) {
						JOptionPane.showMessageDialog(null, "Lo sentimos, has perdido.");
					}
					else {
						JOptionPane.showMessageDialog(null,"Enhorabuena, has alcanzado la victoria en la arena.");
					}
					if(jugador.getPuntuacion() > (ranking.get(ranking.size() -1).getPuntuacion())) {
						JOptionPane.showMessageDialog(null, "Tu puntuación esta dentro del ranking.");
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas añadir tu puntuación?", "Escoger", JOptionPane.YES_NO_OPTION);
						if(respuesta == 1) {
							ranking.get(ranking.size() - 1).setNombre(jugador.getNombre());
							ranking.get(ranking.size() - 1).setPuntuacion(jugador.getPuntuacion());
							guardarRanking(ranking);
							//Se lee otra vez para que así se ordene.
							ranking = leerRanking();
						}
					}
				}
			if(inicio == 1) {
				jugador = cargarPartida();
				if(jugador.getNombre() != null){
					JOptionPane.showMessageDialog(null,"Vamos a repasar vuestros stats:");
					JOptionPane.showMessageDialog(null,jugador.toString());
					JOptionPane.showMessageDialog(null,"Genial, retomamos donde lo dejamos.");
					do{
						String [] eleccion = {"Combatir", "Guardar Partida", "Ver Libro de Bestias", "Salir"};
						int elecc = JOptionPane.showOptionDialog(null, "¿Qué quieres hacer?", "Escoge una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccion, eleccion[0]);
						switch(elecc) {
						case 0:
							Modelo enemigoActual = seleccionarEnemigo(jugador,  enemigos);
							JOptionPane.showMessageDialog(null,"En este combate te enfrentarás contra: " + enemigoActual.getNombre() + " que es de tipo... " + enemigoActual.getTipo());
							@SuppressWarnings("unused") 
							Combate combateActual = new Combate(jugador.getCombatesGanados(), jugador, enemigoActual);
							break;
						case 1:
							guardarPartida(jugador);
							break;
						case 2:
							LibroBestias libro = new LibroBestias();
							libro.setVisible(true);
							break;
						case 3:
							System.exit(0);
							break;
						}
					}while(jugador.getPv() > 0 && jugador.getCombatesGanados() != 10);
					
					if(jugador.getPv() <= 0) {
						JOptionPane.showMessageDialog(null, "Lo sentimos, has perdido.");
					}
					else {
						JOptionPane.showMessageDialog(null,"Enhorabuena, has alcanzado la victoria en la arena.");
					}
					if(jugador.getPuntuacion() > (ranking.get(ranking.size() -1).getPuntuacion())) {
						JOptionPane.showMessageDialog(null, "Tu puntuación esta dentro del ranking.");
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas añadir tu puntuación?", "Escoger", JOptionPane.YES_NO_OPTION);
						if(respuesta == 1) {
							ranking.get(ranking.size() - 1).setNombre(jugador.getNombre());
							ranking.get(ranking.size() - 1).setPuntuacion(jugador.getPuntuacion());
							guardarRanking(ranking);
							//Se lee otra vez para que así se ordene.
							ranking = leerRanking();
						}
					}
				}
			}
			
			if(inicio == 2) {
				JOptionPane.showMessageDialog(null, "Finalice la ejecución del juego.");
				EditorBestias best = new EditorBestias();
				best.setVisible(true);
				//Lo último que hace si se han editado es leer enemigos para asignarlos.
				enemigos = leerEnemigos();
			}
			if(inicio == 3) {
				String rank = "Nombre \t \t Puntuación\n";
				for(int j = 0; j<ranking.size(); j++) {
					rank = rank + ranking.get(j).getNombre() + " \t \t " + ranking.get(j).getPuntuacion() + "\n";
				}
				JOptionPane.showMessageDialog(null, rank);
			}
		}while(inicio != -1 && inicio != 4);
	}
	
	
	/**
	 * Metodo estatico que lee un fichero que contiene los enemigos
	 * @return Devuelve el los enmeigos que haya encontrado en el fichero
	 */
	@SuppressWarnings("unchecked")
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
	 * Metotod estatico que guarda el ranking del luchador
	 * @param rank El ranking del luchador
	 */
	public static void guardarRanking(ArrayList<Luchador> rank){
		try {
			FileOutputStream fs = new FileOutputStream("data_2.suv");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(rank);
			oos.close();
			fs.close();
		}catch(Exception io) {
			io.printStackTrace();
		}
	}
	
	/**
	 * Metodo estatico que lee el ranking de luchadores
	 * @return Devuelve la puntuacion de los luchadores
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Luchador> leerRanking() {
		ArrayList<Luchador> aux = new ArrayList<Luchador>();
		try {
			File fichero = new File("data_2.suv");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
			aux =  (ArrayList<Luchador>) ois.readObject();
			ois.close();
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
		Collections.sort(aux, new Comparator<Luchador>() {
			@Override
			public int compare(Luchador p1, Luchador p2) {
				return new Integer(p2.getPuntuacion()).compareTo(new Integer(p1.getPuntuacion()));
			}
		});
		return aux;
	}
	
	/**
	 * Metodo estatico que selecciona al enemigo contra el que se luchara
	 * @param jugador El jugador
	 * @param enemigos El enemigo
	 * @return Devuelve un enemigo
	 */
	@SuppressWarnings("unused")
	public static Modelo seleccionarEnemigo(Luchador jugador, ArrayList<Modelo> enemigos) {
		Modelo enemigoActual;
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas seleccionar un enemigo?", "Escoger", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(respuesta == 0) {
			String name = JOptionPane.showInputDialog(null,"Introduce el nombre del adversario: ");
			int aux = -1;
			if(!(name == null || name.equals(""))) {
				for(int i = 0; i < enemigos.size(); i++) {
					if(name.equals(enemigos.get(i).getNombre())) {
						aux = i;
					}
				}
			}
			if(aux == -1) {
				JOptionPane.showMessageDialog(null,"El nombre introducido no existe en nuestra base de datos");
				JOptionPane.showMessageDialog(null,"Te elegiremos uno al azar.");
				return enemigoActual = enemigos.get(jugador.getNivel() + 1);
			}
			else {
				return enemigoActual = enemigos.get(aux); 
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"Te elegiremos uno al azar.");
			return enemigoActual = enemigos.get((int)(jugador.getNivel() + (Math.random() * 3)));
		}
	}
	/**
	 * Metodo estatico que carga la partida del luchador
	 * @return devuelve el ultimo punto de guardado
	 */
	@SuppressWarnings("resource")
	public static Luchador cargarPartida() {
		Luchador actual = new Luchador();
		try {
			FileInputStream fi = new FileInputStream("sa.ve");
			ObjectInputStream is = new ObjectInputStream(fi);
			actual = (Luchador) is.readObject();
		}catch(Exception io) {
			JOptionPane.showMessageDialog(null,"El archivo de guardado, no existe.");
		}
		return actual;
	}
	/**
	 * Metodo estatico que guarda la partida del jugador
	 * @param jugador El jugador que guarda la partida
	 */
	public static void guardarPartida(Luchador jugador) {
		try {
			File fichero = new File("sa.ve");
			if (fichero.exists()) {
				JOptionPane.showMessageDialog(null, "Se ha encontrado un fichero con una partida", "Alerta!", JOptionPane.DEFAULT_OPTION);
				int resp = JOptionPane.showConfirmDialog(null, "¿Deseas sobreescribir el fichero?", "Alerta!", JOptionPane.YES_NO_OPTION);
				if(resp == 0) {
					FileOutputStream fs = new FileOutputStream("sa.ve");
					ObjectOutputStream os = new ObjectOutputStream(fs);
					os.writeObject(jugador);
					os.close();
					JOptionPane.showMessageDialog(null,"Se ha guardado el archivo correctamente.");
				}
			}
			else {
				FileOutputStream fs = new FileOutputStream("sa.ve");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(jugador);
				os.close();
				JOptionPane.showMessageDialog(null,"Se ha guardado el archivo correctamente.");
			}
		}catch(Exception io) {
			JOptionPane.showMessageDialog(null,"Se ha producido un error. Contacte con el proveedor del videojuego.");
		}
	}
}