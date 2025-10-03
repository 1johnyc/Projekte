package memory;

public class Spieler {
	private String name;
	private int punkt;
	
	
	Spieler(String name){
	this.name=name;	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPunkt() {
		return punkt;
	}


	public void setPunkt(int punkt) {
		this.punkt += punkt;
	}
	
	public void liefernPunkt(Spieler s) {
		System.out.println("Der aktuelle Spielstand lautet:  ");
		System.out.println(this.getName()+" : "+" "+this.getPunkt() );
		System.out.println(s.getName()+" : "+" "+s.getPunkt() );
	}

}
