package archivio;

import it.unibs.fp.mylib.*;

public class CDMain {
	
	private static final String MENU = "Menu' principale dell'archivio";
	private static final String AGGIUNGICD = "Aggiungi CD alla collezione;";
	private static final String VISUALIZZA = "Visualizza l'archivio di CD;";
	private static final String VISUALIZZACD = "Visualizza un singolo CD;";
	private static final String RIMUOVICD = "Rimuovi un CD dalla collezione;";
	private static final String ESTRAIBRANO = "Estrai un brano casualmente dalla collezione.";
	private static final String AGGIUNGIBRANO = "Aggiungi un brano ad un cd";
	private static final String BRANOAGGIUNTO = "Brano aggiunto con successo al cd.";
	private static final String BRANONONAGGIUNTO = "Il brano non e' stato aggiunto, ritenta.";
	private static final String SCEGLI = "Inserire il numero dell'opzione scelta: ";
	private static final String TITOLOCD = "Inserire il titolo del CD: ";
	private static final String AUTORECD = "Inserire il nome dell'autore del CD: ";
	private static final String TITOLOBRANO = "Inserire il titolo del brano: ";
	private static final String DURATABRANO = "Inserire la durata espressa nel formato mm,ss (Minuti,Secondi): ";
	private static final String CDNONESISTENTE = "CD non esistente nella collezione";
	private static final String AGGIUNTO = "CD aggiunto con successo alla collezione.";
	private static final String NONAGGIUNTO = "Il CD non e' stato aggiunto, riprova.";
	private static final String CONTINUA = "Vuoi effettuare altre operazioni (Rispondi 'si' oppure 'no')? ";
	
	private static final double MINIMODURATA = 0.1;
	
	private static void operazioni(ArchivioCD archivio, int scelta) {
		
		String titolo, autore, titoloBrano;
		double durata;
		boolean aggiunto;
		
		switch(scelta) {
			
			//Utente ha selezionato l'uscita dal programma
			case 0: System.exit(0); 
					break;
			
			//Inserimento di un nuovo CD nella collezione
			case 1: titolo = InputDati.leggiStringaNonVuota(TITOLOCD);
					autore = InputDati.leggiStringaNonVuota(AUTORECD);
					
					CD cd = new CD(titolo, autore);
					aggiunto = archivio.inserireCD(cd);
					
					if(aggiunto) {
						System.out.println(AGGIUNTO);
					}
					else {
						System.out.println(NONAGGIUNTO);
					}
					break;
			
			//Visualizzazione dell'elenco dei CD 
			case 2: String elenco = archivio.toString();
					System.out.println(elenco);
					break;
					
			//Ricerca del CD nell'archivio tramite titolo e autore
			case 3: titolo = InputDati.leggiStringaNonVuota(TITOLOCD);
					autore = InputDati.leggiStringaNonVuota(AUTORECD);
					
					CD ricercato = archivio.ricercaCD(titolo, autore);
					String trovato = ricercato.toString();
					System.out.println(trovato);
					break;
					
			//Inserimento di un nuovo brano nel CD scelto dall'utente
			case 4:	try {
				
						titolo = InputDati.leggiStringaNonVuota(TITOLOCD);
						autore = InputDati.leggiStringaNonVuota(AUTORECD);
						
						CD esistente = archivio.ricercaCD(titolo, autore);
						titoloBrano = InputDati.leggiStringaNonVuota(TITOLOBRANO);
						
						durata = InputDati.leggiDoubleConMinimo(DURATABRANO, MINIMODURATA);
						
						Brano brano = new Brano(titoloBrano, durata);
						
						boolean branoAggiunto = esistente.aggiungiBrano(brano);
						
						if(branoAggiunto) {
							System.out.println(BRANOAGGIUNTO);
						}
						else {
							System.out.println(BRANONONAGGIUNTO);
						}
						
					}catch(NullPointerException e) {
						System.out.println(CDNONESISTENTE);
					}
					break;
			
			//Eliminazione del CD scelto
			case 5: titolo = InputDati.leggiStringaNonVuota(TITOLOCD);
					autore = InputDati.leggiStringaNonVuota(AUTORECD);
					
					CD eliminare = archivio.ricercaCD(titolo, autore);
					archivio.eliminaCD(eliminare);
					break;
					
			//Estrazione casuale di un brano dall'archivio
			case 6: CD casuale = archivio.selezioneCasuale();
					Brano scelto = casuale.selezioneCasuale();
					String branoScelto = scelto.toString();
					System.out.println(branoScelto);
					break;
			
			default:break;
					
		}
		
	}
	
	public static void main(String[] args) {
		
		String sceltaContinuazione;
		boolean continuare = true;
		
		//Istanza di ArchivioCD per la creazione di un archivio
		ArchivioCD archivio = new ArchivioCD();
		
		//Voci del menu
		String[] voci = {AGGIUNGICD,VISUALIZZA,VISUALIZZACD,AGGIUNGIBRANO,RIMUOVICD,ESTRAIBRANO};
		
		//Creazione del menu con le relative voci
		MyMenu menu = new MyMenu(MENU,voci);
		
		int scelta;
		
		//Finche' l'utente vuole continuare stampa il menu e esegue le operazioni selezionate
		while(continuare) {
			
			//Stampa del menu
			menu.stampaMenu();
			
			//Selezione della voce
			scelta = InputDati.leggiIntero(SCEGLI);
			
			//Esecuzione dell'operazione scelta
			operazioni(archivio, scelta);
			
			//Chiede se vuole effettuare altre operazioni
			sceltaContinuazione = InputDati.leggiStringaNonVuota(CONTINUA).toLowerCase();
			
			if(sceltaContinuazione.equals("no")) {
				continuare = false;
			}
			
		}
		
	}

}
