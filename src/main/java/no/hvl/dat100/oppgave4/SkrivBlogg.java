package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		String filepath = mappe + filnavn;
		
		try {
			var writer = new PrintWriter(filepath);		
			writer.print(samling.toString());
			writer.close();
			System.out.println("Wrote to file: " + filepath);
			return true;
		} catch (Exception e) {
			System.out.println("Error writing to file: " + filepath);
			return false;
		}
	}
}
