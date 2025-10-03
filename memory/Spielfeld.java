package memory;

import java.util.Random;

public class Spielfeld {
	private int zeile;
	private int spalte;
	private char[][] feld;
	private boolean[][] bfeld;

	Spielfeld() {
		this.zeile = 4;
		this.spalte = 6;
		this.feld = new char[this.zeile][this.spalte];
		this.bfeld = new boolean[this.zeile][this.spalte];
		this.initiaFeld(); // sobald ein Feld erzeugt ist,wird es initialisiert

	}

	Spielfeld(int z, int s) {
		/*
		 * Es könnte ein Problem auftreten, wenn z ≠ 4 und s ≠ 6, denn das Array wurde
		 * zuerst 12-mal mit Großbuchstaben und danach 12-mal mit Kleinbuchstaben
		 * initialisiert. Das Array hat insgesamt (4 × 6) = 24 Felder. Das bedeutet,
		 * wenn sich die Größe des Arrays ändert, kann die Initialisierung problematisch
		 * werden.
		 */

		// il risque se poser un probleme si z!=4 et s!=6 car
//		le tableau a d abord ete initialiser avec des majuscule 12 fois ensuite minsc 12 fois . le tableau ayant (4*6)=24 cases en tout
//		ceci veut dire que si la taille du tableau change l initialisation du tableau peut etre problematique
		this.zeile = z;
		this.spalte = s;
		this.feld = new char[this.zeile][this.spalte];
		this.bfeld = new boolean[this.zeile][this.spalte];
		this.initiaFeld(); // sobald ein Feld erzeugt ist,wird es initialisiert

	}

	public void resetFeld() {
		for (int i = 0; i < this.bfeld.length; i++)
			for (int j = 0; j < this.bfeld[i].length; j++) {
				this.bfeld[i][j] = false; // Setze alle meine Felder wieder auf nicht aufgedeckt
//				remet toute mes case a non decouvert
			}

		/*
		 * Dann initialisiere ich mein Array – ich kann auf diese Zeile verzichten, denn
		 * das Boolean-Array ist das wichtigste, das zurückgesetzt werden muss, da es
		 * entscheidet, ob eine Position angezeigt wird oder nicht.
		 */
//	this.initiaFeld(); // ensuite initialise mon tableau , je peux me passer de cette ligne 
//		car c est le tableau de boolean le plus important a reset car c est lui qui decide si une position sera afficher ou pas
	}

	public char[][] getFeld() {
		return feld;
	}

	public boolean[][] getBfeld() {
		return bfeld;
	}

	public char getChar(int z, int s) {
		return this.feld[z][s];
	}

	public boolean uebereinstimmungTest(int z1, int s1, int z2, int s2) {
		/*
		 * Da A = 65 und a = 97 ist, geht man davon aus, dass man, wenn man A kennt,den
		 * Kleinbuchstaben a durch 65 + 32 erhält. Das gilt für alle Buchstaben – man
		 * muss einfach nur +32 addieren.
		 */

//		vu que A=65 une a=97
//		on part du principe que connaissant A ,pour avoir petit a on fait 65+32:
//		CECI est valable pour toute les lettres ajouter tout simple +32
		char c = this.feld[z1][s1];
		if (c + 32 == this.feld[z2][s2]) {
			this.bfeld[z1][s1] = true;// Rend les visible s ils coincident
			this.bfeld[z2][s2] = true;// rend les visible
			return true;
		}

		return false;// aus cas ou iol nya pas de coincidance
	}
//	

	public boolean testgewinn() {
		/*
		 * angenonnem dass alle Stellen im Feld bfeld bei der Initialisierung bei false
		 * liegen. das heißt in diesem Fall ,kein stelle ist aufgedeckt. die methode
		 * liefert true ,wenn alle Stelle aufgedeckt sind .dementsprechend muss das
		 * Spiel aufgehört und den Stand des Spiels gezeigt werden.
		 */

		for (int i = 0; i < this.bfeld.length; i++)
			for (int j = 0; j < this.bfeld[i].length; j++) {
				if (!this.bfeld[i][j])
					return false;

			}
		return true;// cette valeur sera retourner lorsque tous les champs auront la valeur true
	}

	public void initiaFeld() {
		int rd1;
		int rd2;
		/*
		 * Warum 76? Ursprünglich soll mein Array laut Aufgabe mit den Buchstaben von A
		 * bis L und von a bis l gefüllt werden. Da A den ASCII-Wert 65 hat, B
		 * entsprechend 66 usw. ergeben die Buchstaben von A bis L insgesamt 12 Zeichen.
		 * Also: 65 + 11 = 76 (man zählt den ersten Buchstaben nicht nochmal). Ich
		 * initialisiere mein Array zuerst mit Großbuchstaben (daher die Bedingung in
		 * meiner Schleife), danach mit Kleinbuchstaben. Anschließend mische ich die
		 * Werte zufällig
		 */

//		pourquoi 76 . a la base selon l exercice mon tableau dopit etre rempli de A Bis L  et a bis l.
//		vu que A=65; forcement B=66 etc. et de A a L font 12 caractere . en gros 65+11 =76(on n e compte plus le premier caractere)
//		J initialise mon tableau avec les carctere majuscule(d ou la condition dans ma boucle) ensuite les miniscule.
//		ensuite je permute au hazard
		Random r = new Random();
		// dient zur initialisierung
		char c = 65;
		char x = 97;
		int test = c;
		for (int i = 0; i < this.feld.length; i++)
			for (int j = 0; j < this.feld[i].length; j++) {
				if (test <= 76) {
					this.feld[i][j] = c;
					c++;
					test = c;
				} else {
					this.feld[i][j] = x;
					x++;
				}

			}

		for (int i = this.feld.length - 1; i >= 0; i--)
			for (int j = this.feld[0].length - 1; j >= 0; j--) {
				rd1 = r.nextInt(i + 1);
				rd2 = r.nextInt(j + 1);
				char w = this.feld[i][j];
				this.feld[i][j] = this.feld[rd1][rd2];
				this.feld[rd1][rd2] = w;
			}

	}

	public String toString() {
		/*
		 * true bedeutet, dass es aufgedeckt wurde. false bedeutet, dass es noch nicht
		 * aufgedeckt wurde. Achte darauf, das Array bfeld vom Array feld zu
		 * unterscheiden . es handelt sich um zwei verschiedene Arrays.
		 */

//		true veut dire il a ete decouvert
//		false veut dire qu il n as pas encore ete decouvert
//		fait attention de differencier le tableau bfeld de feld. il s agit de 2 tableaux different
		String erg = "";
		for (int i = 0; i < this.bfeld.length; i++) {
			for (int j = 0; j < this.bfeld[i].length; j++) {
				erg += (this.bfeld[i][j]) ? this.feld[i][j] + "\t" : '-' + "\t";
			}
			erg += "\n";
		}

		return erg;
	}

}
