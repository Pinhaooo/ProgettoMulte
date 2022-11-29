package PROGETTOMULTAES8;

import java.time.chrono.ThaiBuddhistChronology;

public class TabulatoMulte {
	private static String FILE = "C:/Users/Hp/todo-app/.vscode/PROGETTOMULTAES8/tabulato.pdf";
	private int codiceMulta ;
	private String descrizione ;
	private int importo ;
	private String cognome ;
	private String nome ;
	private String data;
	private String targa;
	public TabulatoMulte(int codiceMulta, String descrizione, int importo, String cognome, String nome, String data,
			String targa) {
		
		this.codiceMulta = codiceMulta;
		this.descrizione = descrizione;
		this.importo = importo;
		this.cognome = cognome;
		this.nome = nome;
		this.data = data;
		this.targa = targa;
	}
	public int getCodiceMulta() {
		return codiceMulta;
	}
	public void setCodiceMulta(int codiceMulta) {
		this.codiceMulta = codiceMulta;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public stampaTabella (){
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			aggiungiPrefazione(document);
			Paragraph prefazione = new Paragraph();

			prefazione.add(new Paragraph("Codice Multa =" + this.getCodiceMulta()));

			aggiungiLineaVuota(prefazione, 2);

			prefazione.add(new Paragraph("Descrizione =" + this.getDescrizione()));

			aggiungiLineaVuota(prefazione, 2);

			prefazione = new Paragraph("Importo :" + this.getImporto());
						
			prefazione.setAlignment(Element.ALIGN_RIGHT);


			document.add(prefazione);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);


			PdfPTable tabella = new PdfPTable(4);

			PdfPCell c1 = new PdfPCell(new Phrase("Cognome"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setGrayFill(0.8f);
			tabella.addCell(c1);

			c1 = new PdfPCell(new Phrase("Nome"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setGrayFill(0.8f);
			tabella.addCell(c1);

			c1 = new PdfPCell(new Phrase("Data"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setGrayFill(0.8f);
			tabella.addCell(c1);

			c1 = new PdfPCell(new Phrase("Targa"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setGrayFill(0.8f);
			tabella.addCell(c1);
			tabella.addCell("1");
			tabella.addCell("2");
			tabella.addCell("3");
			tabella.addCell("4");
		
			
			tabella.addCell(this.getCognome());
			tabella.addCell(this.getNome());
			tabella.addCell(this.getData());
			tabella.addCell(this.getTarga());

			document.add(tabella);
	
			tabella.setHeaderRows(1);

			document.close();
		}catch(IOException|

	DocumentException e)
	{
		e.printStackTrace();
	}
	}
	private static void aggiungiPrefazione(Document document) throws DocumentException {
		Paragraph prefazione = new Paragraph();

		aggiungiLineaVuota(prefazione, 2);

		Paragraph paragraph = new Paragraph("Citt� di torino", bigFont);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		aggiungiLineaVuota(prefazione, 2);

		paragraph = new Paragraph("Tabulato riepigativo di multe");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(prefazione);
	}

	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {

		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(""));
		}
	}

}
