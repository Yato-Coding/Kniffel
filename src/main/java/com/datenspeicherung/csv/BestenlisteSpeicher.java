package main.java.com.datenspeicherung.csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import main.java.com.fachkonzept.Endstand;

// TODO
// awful mishmash of error handling to somehow try not to break RAII every step of the way
public class BestenlisteSpeicher implements AutoCloseable {
	// this is bad
	File file = new File("kniffel.csv");

	public BestenlisteSpeicher() {
		if (file.length() == 0) {
			try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
				String[] header = new String[] {"name", "punkte"};
				writer.writeNext(header);
			} 
			catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	@Override
	public void close() {
		// TODO
	}

	public Endstand[] liesEndstandAusSpeicher() {
		ArrayList<Endstand> endstaende = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			// i dont know if i hate or like this
			String[] nextLine;
			reader.readNext();

			while((nextLine = reader.readNext()) != null){
				endstaende.add(new Endstand(nextLine[0], Integer.parseInt(nextLine[1])));
			}
		} 
		catch (CsvValidationException | IOException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return endstaende.toArray(new Endstand[0]);
	}

	public void schreibeEndstandInSpeicher(Endstand pEndstand) {
		try (CSVWriter writer = new CSVWriter(new FileWriter("kniffel.csv", true))) {
			String name = pEndstand.liesName();
			String punkte = Integer.toString(pEndstand.liesPunkte());
			String[] row = new String[]{name, punkte};
			writer.writeNext(row);
		} 
		catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
