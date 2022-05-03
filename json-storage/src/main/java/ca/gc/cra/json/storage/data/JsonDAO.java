package ca.gc.cra.json.storage.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class JsonDAO {
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM records";
	private static final String SQL_INSERT_DATA = "INSERT INTO records (data) VALUES(\'";
	private static final String SQL_INSERT_DATA_END = "\')";
	
	private static final String DB_TYPE = "jdbc:postgresql";
	private static final String DB_HOST = "epayrollerrordb"; //"errorpostgresql-eda-epayroll-poc.apps.ocp4.omega.dce-eir.net"
	private static final String DB_PORT = "5432";
	
	private static final String BACKUP_DB_NAME = "epayrollerrordb";
	private static final String BACKUP_USER_NAME = "user8YI";
	private static final String BACKUP_PASSWORD = "KnDie2l7bimY6pRM";
	
	private Connection connection;
	
	private Connection getConnection() {
		if (connection == null) {

			String dbName = System.getenv("DB_NAME");
			String user = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");

			if (dbName == null) {
				dbName = BACKUP_DB_NAME;
				user = BACKUP_USER_NAME;
				password = BACKUP_PASSWORD;
			}

			String url = DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + dbName;

			System.out.println("Connecting: " + url + " using: " + user);

			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("Failed to connect to DB");
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection to DB");
				e.printStackTrace();
			}
			
			connection = null;
		}
	}
	
	public List<JsonRecord> getAllJsonRecords() {
		List<JsonRecord> result = new ArrayList<>();

		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

			while (rs.next()) {
				JsonRecord record = new JsonRecord();
				record.setId(rs.getLong(1));
				record.setJson(new JSONObject(rs.getString(2)));

				result.add(record);
			}

			closeConnection();
		} catch (SQLException e) {
			System.out.println("Failed to execute SELECT");
			e.printStackTrace();
			closeConnection();
		}

		return result;
	}

	public boolean saveJsonRecord(JSONObject data) {
		boolean result = false;
		
		try {
			Statement statement = getConnection().createStatement();
			int rows = statement.executeUpdate(
					SQL_INSERT_DATA + 
					data.toString() +
					SQL_INSERT_DATA_END);

			result = (rows == 1);
			
			getConnection();
		} catch (SQLException e) {
			System.out.println("Failed to execute INSERT");
			e.printStackTrace();
			getConnection();
		}
	
		return result;
	}
}
