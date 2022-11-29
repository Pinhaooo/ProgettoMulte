package PROGETTOMULTAES8;
public class Multa {
	private int cod_multa;
	private String targa;
	private String data;
	
	public Multa(int cod_multa, String targa, String data) {
		super();
		this.cod_multa = cod_multa;
		this.targa = targa;
		this.data =  data;
	}
	public int getCod_multa() {
		return cod_multa;
	}
	public void setCod_multa(int cod_multa) {
		this.cod_multa = cod_multa;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
