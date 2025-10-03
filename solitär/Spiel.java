
package solitär;

import java.util.Scanner;

public class Spiel {
	/*
	 * Ich habe nicht berücksichtigt, dass der Benutzer andere Richtungswerte
	 * eingeben könnte als (l, r, o, u).
	 */

	// je nai pas pris en compte le fait que l utilisateur entre d autre valeur de
	// direction en dehors de (l,r,o,u)

	private static Scanner sc = new Scanner(System.in);
	private static Spielfeld sf = new Spielfeld(4);
	private static int value1 = 0; // Werte von Menue
	private static int zeile;
	private static int Spalte;
	private static char rcht;// richtung
	private static char aufg = 'n'; // Abbruchbedingung 1
	private static boolean continu1 = false;// Abbruchbedingung 2 der While-schleife
	// condition d arret 2 de la boucle while

	private static void menu() {

		do {
			System.out.println("1 Ein neues Spiel starten ");
			System.out.println("2  Programm beenden ");
			value1 = sc.nextInt();

		} while (value1 < 1 || value1 > 2);
//		while(!(value >=1 && value1<=2))

	}

	private static void spielzuege() {
		/*
		 * Diese Bedingung wird immer funktionieren, da die Anzahl der Zeilen gleich
		 * der Anzahl der Spalten ist.
		 */
//		cette condition marchera toujours car nombre de zeile egal nombre de spalte
		do {
			System.out.println("Welchen Pin moechten Sie bewegen?");
			System.out.println("Zeile");
			Spiel.zeile = sc.nextInt();
			System.out.println("Saplte");
			Spiel.Spalte = sc.nextInt();
		} while (Spiel.zeile > sf.getFeld().length || Spiel.zeile < 0 || Spiel.Spalte > sf.getFeld().length
				|| Spiel.Spalte < 0);

//		 Dieser Teiler kann besser gemacht werden
		System.out.println("In welche Richtung (o/u/l/r) soll der Pin bewegt werden? ");
		Spiel.rcht = sc.next().charAt(0);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;

		/*
		 * Diese Bedingung ist notwendig und hilft mir sicherzustellen, dass das Spiel
		 * neu gestartet wird . egal ob der Spieler gewonnen oder aufgegeben hat.
		 */

		while (!exit) { // cette condition est necessaire et m aide a faire en sorte que le jeu reprenne
						// peut import si le joueuer a gagner ou abandonner
//			             le jeu ne reprendra ssi le joueuer a choisi l option 2

			menu();
			if (Spiel.value1 == 1) {
				System.out.println(Spiel.sf.toString());

				/*
				 * Solange der Benutzer nicht aufgegeben hat, läuft die Schleife weiter. Deshalb
				 * habe ich meine Variable aufg mit ‚nein‘ (‚n‘) initialisiert.
				 */

				/*
				 * tantque l utilisateur n a pas abandonner ,la boucle continue pour ca jai
				 * initialiser ma variable aufg a nein(n)
				 */
				while (Spiel.aufg == 'n' && !Spiel.continu1) {

					spielzuege();
					sf.zug(Spiel.zeile, Spiel.Spalte, Spiel.rcht);
					System.out.println(sf.toString());
					Spiel.continu1 = sf.gewonnen();//
					System.out.println("Moechten sie aufgeben?");
					Spiel.aufg = sc.next().charAt(0);
//				 comment ecrire une condition de telle sorte que le programme s arrete lorsque le joueur abandonne ou continu soit vrai
				}

				if (Spiel.aufg == 'j')
					System.out.println("Sie haben aufgegeben");
				if (sf.gewonnen())
					System.out.println("Sie haben gewonnen");

			}

			if (Spiel.value1 == 2) {
				System.out.println("Das Programm wird beendet");
				exit = true;
			}
		}

	}
}
