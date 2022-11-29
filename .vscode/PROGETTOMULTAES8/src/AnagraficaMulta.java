package PROGETTOMULTAES8;

public class AnagraficaMulta {
	private int cod_ana_multa ;
	private String descrizione ;
	private int importo ;
	public AnagraficaMulta(int cod_ana_multa, String descrizione, int importo) {
		super();
		this.cod_ana_multa = cod_ana_multa;
		this.descrizione = descrizione;
		this.importo = importo;
	}
	public int getCod_ana_multa() {
		return cod_ana_multa;
	}
	public void setCod_ana_multa(int cod_ana_multa) {
		this.cod_ana_multa = cod_ana_multa;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getImporto() {
		return importo;
	}
	public void setImporto(int importo) {
		this.importo = importo;
	}
	
}
