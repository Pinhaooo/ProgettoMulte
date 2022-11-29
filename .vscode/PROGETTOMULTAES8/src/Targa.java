package PROGETTOMULTAES8;
public class Targa {
	private String targa ;
	private String cognome;
	private String nome ;
	private String indirizzo;
	private String citta ;
	public Targa(String targa, String cognome, String nome, String indirizzo, String citta) {
		super();
		this.targa = targa;
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
}
