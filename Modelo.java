import java.io.Serializable;

/**
 * Una clase que representa como deben ser los personajes del juego.
 * Esta clase define varias mecanicas del juego como la vida, el atk, etc.
 * @author Antonio Rodríguez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
@SuppressWarnings("serial")
public class Modelo implements Serializable{
	
	private String nombre;
	private int nivel;
	private int pv;
	private int pvMax;
	private int PATK;
	private int PATKMax;
	private int PDEF;
	private int PDEFMax;
	private String tipo;
	private String fraseVictoria;
	private String fraseDerrota;
	private String biografia;
	private String rutaIMG;
	
	/** 
     * Constructor que crea el Modelo de personaje por defecto
     */
	public Modelo() {
		
	}
	/** 
     * Se crea un constructor de Modelo con un nombre, nivel, pvMax, pATKMax,
	 * pDEFMax, pDEFMax y tipo especificos
     * @param nombre Nombre del personaje
     * @param nivel Nivel 
     * @param pv Puntos de salud
     * @param pvMax Puntos de salud maximos
     * @param pATK Puntos de ataque
     * @param pATKMax Puntos de ataque maximos
     * @param pDEF Puntos de defensa
     * @param pDEFMax Puntos de defensa maximos
     * @param tipo Tipo del personaje
     */
	public Modelo(String nombre, int nivel, int pvMax, int pATKMax, int pDEFMax, String tipo) {
		setNombre(nombre);
		setNivel(nivel);
		setPvMax(pvMax);
		setPv(getPvMax());
		setPATKMax(pATKMax);
		setPATK(getPATKMax());
		setPDEFMax(pDEFMax);
		setPDEF(getPDEFMax());
		setTipo(tipo);
	}
	
	/**
	 * Se crea un constructor de Modelo con un nombre, nivel, pvMax, pATKMax,
	 * pDEFMax, pDEFMax, tipo, fraseVictoria, fraseDerrota, biografia y rutaIMG especificos
	 * @param nombre El nombre del Modelo
	 * @param nivel El nivel del Modelo
	 * @param pvMax Los puntos de vida maximos del Modelo
	 * @param pATKMax El ataque maximo del Modelo
	 * @param pDEFMax La defensa macima del Modelo
	 * @param tipo El tipo del Modelo
	 * @param fraseVictoria La frase de victoria del Modelo
	 * @param fraseDerrota La frase de derrota del Modelo
	 * @param biografia La biografia del Modelo
	 * @param rutaIMG La rutaIMG del Modelo 
	 */
	public Modelo(String nombre, int nivel, int pvMax, int pATKMax, int pDEFMax, String tipo, String fraseVictoria, String fraseDerrota, String biografia, String rutaIMG) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.pvMax = pvMax;
		PATKMax = pATKMax;
		PDEFMax = pDEFMax;
		this.tipo = tipo;
		this.fraseVictoria = fraseVictoria;
		this.fraseDerrota = fraseDerrota;
		this.biografia = biografia;
		this.rutaIMG = rutaIMG;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Nivel Actual: " + nivel + ", Puntos de Vida: " + pv + ", Puntos de Ataque: " + PATK
				+ ", Puntos de Defensa: " + PDEF + ", Tipo: " + tipo;
	}

	/**
	 * Metodo que devuelve el tipo del Modelo
	 * @return El tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo que establece el tipo del Modelo
	 * @param tipo El tipo del Modelo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que devuelve el nombre del Modelo
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que establece el nombre del Modelo
	 * @param nombre El nombre del Modelo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que devuelve el nivel del Modelo
	 * @return EL nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Metodo que establece el nivel del modelo
	 * @param nivel El nivel del Modelo
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * Metodo que devuelve la vida del Modelo
	 * @return La vida
	 */
	public int getPv() {
		return pv;
	}
	/**
	 * Metodo que establece la vida del Modelo
	 * @param pv La vida del modelo
	 */
	public void setPv(int pv) {
		this.pv = pv;
		if(getPv() > getPvMax()) {
			setPv(getPvMax());
		}
	}
	/**
	 * Metodo que devuelve la vida maxima del Modelo
	 * @return La vida maxima
	 */
	public int getPvMax() {
		return pvMax;
	}
	/**
	 * Establece la vida maxima del Modelo
	 * @param pvMax La vida maxima del Modelo
	 */
	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
	/**
	 * Metodo que devuelve el ataque maximo del modelo
	 * @return El ataque maximo
	 */
	public int getPATK() {
		return PATK;
	}
	/**
	 * Metodo que establece el ataque maximo del modelo
	 * @param pATK EL ataque maximo del modelo
	 */
	public void setPATK(int pATK) {
		this.PATK = pATK;
		if(getPATK() > getPATKMax()) {
			setPATK(getPATKMax());
		}
	}
	/**
	 * Metodo que devuelve el ataque maximo del Modelo
	 * @return Ataque maximo
	 */
	public int getPATKMax() {
		return PATKMax;
	}
	/**
	 * Metodo que estable el ataque maximo del modelo
	 * @param pATKMax El ataque maximo del modelo
	 */
	public void setPATKMax(int pATKMax) {
		PATKMax = pATKMax;
	}
	/**
	 * Metodo que devuelve la defensa del Modelo
	 * @return Defensa maxima
	 */
	public int getPDEF() {
		return PDEF;
	}
	/**
	 * Metodo que establece la defensa del modelo
	 * @param pDEF La defensa maxima del Modelo
	 */
	public void setPDEF(int pDEF) {
		this.PDEF = pDEF;
		if(getPDEF() > getPDEFMax()) {
			setPDEF(getPDEFMax());
		}
	}
	/**
	 * Metodo que devuelve la defensa maxima del Modelo
	 * @return La defensa maxima
	 */
	public int getPDEFMax() {
		return PDEFMax;
	}
	/**
	 * Metodo que establece la defensa maxima del modelo
	 * @param pDEFMax the pDEFMax to set
	 */
	public void setPDEFMax(int pDEFMax) {
		this.PDEFMax = pDEFMax;
	}
	/**
	 * Metodo que devuelve la frase de victoria del Modelo
	 * @return La frase de victoria
	 */
	public String getFraseVictoria() {
		return fraseVictoria;
	}
	/**
	 * Metodo que establece la frase de victoria del Modelo
	 * @param fraseVictoria La frase del Modelo
	 */
	public void setFraseVictoria(String fraseVictoria) {
		this.fraseVictoria = fraseVictoria;
	}
	/**
	 * Metodo que devuelve la frase de derrota del Modelo
	 * @return La frase de derrota
	 */
	public String getFraseDerrota() {
		return fraseDerrota;
	}
	/**
	 * Metodo que establece la frase de derrota del Modelo
	 * @param fraseDerrota La frase del Modelo
	 */
	public void setFraseDerrota(String fraseDerrota) {
		this.fraseDerrota = fraseDerrota;
	}
	/**
	 * Metodo que devuelve la biografia del Modelo
	 * @return La biografia
	 */
	public String getBiografia() {
		return biografia;
	}
	/**
	 * Metodo que establece la biografia del Modelo
	 * @param biografia El valor de la biografia del Modelo
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	/**
	 * Metodo que devuelve la ruta de la imagen del Modelo
	 * @return La ruta de la iamgen
	 */
	public String getRutaIMG() {
		return rutaIMG;
	}
	/**
	 * Metodo que establece la ruta de la imagen del Modelo
	 * @param rutaIMG La ruta de la imagen
	 */
	public void setRutaIMG(String rutaIMG) {
		this.rutaIMG = rutaIMG;
	}

}