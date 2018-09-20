
public class AgendaGiornaliera {
	private String docente;
	private int giorno;
	private Studente[] appuntamenti;
	
	public String getDocente() {
		return docente;
	}
	public int getGiorno() {
		return giorno;
	}
	
	public int getNumeroAppuntamentiGiornalieri() {
		return this.appuntamenti.length;
	}
	
	public AgendaGiornaliera(String docente, int giorno, int numeroAppuntamentiGiornalieri) {
		this.docente=docente;
		this.giorno=giorno;
		this.appuntamenti=new Studente[numeroAppuntamentiGiornalieri];
	}
	
	public AgendaGiornaliera(String docente, int giorno) {
		this(docente,giorno,6);
	}
	
	public Studente getStudente(int slot) {
		for(int i=0; i<this.appuntamenti.length;i++) {
			if(i==slot)
				return appuntamenti[i];
		}
		return null;
	}
	
	public boolean isLibero(int slot) {
		if(slot<0)
			return false;
		if(slot>=this.appuntamenti.length)
			return false;
		if(this.appuntamenti[slot]==null)
			return true;
		else
			return false;	
	}
	
	private boolean esisteAppuntamento(Studente studente) {
		if (studente==null)
			return false;
		for(int i=0; i<this.appuntamenti.length;i++) {
			if(appuntamenti[i]!=null && appuntamenti[i].equals(studente))
				return true;
		}
		return false;
	}
	
	
	public boolean prenota(Studente studente) {
		if(studente==null)
			return false;
		for(int i=0; i<this.appuntamenti.length;i++) {
			if(appuntamenti[i]!=null && appuntamenti[i].equals(studente))
				return false;
		}
		for(int i=0; i<this.appuntamenti.length;i++) {
			if(appuntamenti[i]==null) {
				appuntamenti[i]=studente;
				return true;
			}
		}
		return false;
	}
		
	public boolean prenota(Studente studente, int orario) {
		if(studente==null)
			return false;
		if(esisteAppuntamento(studente))
			return false;
		if(!isLibero(orario))
			return false;
		if(appuntamenti[orario]==null) {
			appuntamenti[orario]=studente;
			return true;
		}
		return false;
	}
	
	public boolean annulla(Studente studente) {
		if(studente==null)
			return false;
		for(int i=0; i<this.appuntamenti.length;i++) {
			if(appuntamenti[i]!=null && appuntamenti[i].equals(studente)) {
				appuntamenti[i]=null;
				return true;
			}
		}
		return false;
	}
}