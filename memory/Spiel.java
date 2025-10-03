package memory;

import java.util.Scanner;

public class Spiel {
	public static Scanner sc = new Scanner(System.in);
	public static Spielfeld sf = new Spielfeld();
	public static int value = 0;

	/*
	 * ich soll nicht vergessen,dass ich das Feld zurücksetzen soll,falls das Spiel
	 * von anfang an gestartet wird
	 */

//	n'oublie pas de reinitialiser le tableau avant le jeu , 
//	au cas ou le jeu recommence

	public static void menu() {

		do {
			System.out.println("MEMORY\n" + "1 - Ein neues Spiel starten \r\n" + "2 - Programm beenden ");
			Spiel.value = sc.nextInt();

		} while (Spiel.value < 1 && Spiel.value > 2);
	}

	public static boolean zug(Spieler spl) {
		/* die Tatsache,dass diese Methode einen Wert zurückliefert */
//		le fait que cette methode retourne une valeur a ete un point decisif

		int x = 1;
		int y = 2;
		int z1, z2, s1, s2;
		z1 = z2 = s1 = s2 = 0;
		System.out.println(spl.getName() + " ist an der Reihe");
		System.out.println(sf.toString());
		do {
			System.out.println("Zeile " + x);
			z1 = sc.nextInt();
			System.out.println("Spalte " + x);
			s1 = sc.nextInt();

		} while (z1 < 0 || z1 > sf.getFeld().length - 1 || s1 < 0 || s1 > sf.getFeld().length - 1);
		System.out.println("An der Stelle befindet sich ein  " + sf.getChar(z1, s1));

		do {
			System.out.println("Zeile " + y);
			z2 = sc.nextInt();
			System.out.println("Spalte " + y);
			s2 = sc.nextInt();

		} while (z2 < 0 || z2 > sf.getFeld().length - 1 || s2 < 0 || s2 > sf.getFeld().length - 1);
		System.out.println("An der Stelle befindet sich ein  " + sf.getChar(z2, s2));

		return sf.uebereinstimmungTest(z1, s1, z2, s2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char c='A';
//		if(c+32=='a')
//			System.out.print(true);
		boolean exit = false;
		Spieler sp1;
		Spieler sp2;

		menu();
		while (!exit) {

			if (Spiel.value == 1) {
//				ici reset tableau a non decouvert
				sf.resetFeld();
				System.out.println("Geben Sie den Namen von Spieler 1 ein:  \r\n");
				sp1 = new Spieler(sc.next());// une pierre 2 coup
				System.out.println("Geben Sie den Namen von Spieler 2 ein:  \r\n");
				sp2 = new Spieler(sc.next());

				/*
				 * Solange nicht alle Positionen aufgedeckt sind, wird das Spiel fortgesetzt.
				 * Spieler 1 ist dran – ein Stein, zwei Schläge, denn er erlaubt dem Spieler,
				 * Werte einzugeben.
				 */
				while (!sf.testgewinn()) { // tantque toutes les positions ne sont pas decouvert on continue le jeu
					if (zug(sp1))// joueuer 1 dran,une pierre 2 coup car elle permet au joueur d entrer des
									// valeurs
						sp1.setPunkt(1);
					sp1.liefernPunkt(sp2);// affiche l etat des points
					if (zug(sp2)) // joueur 2
						sp2.setPunkt(1);
					sp2.liefernPunkt(sp1);

				}

			}
//
			if (Spiel.value == 2)
				exit = true;
		}

	}

}
