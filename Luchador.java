import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Una clase que representa al jugador. 
 * Esta clase extiende la clase Modelo y hereda todos sus metodos y variables.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */

@SuppressWarnings("serial")
public class Luchador extends Modelo implements Serializable {
	private int combatesGanados, pocionesCuracion;
	private int puntuacion = 0;
	private ArrayList<Modelo> enemigosEliminados = new ArrayList<Modelo>();
	
	/**
	 * Constructor que crea un luchador con valores por defecto
	 */
	public Luchador() {
		super();
	}
	
	/**
	 * Constructor que crea un luchador con un nombre, nivel, pvMax, 
	 * pATKMax, pDEFMax y tipo especificos
	 * @param nombre El nombre del luchador
	 * @param nivel El nivel del luchador
	 * @param pvMax Los puntos de vida maximos del luchador
	 * @param pATKMax Los puntos de ataque maximos del luchador
	 * @param pDEFMax Los puntos de defensa maximos del luchador
	 * @param tipo El tipo del luchador
	 */
	public Luchador(String nombre, int nivel, int pvMax, int pATKMax, int pDEFMax, String tipo) {
		setNombre(nombre);
		setNivel(nivel);
		setPvMax(pvMax);
		setPv(getPvMax());
		setPATKMax(pATKMax);
		setPATK(getPATKMax());
		setPDEFMax(pDEFMax);
		setPDEF(getPDEFMax());
		setTipo(tipo);
		setCombatesGanados(0);
		setPocionesCuracion(2);
		if(getNombre() == null || getNombre().equals("")) {
			setNombre("Nombre Por Defecto");
		}
	}
	/**
	 * Constructor que crea un luchador con un nombre y puntuacion especificos
	 * @param nombre El nombre del luchador
	 * @param puntuacion La puntuacion del luchador
	 */
	public Luchador(String nombre, int puntuacion){
		setNombre(nombre);
		setPuntuacion(puntuacion);
	}
	/**
	 * Metodo que devuelve el numero de combates ganados
	 * @return los combates ganados del luchador
	 */
	public int getCombatesGanados() {
		return combatesGanados;
	}
	/**
	 * Metodo que establece el numero de comabates ganados
	 * @param combatesGanados El numero de combates ganados del luchador
	 */
	public void setCombatesGanados(int combatesGanados) {
		this.combatesGanados = combatesGanados;
	}
	
	/**
	 * Metodo que devuelve el numero de pociones del luchador 
	 * @return El numero de pociones
	 */
	public int getPocionesCuracion() {
		return pocionesCuracion;
	}
	/**
	 * Metodo que establece el numero de pociones que tiene el luchador
	 * @param pocionesCuracion El numero de pociones disponibles
	 */
	public void setPocionesCuracion(int pocionesCuracion) {
		this.pocionesCuracion = pocionesCuracion;
	}
	/**
	 * Metodo que devuelve la puntuacion del Luchador
     * @return La puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }
    /**
     * Metodo que establece la puntuacion del luchador
     * @param puntuacion La puntuacion a establecer
     */
    public void setPuntuacion(int puntuacion) {
    	this.puntuacion = puntuacion;
    }
    
    /**
     * Metodo que establece la puntuacion segun el enemigo
     * @param enemigo El enemigo derrotado
     */
    public void setPuntuacion(Modelo enemigo) {
        if((enemigo.getNivel() - this.getNivel()) > 0){
            this.puntuacion = this.puntuacion + ((enemigo.getNivel() - this.getNivel()) * 100);
        }
        else{
            this.puntuacion = this.puntuacion + 50;
        }
    }
    /**
     * Metodo que sube de nivel y recibe un enemigo especifico
     * @param enemigo El enemigo derrotado
     */
    public void subirDeNivel(Modelo enemigo) {
		JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has subido de nivel.");
		JOptionPane.showMessageDialog(null, "Tus stats actuales son: ");
		setNivel(getNivel() + 1);
		setPvMax((int) (getNivel() + (Math.random() * 4)));
		setPATKMax((int) (getPATKMax() + (Math.random() * 2)));
		setPDEFMax((int) (getPDEFMax() + (Math.random() * 2)));
		setPuntuacion(enemigo);
		setCombatesGanados(getCombatesGanados() + 1);
		JOptionPane.showMessageDialog(null, toString());
    }

    /**
	 * Metodo que añade un enemigo eliminado
     * @param enemigo El enemigo eliminado
     */
    public void anyadirEnemigo(Modelo enemigo) {
    	this.enemigosEliminados.add(enemigo);
    }
	/**
	 * Metodo que devuelve los enemigos eliminados
	 * @return Los enemigos eliminados
	 */
	public ArrayList<Modelo> getEnemigosEliminados() {
		return enemigosEliminados;
	}
	/**
	 * Metodo que estable los enemigos eliminados
	 * @param enemigosEliminados Los enemigos eliminados
	 */
	public void setEnemigosEliminados(ArrayList<Modelo> enemigosEliminados) {
		this.enemigosEliminados = enemigosEliminados;
	}
}