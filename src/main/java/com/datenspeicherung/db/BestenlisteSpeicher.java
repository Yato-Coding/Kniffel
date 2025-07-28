package main.java.com.datenspeicherung.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.fachkonzept.Endstand;

// TODO
// refactor where we're throwing exceptions
public class BestenlisteSpeicher implements AutoCloseable {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public BestenlisteSpeicher() throws Exception {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kniffel", "root", null);
		} catch (Exception e) {
			throw new SQLException("Fehler beim Oeffnen der Datenbank!" + System.lineSeparator() + e.getLocalizedMessage());
		}
	}

	@Override
	public void close() throws Exception {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			throw new SQLException("Fehler beim Schliessen der Datenbank!" + System.lineSeparator() + e.getLocalizedMessage());
		}
	}

	public Endstand[] liesEndstandAusSpeicher() {
		String sqlStmt = "SELECT *";
		sqlStmt += "FROM endstand";

		ArrayList<Endstand> endstaende = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sqlStmt);
			rs = stmt.executeQuery();

			while (rs.next()) {
				endstaende.add(new Endstand(rs.getString("name"), rs.getInt("punkte")));
			}
		} catch (Exception e) {
			System.out.println("Fehler beim Lesen der Endstaende: " + System.lineSeparator() + e.getLocalizedMessage());
		}
		return endstaende.toArray(new Endstand[0]);
	}

	public void schreibeEndstandInSpeicher(Endstand pEndstand) {
		String sqlStmt = "INSERT INTO endstand(name, punkte)";
		sqlStmt += "VALUES (?, ?)";

		try {
			stmt = con.prepareStatement(sqlStmt);
			stmt.setString(1, pEndstand.liesName());
			stmt.setInt(2, pEndstand.liesPunkte());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Fehler beim Schreiben der Endstaende: " + System.lineSeparator() + e.getLocalizedMessage());
		}
	}
}
