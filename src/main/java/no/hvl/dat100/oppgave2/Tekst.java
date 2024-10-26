package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {
	// TODO: objektvariable
	private String text;	
	
	protected Tekst () {
		super();
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		this(id, bruker, dato, 0, tekst);
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.setType("TEKST");
		this.text = tekst;
	}
	
	public String getTekst() {
		return text;
	}

	public void setTekst(String tekst) {
		text = tekst;
	}

	@Override
	public String toString() {
		return getType() + "\n" + super.toString() + text + "\n";
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		//String sId = String.format("<span class=\"id\">%d</span>\n", getId());
		String sUser = String.format("<span class=\"user\">%s</span>\n", getBruker());		
		String sLikes = String.format("<span class=\"likes\">&#128077 %d</span>\n", getLikes()); 
		String sDate = String.format("<span class=\"date\">%s</span>\n", getDato());		
		String sContent = "Skrevet av " + sUser + ", " + sDate + ", " + sLikes + "<br>" + "<p class=\"text\">" + getTekst() + "</p>";
        return String.format("<div class=\"content\">%s</div>\n", sContent);		
	}
}
