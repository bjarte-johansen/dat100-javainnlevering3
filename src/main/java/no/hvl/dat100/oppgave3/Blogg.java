package no.hvl.dat100.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {
	private Innlegg[] posts;		// var innleggtabell
	private int length = 0;			// var nesteledge

	// TODO: objektvariable 

	public Blogg() {
		posts = new Innlegg[20];
	}

	public Blogg(int lengde) {
		posts = new Innlegg[lengde];
	}

	public int getAntall() {
		return length;
	}
	
	public Innlegg[] getSamling() {
		return posts;
	}
	
	public int finnInnlegg(Innlegg post) {
		for (int i = 0; i < length; i++) {
			if (posts[i].erLik(post)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg post) {
		return finnInnlegg(post) > -1;
	}

	public boolean ledigPlass() {
		return length < posts.length;
	}
	
	public boolean leggTil(Innlegg post) {
		if (!ledigPlass() || finnes(post)) {
			return false;
		}
		
		posts[length++] = post;
		return true;
	}
	
	public String toString() {
		var sb = new StringBuilder(1024);
		sb.append(length + "\n");
		for (int i = 0; i < length; i++) {
			sb.append(posts[i]);
		}
		return sb.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		posts = Arrays.copyOf(posts, posts.length * 2);
	}
	
	public boolean leggTilUtvid(Innlegg post) {
		if (!ledigPlass()) {
			utvid();
		}
		
		return leggTil(post);		
	}
	
	public boolean slett(Innlegg post) {
		int found_index = finnInnlegg(post);
		if (found_index == -1) {
			return false;
		}

		System.arraycopy(posts, found_index + 1, posts, found_index, length - found_index - 1);

		posts[--length] = null;
		
		return true;
	}

	public int[] search(String keyword) {
		var indexes = new int[length];
		int found = 0;
		for (int i = 0; i < length; i++) {
			if (posts[i].toString().contains(keyword)) {
				indexes[found++] = i;
			}
		}
		return Arrays.copyOf(indexes, found);

	}
}