import javax.swing.*;

/**
 * Una clase que representa cada combate del videojuego
 * Esta clase se ejecutar� un maximo de 10 veces por partida.
 * @author Antonio Rodr�guez, Xavi Sirvent, Edwin Irimie, Mikael Delgado
 * @version 2.0 10/06/18
 */
public class Combate {
	int nRondas = 1;
	String [] opciones = {"Atacar", "Defender", "Maniobrar", "Enga�ar", "Curarse", "Rendirse"};
	 
    /** 
     * Crea un combate a partir del nuemro de comabte, el enemigo y el luchador.
     * @param nCombate Indica el numero de combate.
     * @param lu El jugador principal.
     * @param ene El enemigo actual.
     */
	public Combate(int nCombate, Luchador jugador, Modelo enemigo) {
		int maniobraJugador = -1;
		JOptionPane.showMessageDialog(null,"Bienvenidos al combate n�mero " + (jugador.getCombatesGanados() + 1));
		do {
			if(nRondas%5 == 0 || nRondas == 1) {
				jugador.setPATK(jugador.getPATKMax());
				jugador.setPDEF(jugador.getPDEFMax());
				enemigo.setPATK(enemigo.getPATKMax());
				enemigo.setPDEF(enemigo.getPDEFMax());
				if(nRondas != 1) {
					JOptionPane.showMessageDialog(null, "Los atributos penalizados vuelven a su estado normal.");
				}
			}
			do {
				maniobraJugador = JOptionPane.showOptionDialog(null, "Elige una de las posibles estrategias", "Escoge una opcion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			}while(maniobraJugador == -1);
			int maniobraEnemiga = (int)(Math.random() * 4);
			if(maniobraJugador != 5) {
				switch(maniobraEnemiga) {
				case 0:
					JOptionPane.showMessageDialog(null,"Tu enemigo ha elegido Atacar.");
					break;
				case 1:
					JOptionPane.showMessageDialog(null,"Tu enemigo ha elegido Defender.");
					break;
				case 2:
					JOptionPane.showMessageDialog(null,"Tu enemigo ha elegido Maniobrar.");
					break;
				case 3:
					JOptionPane.showMessageDialog(null,"Tu enemigo ha elegido Enga�ar.");
					break;
				}
			}
			calculoManiobra(maniobraJugador, maniobraEnemiga, jugador, enemigo);
			nRondas++;
		}while(enemigo.getPv() > 0 && jugador.getPv() > 0);	
		if(enemigo.getPv() > 0) {
			JOptionPane.showMessageDialog(null,enemigo.getNombre() + " te ha derrotado. Una l�stima, estuviste apunto de alzarte con la victoria.");
		}
		if(jugador.getPv() > 0) {
			JOptionPane.showMessageDialog(null,"Has derrotado a " + enemigo.getNombre() + " .Enhorabuena, prosigue hacia la victoria.");
			jugador.subirDeNivel(enemigo);
			jugador.anyadirEnemigo(enemigo);
		}
	}
	/** 
     * Muestra las caracteristicas del enemigo y del jugador.
     * @param jugador El jugador principal.
     * @param enemigo El enemigo actual.
     */
	public void mostrarCaracteristicas(Luchador jugador, Modelo enemigo) {
		JOptionPane.showMessageDialog(null,"Vamos a repasar vuestros stats:");
		JOptionPane.showMessageDialog(null,jugador.toString());
		JOptionPane.showMessageDialog(null, enemigo.toString());
	}
	
	/** 
     * Calcula el resultado de las elecciones.
     * @param maniobraJugador Maniobra escogida por el jugador.
     * @param maniobraEnemigo Maniobra escogida por el enemigo.
     * @param jugador El jugador principal.
     * @param enemigo El enemigo actual.
     */
	public void calculoManiobra(int maniobraJugador, int maniobraEnemigo, Luchador jugador, Modelo enemigo) {
		Moneda eneATK = new Moneda(enemigo.getPATK(), enemigo.getNivel());
		Moneda luATK = new Moneda(jugador.getPATK(), jugador.getNivel());
	    Moneda eneDEF = new Moneda(enemigo.getPDEF(), enemigo.getNivel());
	    Moneda luDEF = new Moneda(jugador.getPDEF(), jugador.getNivel());
	    
	  //Casos en los que el jugador usa Ataque
		if(maniobraJugador == 0 && maniobraEnemigo == 0) {
			jugador.setPv(jugador.getPv() - eneATK.getCara());
			enemigo.setPv(enemigo.getPv() - luATK.getCara());
			if(eneATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			if(luATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			JOptionPane.showMessageDialog(null,"Ambos hab�is elegido atacar. Ambos result�is da�ados.");
			JOptionPane.showMessageDialog(null,"Has inflingido " + luATK.getCara() + " de da�o.");
			JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + eneATK.getCara() + " de da�o.");
		}
		if(maniobraJugador == 0 && maniobraEnemigo == 1) {
			if(eneDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			enemigo.setPv(enemigo.getPv() + eneDEF.getCara());
			JOptionPane.showMessageDialog(null,"El enemigo se ha curado, su vida actual es " + enemigo.getPv());
		}
		if(maniobraJugador == 0 && maniobraEnemigo == 2) {
			if(luATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			JOptionPane.showMessageDialog(null,"El enemigo ha resultado da�ado.");
			enemigo.setPv(enemigo.getPv() - luATK.getCara());
			JOptionPane.showMessageDialog(null,"Has inflingido " + luATK.getCara() + " de da�o.");
			
		}
		if(maniobraJugador == 0 && maniobraEnemigo == 3) {
			if(luATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			JOptionPane.showMessageDialog(null,"El enemigo ha resultado da�ado.");
			enemigo.setPv(enemigo.getPv() - luATK.getCara());
			JOptionPane.showMessageDialog(null,"Has inflingido " + luATK.getCara() + " de da�o.");
		}
		
		
		//Casos en los que el jugador usa Defensa
		if(maniobraJugador == 1 && maniobraEnemigo == 0) {
			if(luDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			jugador.setPv(jugador.getPv() + luDEF.getCara());
			JOptionPane.showMessageDialog(null,"Te has curado, tu vida actual es " + jugador.getPv());
			
		}
		if(maniobraJugador == 1 && maniobraEnemigo == 1) {
			if(eneDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			if(luDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			JOptionPane.showMessageDialog(null," Ambos os cur�is.");
			jugador.setPv(jugador.getPv() + luDEF.getCara());
			enemigo.setPv(enemigo.getPv() + eneDEF.getCara());
			JOptionPane.showMessageDialog(null,"Te has curado, tu vida actual es " + jugador.getPv());
			JOptionPane.showMessageDialog(null,"El enemigo se ha curado, su vida actual es " + enemigo.getPv());
		}
		if(maniobraJugador == 1 && maniobraEnemigo == 2) {
			if(eneDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La accion enemiga ha resultado critica");
			}
			JOptionPane.showMessageDialog(null,"Has resultado da�ado.");
			jugador.setPv(jugador.getPv() - (eneDEF.getCara() *2 ));
			JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + (eneDEF.getCara() *2 ) + " de da�o.");
		}
		if(maniobraJugador == 1 && maniobraEnemigo == 3) {
			double aleatorio = Math.random();
			if(aleatorio < 0.5) {
				if(eneATK.isGolpeCritico()) {
					JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
				}
				jugador.setPDEF(jugador.getPDEF() - eneATK.getCara());
				if(jugador.getPDEF() < 1) {
					jugador.setPDEF(1);
				}
				JOptionPane.showMessageDialog(null,"Has resultado penalizado en DEFENSA. Tu DEFENSA actual es de " + jugador.getPDEF());
			}
			else {
				if(eneATK.isGolpeCritico()) {
					JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
				}
				jugador.setPATK(jugador.getPATK() - eneATK.getCara());
				if(jugador.getPATK() < 1) {
					jugador.setPATK(1);
				}
				JOptionPane.showMessageDialog(null,"Has resultado penalizado en ATAQUE. Tu ATAQUE actual es de " + jugador.getPATK());
			}
		}
		
		//Casos en los que el jugador usa Enga�o
		if(maniobraJugador == 2 && maniobraEnemigo == 0) {
			if(eneATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			JOptionPane.showMessageDialog(null,"Has resultado da�ado.");
			jugador.setPv(jugador.getPv() - eneATK.getCara());
			JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " +  eneATK.getCara() + " de da�o.");
		}
		if(maniobraJugador == 2 && maniobraEnemigo == 1) {
			if(luDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			enemigo.setPv(enemigo.getPv() - (luDEF.getCara() * 2));;
			JOptionPane.showMessageDialog(null,"El enemigo ha resultado da�ado.");
			JOptionPane.showMessageDialog(null,"Has inflingido " + (luDEF.getCara() * 2) + " de da�o.");
		}
		if(maniobraJugador == 2 && maniobraEnemigo == 2) {
			jugador.setPv(jugador.getPv() - eneDEF.getCara());
			if(eneDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			if(luDEF.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"Tu acci�n ha resultado cr�tica");
			}
			enemigo.setPv(enemigo.getPv() - luDEF.getCara());
			JOptionPane.showMessageDialog(null,"Ambos result�is da�ados.");
			JOptionPane.showMessageDialog(null,"Has inflingido " + luDEF.getCara() + " de da�o.");
			JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + eneDEF.getCara() + " de da�o.");
		}
		if(maniobraJugador == 2 && maniobraEnemigo == 3) {
			double aleatorio = Math.random();
			if(eneATK.isGolpeCritico()) {
				JOptionPane.showMessageDialog(null,"La acci�n enemiga ha resultado cr�tica");
			}
			if(aleatorio < 0.5) {
				jugador.setPDEF(jugador.getPDEF() - eneATK.getCara());
				if(jugador.getPDEF() < 1) {
					jugador.setPDEF(1);
				}
			}
			else {
				jugador.setPATK(jugador.getPATK() - eneATK.getCara());
				if(jugador.getPATK() < 1) {
					jugador.setPATK(1);
				}
			}
		}
		
		//Casos en los que el jugador usa Maniobra
		//Continuar desde aqui a�adiendo el if
		if(maniobraJugador == 3 && maniobraEnemigo == 0) {
			
			jugador.setPv(jugador.getPv() - eneATK.getCara());
		}
		if(maniobraJugador == 3 && maniobraEnemigo == 1) {
			double aleatorio = Math.random();
			if(aleatorio < 0.5) {
				enemigo.setPDEF(enemigo.getPDEF() - luATK.getCara());
				if(enemigo.getPDEF() < 1) {
					enemigo.setPDEF(1);
				}
				JOptionPane.showMessageDialog(null,"Has resultado penalizado en DEFENSA. Tu DEFENSA actual es de " + jugador.getPDEF());
			}
			else {
				enemigo.setPATK(enemigo.getPATK() - luATK.getCara());
				if(enemigo.getPATK() < 1) {
					enemigo.setPATK(1);
					JOptionPane.showMessageDialog(null,"Has resultado penalizado en ATAQUE. Tu ATAQUE actual es de " + jugador.getPATK());
				}
			}
		}
		if(maniobraJugador == 3 && maniobraEnemigo == 2) {
			double aleatorio = Math.random();
			if(aleatorio < 0.5) {
				enemigo.setPDEF(enemigo.getPDEF() - luATK.getCara());
				if(enemigo.getPDEF() < 1) {
					enemigo.setPDEF(1);
				}
				JOptionPane.showMessageDialog(null, "El enemigo ha resultado penalizado en DEFENSA. Su DEFENSA actual es de " + enemigo.getPDEF());
			}
			else {
				enemigo.setPATK(enemigo.getPATK() - luATK.getCara());
				if(enemigo.getPATK() < 1) {
					enemigo.setPATK(1);
				}
				JOptionPane.showMessageDialog(null, "El enemigo ha resultado penalizado en ATAQUE. Su ATAQUE actual es de " + enemigo.getPATK());
			}
		}
		if(maniobraJugador == 3 && maniobraEnemigo == 3) {
			double aleatorio = Math.random();
			double aleatorio2 = Math.random();
			if(aleatorio < 0.5) {
				enemigo.setPDEF(enemigo.getPDEF() - luATK.getCara());
				if(enemigo.getPDEF() < 1) {
					enemigo.setPDEF(1);
				}
				JOptionPane.showMessageDialog(null,"El enemigo ha resultado penalizado en DEFENSA. Su DEFENSA actual es de " + enemigo.getPDEF());
			}
			else {
				enemigo.setPATK(enemigo.getPATK() - luATK.getCara());
				if(enemigo.getPATK() < 1) {
					enemigo.setPATK(1);
				}
				JOptionPane.showMessageDialog(null,"El enemigo ha resultado penalizado en ATAQUE. Su ATAQUE actual es de " + enemigo.getPATK());
			}
			if(aleatorio2 < 0.5) {
				jugador.setPDEF(jugador.getPDEF() - eneATK.getCara());
				if(jugador.getPDEF() < 1) {
					jugador.setPDEF(1);
				}
				JOptionPane.showMessageDialog(null,"Has resultado penalizado en DEFENSA. Tu DEFENSA actual es de " + jugador.getPDEF());
			}
			else {
				jugador.setPATK(jugador.getPATK() - eneATK.getCara());
				if(jugador.getPATK() < 1) {
					jugador.setPATK(1);
				}
				JOptionPane.showMessageDialog(null, "Has resultado penalizado en ATAQUE. Tu ATAQUE actual es de " + jugador.getPATK());
			}
			
		}
		
		//Casos en los que el jugador usa Curacion
		if(maniobraJugador == 4 && maniobraEnemigo == 0) {
			if(jugador.getPocionesCuracion() > 0) {
				jugador.setPocionesCuracion(jugador.getPocionesCuracion() - 1);
				jugador.setPv(jugador.getPvMax());
				JOptionPane.showMessageDialog(null, "Has utilizado una de tus pociones de curaci�n. Has recuperado todos tus puntos de salud. \n Tu salud actual es: " + jugador.getPv());
				jugador.setPv(jugador.getPv() - eneATK.getCara());
				JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + eneATK.getCara() + " de da�o.");
			}
			else {
				JOptionPane.showMessageDialog(null, "No te quedan pociones de curaci�n. No se ha podido realizar la acci�n. \n Tu salud actual es: " + jugador.getPv());
				jugador.setPv(jugador.getPv() - eneATK.getCara());
				JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + eneATK.getCara() + " de da�o.");
			}
		}
		if(maniobraJugador == 4 && maniobraEnemigo == 1) {
			if(jugador.getPocionesCuracion() > 0) {
				jugador.setPocionesCuracion(jugador.getPocionesCuracion() - 1);
				jugador.setPv(jugador.getPvMax());
				JOptionPane.showMessageDialog(null, "Has utilizado una de tus pociones de curaci�n. Has recuperado todos tus puntos de salud. \n Tu salud actual es: " + jugador.getPv());
				enemigo.setPv(enemigo.getPv() + eneDEF.getCara());
				JOptionPane.showMessageDialog(null,"El enemigo se ha curado, su vida actual es " + enemigo.getPv());
			}
			else {
				JOptionPane.showMessageDialog(null, "No te quedan pociones de curaci�n. No se ha podido realizar la acci�n. \n Tu salud actual es: " + jugador.getPv());
				enemigo.setPv(enemigo.getPv() + eneDEF.getCara());
				JOptionPane.showMessageDialog(null,"El enemigo se ha curado, su vida actual es " + enemigo.getPv());
			}
		}
		if(maniobraJugador == 4 && maniobraEnemigo == 2) {
			if(jugador.getPocionesCuracion() > 0) {
				jugador.setPocionesCuracion(jugador.getPocionesCuracion() - 1);
				jugador.setPv(jugador.getPvMax());
				JOptionPane.showMessageDialog(null, "Has utilizado una de tus pociones de curaci�n. Has recuperado todos tus puntos de salud. \n Tu salud actual es: " + jugador.getPv());
				JOptionPane.showMessageDialog(null,"Has resultado da�ado.");
				jugador.setPv(jugador.getPv() - (eneDEF.getCara() *2 ));
				JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + (eneDEF.getCara() *2 ) + " de da�o.");
			}
			else {
				JOptionPane.showMessageDialog(null, "No te quedan pociones de curaci�n. No se ha podido realizar la acci�n. \n Tu salud actual es: " + jugador.getPv());
				JOptionPane.showMessageDialog(null,"Has resultado da�ado.");
				jugador.setPv(jugador.getPv() - (eneDEF.getCara() *2 ));
				JOptionPane.showMessageDialog(null,"El enemigo te ha inflingido " + (eneDEF.getCara() *2 ) + " de da�o.");
			}
		}
		if(maniobraJugador == 4 && maniobraEnemigo == 3) {
			if(jugador.getPocionesCuracion() > 0) {
				jugador.setPocionesCuracion(jugador.getPocionesCuracion() - 1);
				jugador.setPv(jugador.getPvMax());
				JOptionPane.showMessageDialog(null, "Has utilizado una de tus pociones de curaci�n. Has recuperado todos tus puntos de salud. \n Tu salud actual es: " + jugador.getPv());
				double aleatorio = Math.random();
				if(aleatorio < 0.5) {
					jugador.setPDEF(jugador.getPDEF() - eneATK.getCara());
					if(jugador.getPDEF() < 1) {
						jugador.setPDEF(1);
					}
					JOptionPane.showMessageDialog(null,"Has resultado penalizado en DEFENSA. Tu DEFENSA actual es de " + jugador.getPDEF());
				}
				else {
					jugador.setPATK(jugador.getPATK() - eneATK.getCara());
					if(jugador.getPATK() < 1) {
						jugador.setPATK(1);
					}
					JOptionPane.showMessageDialog(null,"Has resultado penalizado en ATAQUE. Tu ATAQUE actual es de " + jugador.getPATK());
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "No te quedan pociones de curaci�n. No se ha podido realizar la acci�n. \n Tu salud actual es: " + jugador.getPv());
				double aleatorio = Math.random();
				if(aleatorio < 0.5) {
					jugador.setPDEF(jugador.getPDEF() - eneATK.getCara());
					if(jugador.getPDEF() < 1) {
						jugador.setPDEF(1);
					}
					JOptionPane.showMessageDialog(null,"Has resultado penalizado en DEFENSA. Tu DEFENSA actual es de " + jugador.getPDEF());
				}
				else {
					jugador.setPATK(jugador.getPATK() - eneATK.getCara());
					if(jugador.getPATK() < 1) {
						jugador.setPATK(1);
					}
					JOptionPane.showMessageDialog(null,"Has resultado penalizado en ATAQUE. Tu ATAQUE actual es de " + jugador.getPATK());
				}
			}
		}
		if(maniobraJugador == 5) {
			JOptionPane.showMessageDialog(null, "Te has rendido. El combate y la partida finaliza aqu� para t�.");
			jugador.setPv(0);	
		}
		if(maniobraJugador != 5) {
			mostrarCaracteristicas(jugador, enemigo);
		}
	}
}