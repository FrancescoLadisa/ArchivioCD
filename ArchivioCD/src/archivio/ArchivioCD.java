package archivio;

import java.util.*;
import it.unibs.fp.mylib.*;

public class ArchivioCD {
	
	private Vector<CD> archivio;		//Archivio dei cd
	
	private static final String ELENCO = "Elenco dei CD nell'archivio ";
	private static final String NONPRESENTI = "Non ci sono CD presenti nell'archivio.";
	private static final String ACAPO = "\n";
	
	public ArchivioCD() {
		this.archivio = new Vector<>();
	}
	
	//Inserimento
	public boolean inserireCD(CD cd) {
		
		boolean controllo = ricercaCD(cd), aggiunto = false;
		
		if(!controllo) {
			
			this.archivio.addElement(cd);
			aggiunto = true;
			
		}
		
		return aggiunto;
		
	}
	
	//Ricerca
	public boolean ricercaCD(CD cd) {
		
		String titolo, autore;
		int dimensioni;
		dimensioni = archivio.size();
		boolean controllo = false;
		
		for(int i=0;i<dimensioni;i++) {
			
			titolo = archivio.get(i).getTitolo();
			autore = archivio.get(i).getAutore();
			
			if(titolo.equals(cd.getTitolo()) && autore.equals(cd.getAutore())) {
				
				controllo = true;
				
			}
			
		}
		
		return controllo;
		
	}
	
	//Ricerca tramite titolo e autore
	public CD ricercaCD(String _titolo, String _autore) {
		
		String titolo, autore;
		int dimensioni;
		dimensioni = archivio.size();
		boolean controllo = false;
		CD cd = null;
		
		for(int i=0;i<dimensioni;i++) {
			
			titolo = archivio.get(i).getTitolo();
			autore = archivio.get(i).getAutore();
			
			if(titolo.equals(_titolo) && autore.equals(_autore)) {
				
				cd = archivio.get(i);
				
			}
			
		}
		
		return cd;
		
	}
	
	//Visualizzazione
	public String toString() {
		
		String elenco;
		int dimensioni;
		dimensioni = archivio.size();
		
		elenco = ACAPO + ELENCO + ACAPO;
		
		if(dimensioni > 0) {
			
			for(int i=0;i<dimensioni;i++) {
				
				elenco += archivio.get(i).toString();
				
			}
			
		}
		else {
			elenco += ACAPO + NONPRESENTI + ACAPO;
		}
		
		return elenco;
		
	}
	
	//Eliminazione
	public void eliminaCD(CD cd) {
		
		this.archivio.remove(cd);
		
	}
	
	//Selezione casuale
	public CD selezioneCasuale() {
		
		int dimensioni = archivio.size();
		int random = NumeriCasuali.estraiIntero(0, dimensioni-1);
		return archivio.get(random);
		
	}
	
}
