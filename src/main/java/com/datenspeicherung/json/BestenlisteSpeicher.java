package main.java.com.datenspeicherung.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.fachkonzept.Endstand;

// TODO
// implement
public class BestenlisteSpeicher implements AutoCloseable {

	public BestenlisteSpeicher() throws Exception {
	}

	@Override
	public void close() throws Exception {
	}

	public Endstand[] liesEndstandAusSpeicher() {
	}

	public void schreibeEndstandInSpeicher(Endstand pEndstand) {
	}
}
