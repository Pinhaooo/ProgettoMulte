package PROGETTOMULTAES8;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

public class AnagraficaMulte4 {

//	private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

	public static void main(String[] args) {
		String path = "multe.txt";
		String path2 = "anagraficamulte.txt";
		String path3 = "targhe.txt";
		ArrayList<Multa> Ma = new ArrayList<Multa>();
		ArrayList<AnagraficaMulta> Am = new ArrayList<AnagraficaMulta>();
		ArrayList<Targa> Ta = new ArrayList<Targa>();
		ArrayList<TabulatoMulte> Tm = new ArrayList<TabulatoMulte>();
		ArrayList<AnagraficaMulta> multeMancanti = new ArrayList<AnagraficaMulta>();
		// Stringhe

		try {

			// multe arary list
			ArrayList<String[]> legMulte = readFile(path);
			for (String[] i : legMulte) {
				Multa a = new Multa(Integer.parseInt(i[0]), (i[1]), (i[2]));
				Ma.add(a);
			}
			// anagraficamulte array list
			ArrayList<String[]> legAm = readFile(path2);
			for (String[] i : legAm) {
				AnagraficaMulta b = new AnagraficaMulta(Integer.parseInt(i[0]), (i[1]), Integer.parseInt(i[2]));
				Am.add(b);
			}
			// targhe array list
			ArrayList<String[]> legTarga = readFile(path3);
			for (String[] i : legTarga) {
				Targa c = new Targa((i[0]), (i[1]), (i[2]), (i[3]), (i[4]));
				Ta.add(c);
			}
			Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();

			// inizio il for qui
			for (Multa m : Ma) {
				if (hashtable.containsKey(m.getCod_multa())){
				for (AnagraficaMulta a : Am) {
					if (m.getCod_multa() == a.getCod_ana_multa()) {
						for (Targa t : Ta) {
							String targa = t.getTarga();
							if (targa.equals(m.getTarga())) {
								TabulatoMulte tabulato = new TabulatoMulte(a.getCod_ana_multa(), a.getDescrizione(),
										a.getImporto(), t.getCognome(), t.getNome(), m.getData(), m.getTarga());
								Tm.add(tabulato);
							}
						}
					} else 
						multeMancanti.add(m.getCod_multa, m);
					
				}
				}else {
					hashtable.put(m.getCod_multa,null);
				}
			}
			//sysout di multemancanti
			// System.out.println("mancano queste multe-----" + (multeMancanti));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//syst out per controllo dei array
		//System.out.println(Tm.size() + " "  +  Ma.size());
		//System.out.println(multeMancanti.size());
		//for (TabulatoMulte t : Tm ) {
			//System.out.println(t.getCodiceMulta());
		//}
		
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
			TabulatoMulte.aggiungiPrefazione();
			for (TabulatoMulte g : Tm) {
				g.stampaTabella();
			
				 for (Multa multa : hashtable.values()){
					
					if (g.getCodiceMulta()== multa.getCod_multa){
						g.stampaTabella();
					}else {
						document.newPage();
						g.aggiungiPrefazione();
					}

				 }
			}

	}// qui la fine del main

	public static ArrayList<String[]> readFile(String fileName) throws IOException {
		try {
			FileReader reader = new FileReader(fileName);

			BufferedReader buffer = new BufferedReader(reader);
			String row;
			ArrayList<String[]> table = new ArrayList<String[]>();

			while ((row = buffer.readLine()) != null) {
				String attributes[] = row.split("-");
				table.add(attributes);
			}

			buffer.close();

			return table;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("error in readFile function");
		}
	}

	

}// qui la classe
