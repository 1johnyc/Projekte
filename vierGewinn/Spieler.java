package vierGewinn;

public class Spieler {
	private String name;
	private String nummer;// au depart c etait int
	public static int inianzahl = 0;

	Spieler() {
		this.name = "Computer";
		this.nummer = "" + ++inianzahl; /*
										 * Cette notation etait decisif pour reussir mon programme this.nummer =
										 * ++inianzahl; les numero etant attribuer automatiquement , jai un probleme
										 * lorsque je teste le contenu de mon tableau comment mettre la valeur de nummer
										 * dans mon tableau de charactere sans utiliser de methode de cast . dois je
										 * changer le type de mon tableau de feld? sans utliser une methode predefinie
										 * par le langage
										 */

		/*
		 * Diese Notation war entscheidend, um mein Programm erfolgreich umzusetzen:
		 * this.nummer = ++inianzahl; Da die Nummern automatisch vergeben werden, habe
		 * ich ein Problem, wenn ich den Inhalt meines Arrays teste. Wie kann ich den
		 * Wert von nummer in mein Zeichen-Array (char[]) einfügen, ohne eine
		 * Cast-Methode zu verwenden? Muss ich den Typ meines Arrays feld ändern? Und
		 * zwar ohne eine vom Sprachstandard vorgegebene Methode zu verwenden.
		 */

	}

	Spieler(String name) {
		this.name = name;
		this.nummer = "" + ++inianzahl; // cette ligne est important surtout les Anführungszeichen.,
//		sans ca, j avais un soucis lors de l affichage de ma methode toString . 

		/*
		 * Diese Zeile ist wichtig, besonders die Anführungszeichen. Ohne sie hatte ich
		 * ein Problem bei der Anzeige meiner toString-Methode.
		 */
	}

	public String getName() {
		return this.name;
	}

	public String getNummer() {
		return this.nummer;
	}
}
