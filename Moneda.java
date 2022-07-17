/**
 * Una clase que representa el azar en el daño o defensa del jugador. 
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
 
public class Moneda {
	//Añadimos el nivel y critico a variables
	private int cara = 0, cruz = 0;
	// Añadimos booelan
	private double nivel, critico;
	private boolean golpeCritico = false;
	
	/**
	 * Metodo que devuelve si es o no un golpe critico
	 * @return devuelve el resultado del golpe critico
	 */
	public boolean isGolpeCritico() {
		return golpeCritico;
	}
	/**
	 * Metodo que establece si es o no un golpe critico
	 * @param golpeCritico el valor del golpe critico
	 */
	public void setGolpeCritico(boolean golpeCritico) {
		this.golpeCritico = golpeCritico;
	}
	/**
	 * Constructor que crea una moneda con valores por defecto
	 */
	public Moneda() {
	}
	//Añadido al constructor el nivel del jugador
	/**
	 * Constructor que crea una moneda con un nVeces y un nivelPersonaje especificos
	 * @param nVeces El numero de veces que se gira la moneda
	 * @param nivelPersonaje El nivel del personaje que gira la moneda
	 */
	public Moneda(int nVeces, int nivelPersonaje) {
		nivel = nivelPersonaje;
		critico = (int) Math.random() * 10;
		for(int  i = 0; i < nVeces; i++) {
			double aleatorio = Math.random();
			if(aleatorio < 0.5) {
				cara++;
			}
			else {
				cruz++;
			}
		}
		//Añadimos if 
		if(nivel <= critico) {
			golpeCritico = true;
			cara = cara * 2;
		}
		if(cara == 0) {
			cara = 1;
		}
	}
	/**
	 * Metodo que devuelve el valor de cara
	 * @return devuelve la cara de la moneda
	 */
	public int getCara() {
		return cara;
	}
	/**
	 * Metodo que establece el valor de cara
	 * @param cara El valor de cara a establecer
	 */
	public void setCara(int cara) {
		this.cara = cara;
	}
	/**Metodo que devuelve el valor de cruz
	 * @return devuelve la cruz de la moneda
	 */
	public int getCruz() {
		return cruz;
	}
	/**
	 * Metodo que establece el valor de cruz
	 * @param cruz El valor de cruz a establecer
	 */
	public void setCruz(int cruz) {
		this.cruz = cruz;
	}
	
}
