package archivio;

public class Brano {
	
	private String titolo;	//Titolo del brano 
	private double durata;	//Durata
	
	private static final String TITOLO = "Titolo: ";
	private static final String DURATA = "Durata: ";
	private static final String ACAPO = "\n";
	
	public Brano(String _titolo, double _durata) {
		
		this.titolo = _titolo;
		this.durata = _durata;
		
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public double getDurata() {
		return this.durata;
	}
	
	@Override
	public String toString() {
		return ACAPO + TITOLO + titolo + ACAPO + DURATA + durata;
	}
	
}
