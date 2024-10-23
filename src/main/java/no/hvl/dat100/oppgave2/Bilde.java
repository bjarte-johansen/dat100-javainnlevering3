package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;

public class Bilde extends Tekst {
	private String image_url;
	
	protected Bilde() { 
		super();
	}
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		this(id, bruker, dato, 0, tekst, url);
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);		

		setType("BILDE");
		image_url = url;		
	}
	
	public String getUrl() {
		return image_url;
	}

	public void setUrl(String url) {
		image_url = url;
	}

	@Override
	public String toString() {
		return 
			super.toString() +
			image_url + "\n";
	}
	
	public String fixGithubImageUrl(String s) {
		if(s.contains("https://github.com") && s.contains("/blob")) {
			s = s.replace("https://github.com", "https://raw.githubusercontent.com");
			s = s.replace("/blob", "/refs/heads");	
		}
		return s;
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String result = super.toHTML();		
		String image_url_fixed = fixGithubImageUrl(image_url);
		result += String.format("<p class=\"image\"><img src=\"%s\" alt=\"%s\"></p>\n", image_url_fixed, image_url);
        return result;		
	}
}
