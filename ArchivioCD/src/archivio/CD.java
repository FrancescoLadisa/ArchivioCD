package archivio;

import java.util.*;
import it.unibs.fp.mylib.NumeriCasuali;

public class CD {
	
	private String titolo;			//Titolo del cd
	private String autore;			//Autore
	private Vector<Brano> cd;		//Collezione dei brani = CD
	
	private static final String TITOLO = "Titolo: ";
	private static final String AUTORE = "Autore: ";
	private static final String ACAPO = "\n";
	private static final String BRANI = "Elenco dei brani contenuti all'interno: ";
	private static final String NONPRESENTI = "Non ci sono brani all'interno del CD.";
	private static final String TRATTINO = " - ";
	
	//Costruttore del cd
	public CD(String _titolo, String _autore) {
		
		this.titolo = _titolo;
		this.autore = _autore;
		cd = new Vector<>();
		
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public String getAutore() {
		return this.autore;
	}
	
	//Aggiunta dei brani al cd
	public boolean aggiungiBrano(Brano brano) {
		
		int dimensione;
		boolean presente = false, aggiunto = false;
		
		dimensione = cd.size();
			
		for(int i=0;i<dimensione;i++) {
			
			if(cd.get(i).equals(brano)) {
				presente = true;
			}
			
		}
		
		//Se il brano esiste gia' allora non lo aggiungo nuovamente
		if(!presente) {
			cd.addElement(brano);
			aggiunto = true;
		}
		
		return aggiunto;
		
	}
	
	//Selezione casuale di un brano
	public Brano selezioneCasuale() {
		
		int dimensione, random;
		
		dimensione = cd.size();
		random = NumeriCasuali.estraiIntero(0, dimensione);
		
		return cd.get(random);
		
	}
	
	//Selezione a scelta
	public Brano selezioneScelta(int i) {
		
		return cd.get(i);
		
	}
	
	//Restituzione stringa descrittiva
	public String toString() {
		
		String canzoni, elenco = "", titoloBrano, durata;
		int dimensione;
		dimensione = cd.size();
		
		canzoni = ACAPO + TITOLO + titolo + ACAPO + AUTORE + autore + ACAPO + BRANI + ACAPO;
		
		if(dimensione > 0) {
			
			for(int i=0;i<dimensione;i++) {
				
				titoloBrano = cd.get(i).getTitolo();
				durata = String.valueOf(cd.get(i).getDurata());
				elenco += titoloBrano + TRATTINO + durata + ACAPO; 
				
			}
			
		}
		else {
			canzoni += ACAPO + NONPRESENTI + ACAPO;
		}
		
		canzoni += elenco;
		return canzoni;
		
	}
	
}
