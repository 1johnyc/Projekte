package vierGewinn;

import java.util.Scanner;
import java.util.Random;
/*Ich habe diesen Teil noch nicht implementiert: Wenn insgesamt 42 Spielsteine gespielt wurden,
 *  ohne dass ein Spieler gewonnen hat, endet das Spiel unentschieden.“*/

/* je nai pas encore inplementer cette partie ci dessous
Sind insgesamt 42 Spielsteine gespielt, ohne dass ein Spieler 
gewonnen hat, so endet das Spiel unentschieden */

/*ich habe nicht berücksichtigt,dass der Nutzer eine Meldung erhalten sollte,wenn er versucht,
 * seinen Spielstein in eine Reihe zu setzen,die bereits voll ist.
 */

// je nai pas pris en compte le fait que, lorsqu'une rangee est pleine le Nutzer recoit un message 
//s il essai de mettre son pion laba

public class Spiel {
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
	public static boolean testgewinn1 = false;// spieler 1
	public static boolean testgewinn2 = false;// spieler 2 .der kann der computer sein
	public static Spielfeld sf = new Spielfeld();
	public static int value = 0; // pour choix , je lai choisi pour l option 1
	public static boolean test = false;
	public static int spaltecommune = -1;
	/*
	 * Ich wähle diese Zahl, weilmeine Bedingungin derSchleife immer erfüllt sein
	 * wird–im Grunde läuft die Schleife also so lange weiter,bis der Benutzer eine
	 * gültige Zahl eingibt.
	 */

	/*
	 * je choisi ce chiffre car ma condition dans ma boucle sera toujours verifier
	 * ,en gros la la boucle tounera toujours, jusqu a ce que le user entre une
	 * chiffre juste
	 */

	public static void menu() {
		System.out.println("VIER GEWINNT\n" + "1 – Ein Spieler\n" + "2 – Zwei Spieler\n" + "3 – Programm beenden");
	}

	public static void resetGame() {
		Spiel.testgewinn1 = false;
		Spiel.testgewinn2 = false;
		Spiel.test = false;
		Spiel.spaltecommune = -1;
		Spiel.sf = new Spielfeld(); // Réinitialiser le terrain de jeu
		Spiel.value = 0; // Réinitialiser la valeur pour le menu
	}

	public static void zug(Spieler s) {

		/*
		 * Diese Methode kann auch anders geschrieben werden – ich habe hier ein
		 * bisschen clever gespielt. Ich habe den Code in zwei Abschnitte mit if und
		 * else unterteilt. Da die Spalte automatisch gewählt wird, wenn der Computer am
		 * Zug ist, war es zwingend notwendig, einen Codeabschnitt zu schreiben, der
		 * diesen Fall behandelt.
		 */

//		cette methode peut etre reecrite autrement .jai jouer l intelligent ici
//		 jai inplementer ce code en 2 compartiment if et else.
//		vu que le Spalte est choisi automatiquement lorsque c est le tour de l ordinateur(Computeur) , 
//		il etait  donc imperatif  d ecrire une portion de code qui gere ce cas
		System.out.println(s.getName() + " ist an der Reihe");
		if (s.getName().length() < 5) {
			while (!Spiel.test) {
				System.out.println("Spalte");
				Spiel.spaltecommune = sc.nextInt();
				if (Spiel.spaltecommune >= 0 && Spiel.spaltecommune < sf.feld[0].length) {
					sf.werfen(Spiel.spaltecommune, s.getNummer());
					Spiel.test = true;
				}

			}
		} else {
			while (!Spiel.test) {
				if (Spiel.spaltecommune >= 0 && Spiel.spaltecommune < sf.feld[0].length) {
					sf.werfen(Spiel.spaltecommune, s.getNummer());
					Spiel.test = true;
				}

			}

		}
	}

//	public static booolean testGewinngemeinsam() {
//		boolean erg=
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub1
		boolean exit = false;
		Spieler sp1; // je les ai declare hors de la boucle pour pouvoir avoir acces a leur contenu
						// hors du bloc if
		Spieler sp2;

