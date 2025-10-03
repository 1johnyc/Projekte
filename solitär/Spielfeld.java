package solitär;

public class Spielfeld {
	private int n = 5;
	private boolean[][] feld;

	public Spielfeld() {
		this.feld = new boolean[this.n][this.n];
		this.feld[n / 2][n / 2] = true; // laut der Aufgabestellung
	}

	public Spielfeld(int n) {
		this.n = n;
		this.feld = new boolean[this.n][this.n];
		this.feld[n / 2][n / 2] = true;// laut der Aufgabestellung
	}

	public boolean zug(int z, int s, char richtung) { // true==leer und False==#
//		NB true pour vide et false pour #
		boolean erg = false;
		if (richtung == 'r') {
			/*
			 * Man prüft, ob s + 2 kleiner ist, damit kein Fehler entsteht. Andernfalls
			 * würde folgender Fehler auftreten: Sie versuchen, auf eine Position im Array
			 * zuzugreifen, die nicht existiert. Diese Bedingung muss als erste stehen.
			 */
//	  on verifie sie s+2 est inferieur pour qu on ait pas une erreur 
//	  sinon on aurait une erreur suivante: vous essayez d acceder a une position du tableau qui n existe pas
//	  cette condition doit etre la premiere
			if (s + 2 < this.feld[0].length && this.feld[z][s] == false && this.feld[z][s + 1] == false
					&& this.feld[z][s + 2] == true) {
				this.feld[z][s] = true;
				this.feld[z][s + 1] = true;
				this.feld[z][s + 2] = false;
				erg = true;
			}

		}
		if (richtung == 'l') {
			if (s - 2 >= 0 && this.feld[z][s] == false && this.feld[z][s - 1] == false && this.feld[z][s - 2] == true) {
				this.feld[z][s] = true;
				this.feld[z][s - 1] = true;
				this.feld[z][s - 2] = false;
				erg = true;
			}
		}
		if (richtung == 'o') {
			if (z - 2 >= 0 && this.feld[z][s] == false && this.feld[z - 1][s] == false && this.feld[z - 2][s] == true) {
				this.feld[z][s] = true;
				this.feld[z - 1][s] = true;
				this.feld[z - 2][s] = false;
				erg = true;
			}
		}
		if (richtung == 'u') {
			if (z + 2 < this.feld.length && this.feld[z][s] == false && this.feld[z + 1][s] == false
					&& this.feld[z + 2][s] == true) {
				this.feld[z][s] = true;
				this.feld[z + 1][s] = true;
				this.feld[z + 2][s] = false;
				erg = true;
			}
		}

		return erg;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public boolean gewonnen() {
		int zaehler = 0;
		for (int i = 0; i < this.feld.length; i++)
			for (int j = 0; j < this.feld[i].length; j++)
				if (!this.feld[i][j])
					zaehler++;

		return (zaehler == 1) ? true : false;
	}

	public boolean[][] getFeld() {
		return feld;
	}

	public String toString() {
		String erg = new String();
		for (int i = 0; i < this.feld.length; i++)
			erg += "\t" + i;
		erg += "\n";
		for (int i = 0; i < this.feld.length; i++) {
			erg += i + "\t";
			for (int j = 0; j < this.feld[i].length; j++)
				erg += (this.feld[i][j] == false) ? "#" + "\t" : "-" + "\t";
			erg += "\n";
		}
		return erg;

	}
}
