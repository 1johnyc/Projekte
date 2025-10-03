package vierGewinn;

public class Spielfeld {
	// 0 c est pour false // et le numero c est pour true
//	a la base mon tableau de charactere est vide . si l element a la position
//	i,j est vide on affiche 0 sinon on affiche le contenue

	/*
	 * 0 steht für false, und die Nummer steht für true. Ursprünglich ist mein
	 * Zeichen-Array leer. Wenn das Element an Position i,j leer ist, wird 0
	 * angezeigt ansonsten wird der Inhalt angezeigt.
	 */
	String[][] feld;

	Spielfeld() {
		this.feld = new String[6][7];
	}

	Spielfeld(int z, int s) {
		this.feld = new String[z][s];
	}

	public boolean werfen(int sp, String indicename) {
		boolean erg = false;
		for (int i = this.feld.length - 1; i >= 0; i--) {
			for (int j = 0; j < this.feld[i].length; j++) {
				if (sp == j && this.feld[i][j] == null) {
					this.feld[i][sp] = indicename;
					erg = true;
					break;
				}

			}
			if (erg)
				break;// ca ne sert plus a rien de parcourrir notre tableau si on a deja ecrrit a la
//				position voulu . Est tres importante

		}
		return erg;
	}

	public boolean testGewinngemeinsam(String nummer) {

		boolean finalerg = false;
		boolean[] tabbool = new boolean[4];
		tabbool[0] = this.testgewinnH(nummer);
		tabbool[1] = this.testgewinnV(nummer);
		tabbool[2] = this.testgewinnD1(nummer);
		tabbool[3] = this.testgewinnD2(nummer);
		/*
		 * Wenn nur ein einziges Feld in meinem Array den Wert ‚wahr‘ hat, dann soll
		 * ‚wahr‘ zurückgegeben werden. Das bedeutet einfach, dass mein Spieler
		 * überprüft, ob er gewonnen hat. Wenn kein Feld ‚wahr‘ ist, dann wird meine
		 * Variable finalerg am Ende der Durchlaufes den Wert ‚false‘ haben.
		 */

		/*
		 * si une seule case se trouvant dans mon tableau est vraie alors retourne vrai
		 * / ca veut tout simplement dire que mon joueur verifie a gagner donc
		 * automatiquement si rien n est vraie alors ma variable finalerg aura false a
		 * la fin du parcours de mon tableau
		 */
		for (int i = 0; i < tabbool.length; i++) {
			if (tabbool[i]) {
				finalerg = true;
				break;
			}
		}

		return finalerg;
	}

	public boolean testgewinnH(String nummer) {
		boolean resul = false;
		boolean testf = false;

// pour -3? dans le but de pouvoir acceder au case j+1,j+2,j+3
//		vu que mon tableau a 7 colonne 
		// la limite c est que je teste seulement de la gauche vers la droite

//		 je peut plutot faire , connaisant le nummero du joueur, 
//		parcours mon tableau , si tu trouve ce numero dans le tableau ,parcours 3 case en plus et 3 case moins

		/*
		 * Warum -3? Damit ich auf die Felder j+1, j+2, j+3 zugreifen kann. Da mein
		 * Array 7 Spalten hat, besteht die Einschränkung darin, dass ich nur von links
		 * nach rechts teste.
		 * 
		 * Ich könnte stattdessen Folgendes tun: Wenn ich die Spielernummer kenne,
		 * durchlaufe ich mein Array – und wenn ich diese Nummer im Array finde,
		 * durchlaufe ich zusätzlich 3 Felder davor und 3 Felder danach.“
		 */

		for (int i = 0; i < this.feld.length; i++) {
			for (int j = 0; j < this.feld[i].length - 3; j++) {
				if (this.feld[i][j] == nummer && this.feld[i][j + 1] == nummer && this.feld[i][j + 2] == nummer
						&& this.feld[i][j + 3] == nummer) {
					testf = true;
					break;
				}
			}
			if (testf)
				break;
		}
		if (testf)
			resul = true;

		return resul;
	}

	public boolean testgewinnV(String nummer) {
		boolean resul = false;
		boolean testf = false;

		for (int i = 0; i < this.feld.length - 3; i++) { // pour pouvoir acceder aux autre element i+1,i+2,i+3 sans
															// erreur
			// Damit ich auf die anderen Elemente i+1, i+2, i+3 zugreifen kann, ohne einen
			// Fehler zu bekommen.
			for (int j = 0; j < this.feld[i].length; j++) {
				if (this.feld[i][j] == nummer && this.feld[i + 1][j] == nummer && this.feld[i + 2][j] == nummer
						&& this.feld[i + 3][j] == nummer) {
					testf = true;
					break;
				}
			}
			if (testf)
				break;
		}
		if (testf)
			resul = true;

		return resul;
	}

	public boolean testgewinnD1(String nummer) {
		boolean resul = false;
		boolean testf = false;

		for (int i = 0; i < this.feld.length - 3; i++) {
			for (int j = 0; j < this.feld[i].length - 3; j++) {
				if (this.feld[i][j] == nummer && this.feld[i + 1][j + 1] == nummer && this.feld[i + 2][j + 2] == nummer
						&& this.feld[i + 3][j + 3] == nummer) {
					testf = true;
					break;
				}
			}
			if (testf)
				break;
		}
		if (testf)
			resul = true;

		return resul;
	}

	public boolean testgewinnD2(String nummer) {
		boolean resul = false;
		boolean testf = false;

		for (int i = 0; i < this.feld.length - 3; i++) {
			for (int j = this.feld[i].length - 1; j > this.feld[i].length - 3; j--) {
				if (this.feld[i][j] == nummer && this.feld[i + 1][j - 1] == nummer && this.feld[i + 2][j - 2] == nummer
						&& this.feld[i + 3][j - 3] == nummer) {
					testf = true;
					break;
				}
			}
			if (testf)
				break;
		}
		if (testf)
			resul = true;

		return resul;
	}

	public String toString() {
		String erg = new String();
		for (int i = 0; i < this.feld.length; i++) {
			for (int j = 0; j < this.feld[i].length; j++)
				erg += (this.feld[i][j] == null) ? "| 0 " : "| " + this.feld[i][j] + " ";
			erg += "|" + "\n";
		}
//		erg+="\n";
		for (int i = 0; i < this.feld[0].length; i++)
			erg += "----";
		erg += "\n";
		for (int i = 0; i < this.feld[0].length; i++)
			erg += "  " + i + " ";

		erg += "\n";
		return erg;
	}
}