		/*
		 * Ich habe sie außerhalb der Schleife deklariert, damit ich auf ihren Inhalt
		 * auch außerhalb des if-Blocks zugreifen kann
		 */
		while (!exit) {

			while (!(value >= 1 && value <= 3)) {
				menu();
				Spiel.value = sc.nextInt();
			}

			if (Spiel.value == 1) {
				System.out.println("geben sie den Name des Spielers ein");

				sp1 = new Spieler(sc.next());// une pierre deux coup
				System.out.println(sp1.getName());
				sp2 = new Spieler(); // le joueur 2 ici c est l ordinateur . der spieler hier ist der computer
				// pour test gewinn debut de condition ici // Bedingunganfang
				System.out.println(sf.toString());
				while (!Spiel.testgewinn1 && !Spiel.testgewinn2) {

					zug(sp1); // tour du joueuer1
					System.out.println(sf.toString());
					Spiel.testgewinn1 = sf.testGewinngemeinsam(sp1.getNummer());
					if (Spiel.testgewinn1)
						break;
					Spiel.test = false;/*
										 * pourquoi je le fais ,je pars du principe que si le premier joueuer a pu jouer
										 * il faudrait automatiquement que l ordinateur joue, sinon on n entrera jamais
										 * dans la boucle. Eine andere möglichkeit?
										 */
					/*
					 * Warum mache ich das? Ich gehe davon aus, dass, wenn der erste Spieler
					 * gespielt hat, der Computer automatisch spielen muss ansonsten würde man nie
					 * in die Schleife eintreten
					 */
					Spiel.spaltecommune = r.nextInt(sf.feld[0].length);
					zug(sp2);// tour machine
					System.out.println(sf.toString());
					Spiel.testgewinn2 = sf.testGewinngemeinsam(sp2.getNummer());
					if (Spiel.testgewinn2)
						break;
					Spiel.test = false; /*
										 * remettre a false pour permettre au joueuer 1 de rejouer sinon il gardera la
										 * derniere valeur lu et affichera un message apres la fin du jeu
										 */
					/*
					 * Auf ‚false zurücksetzen, damit Spieler 1 erneut spielen kann – ansonsten
					 * würde die letzte gelesene Eingabe gespeichert bleiben und nach Spielende eine
					 * Nachricht angezeigt werden.
					 */

				}
				if (Spiel.testgewinn1) {
					System.out.println(sp1.getName() + " hat gewonnen");
					resetGame();
				}
				if (Spiel.testgewinn2) {
					System.out.println(sp2.getName() + " hat gewonnen");
					resetGame();
					/*
					 * cette ligne est tres importante cette ligne resoud le probleme ci dessous
					 * prend en copte le fait que toute les variables soit partager, le jeu etant
					 * terminer, si l utilisateur essaie de rejouer, le programme ne fonctionne plus
					 * comme prevu solution je cree une methode pour reinitiliser mes variables
					 */

					/*
					 * Diese Zeile ist sehr wichtig. Sie löst das folgende Problem: Sie
					 * berücksichtigt, dass alle Variablen gemeinsam genutzt werden. Wenn das Spiel
					 * beendet ist und der Benutzer versucht, erneut zu spielen, funktioniert das
					 * Programm nicht mehr wie vorgesehen. Die Lösung: Ich erstelle eine Methode, um
					 * meine Variablen zurückzusetzen.
					 */

				}
			}
			if (Spiel.value == 2) {
//				 cette partie du code est presque la meme que la  partie du haut(entre 1 joueur et l ordinateur)
				/*
				 * Dieser Teil des Codes ist fast derselbe wie der obere Abschnitt (zwischen
				 * einem Spieler und dem Computer)
				 */
				System.out.println("geben sie den Name des Spielers ein");
				sp1 = new Spieler(sc.next());
				System.out.println("geben sie den Name des Spielers ein");
				sp2 = new Spieler(sc.next());
				System.out.println(sf.toString());
				while (!Spiel.testgewinn1 && !Spiel.testgewinn2) {

					zug(sp1); // tour du joueuer1
					System.out.println(sf.toString());
					Spiel.testgewinn1 = sf.testGewinngemeinsam(sp1.getNummer());
					if (Spiel.testgewinn1)
						break;
					Spiel.test = false;
					zug(sp2);
					System.out.println(sf.toString());
					Spiel.testgewinn2 = sf.testGewinngemeinsam(sp2.getNummer());
					if (Spiel.testgewinn2)
						break;
					Spiel.test = false;

				}
				if (Spiel.testgewinn1) {
					System.out.println(sp1.getName() + " hat gewonnen");
					resetGame();
				}
				if (Spiel.testgewinn2) {
					System.out.println(sp2.getName() + " hat gewonnen");
					resetGame();

				}
				if (Spiel.value == 3) {
					exit = true;
				}

			}

		}
	}
}
