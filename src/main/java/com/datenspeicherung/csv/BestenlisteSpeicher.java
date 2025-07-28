package main.java.com.datenspeicherung.csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

import main.java.com.fachkonzept.Endstand;

public class BestenlisteSpeicher implements AutoCloseable {

	public BestenlisteSpeicher() throws Exception {

	}

	@Override
	public void close() throws Exception {
		return;
	}

	public Endstand[] liesEndstandAusSpeicher() {
		return null;
	}

	public void schreibeEndstandInSpeicher(Endstand pEndstand) {
		return;
	}
}
