package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {
	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		String filepath = mappe + filnavn;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			Blogg blogg = new Blogg();

			reader.readLine(); // skip first line
			
			String line = reader.readLine();
			while (line != null) {
				if (line.equals(TEKST)) {
					int id = Integer.parseInt(reader.readLine());
					String bruker = reader.readLine();
					String dato = reader.readLine();
					int likes = Integer.parseInt(reader.readLine());
					String tekst = reader.readLine();
					Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(innlegg);
				} else if (line.equals(BILDE)) {
					int id = Integer.parseInt(reader.readLine());
					String bruker = reader.readLine();
					String dato = reader.readLine();
					int likes = Integer.parseInt(reader.readLine());
					String tekst = reader.readLine();					
					String url = reader.readLine();
					Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(innlegg);
				}
				line = reader.readLine();
			}
			reader.close();
			return blogg;
		} catch (Exception e) {
			System.out.println("Error reading from file: " + filepath);
			return null;
		}

	}
}
