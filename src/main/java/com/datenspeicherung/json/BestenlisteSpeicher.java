package main.java.com.datenspeicherung.json;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.com.fachkonzept.Endstand;

public class BestenlisteSpeicher implements AutoCloseable{
	private final File file;

	public BestenlisteSpeicher() throws Exception{
		file = new File("kniffel.json");
		if (!file.exists()) {
			try (FileWriter writer = new FileWriter(file)) {
				writer.write("[]");
			} catch (IOException e) {
				throw new IOException(e);
			}
		}
	}

	@Override
	public void close() {
		// noop
	}

	public Endstand[] liesEndstandAusSpeicher() {
		ArrayList<Endstand> endstaende = new ArrayList<>();
		try (FileReader reader = new FileReader(file)) {
			Gson gson = new Gson();
			// this is very weird
			Type type = new TypeToken<List<Endstand>>() {}.getType();
			List<Endstand> loaded = gson.fromJson(reader, type);
			if (loaded != null) {
				endstaende.addAll(loaded);
			}
		} 
		catch (IOException e) {
			System.out.println("IOException: " + e.getLocalizedMessage());
		}
		return endstaende.toArray(new Endstand[0]);
	}

	public void schreibeEndstandInSpeicher(Endstand pEndstand) {
		ArrayList<Endstand> endstaende = new ArrayList<>();
		Collections.addAll(endstaende, liesEndstandAusSpeicher());

		endstaende.add(pEndstand);

		try (FileWriter writer = new FileWriter(file)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(endstaende, writer);
		} 
		catch (IOException e) {
			System.out.println("IOException: " + e.getLocalizedMessage());
		}
	}
}

