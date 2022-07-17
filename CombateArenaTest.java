import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

/**
 * Clase para realizar las pruebas al programa
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
public class CombateArenaTest {
	
	/**
	 * Prueba que se puedan leer enemigos correctamente
	 */
	@Test
	public void leerEnemigosTest() {
		ArrayList<Modelo> esperado = new ArrayList<Modelo>();
		try{
			File fichero = new File("data_1.suv");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
			//Se lee el primer objeto
			//Mientras existen objetos, los lee y los añade.
			esperado = (ArrayList<Modelo>) ois.readObject();
			ois.close();
			if(esperado.size() < 10) {
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
		
		ArrayList<Modelo> enemigosActual = Main.leerEnemigos();
		assertSame(esperado, enemigosActual);
	}
	
	/**
	 * Prueba que se pueda leer el ranking correctamente
	 */
	@Test
	public void leerRankingTest() {
		ArrayList<Luchador> esperado = new ArrayList<Luchador>();
		try {
			File fichero = new File("data_2.suv");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
			esperado =  (ArrayList<Luchador>) ois.readObject();
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
		
		ArrayList<Luchador> actual = Main.leerRanking();
		assertSame(esperado, actual);
	}
	
	/**
	 * Prueba que se pueda cargar la partida correctamente
	 */
	@Test
	public void cargarPartidaTest() {
		Luchador esperado = new Luchador();
		try {
			FileInputStream fi = new FileInputStream("sa.ve");
			ObjectInputStream is = new ObjectInputStream(fi);
			esperado = (Luchador) is.readObject();
		}catch(Exception io) {
			JOptionPane.showMessageDialog(null,"El archivo de guardado, no existe.");
		}
		Luchador actual = Main.cargarPartida();
		assertSame(esperado, actual);
	}
}
