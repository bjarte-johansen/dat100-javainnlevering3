package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {	
	private int id;
	private String type;
	private String user;
	private String date;
	private int likes;
	
	protected Innlegg() {} // hide default constructor
	
	protected Innlegg(int id, String bruker, String dato) {
		this(id, bruker, dato, 0);
	}

	protected Innlegg(int id, String bruker, String dato, int likes) {
		this.id = id;
		this.type = "FEIL";		
		this.user = bruker;
		this.date = dato;
		this.likes = likes;
	}
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	public String getBruker() { return user; }
	public void setBruker(String bruker) { user = bruker; }

	public String getDato() { return date; }
	public void setDato(String dato) { date = dato;	}

	public int getId() { return id; }

	public int getLikes() { return likes; }
	public void setLikes(int likes) { this.likes = likes; }
	public void doLike () { likes++; }
	
	public boolean erLik(Innlegg post) {	return this.id == post.id; }
	
	@Override
	public String toString() {
		String fmt = "%d\n%s\n%s\n%d\n";
		return String.format(fmt, id, user, date, likes);				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		var sb = new StringBuilder(1024);
		sb.append(String.format("<p class=\"id\">%d</p>\n", id));
		sb.append(String.format("<p class=\"user\">%s</p>\n", user));
		sb.append(String.format("<p class=\"date\">%s</p>\n", date));
		sb.append(String.format("<p class=\"likes\">&#128077; %d</p>\n", likes));
		return sb.toString();
	}
}
