package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class StokKartiConfiguration {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stoktakip",
					"root", "root");
			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e);
		}

		return conn;

	}

	// private Connection conn;
	//
	// public void connect() throws Exception{
	//
	// if(conn != null) return;
	//
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// } catch (ClassNotFoundException e) {
	// throw new Exception("No database");
	// }
	//
	// String connectionURL = "jdbc:mysql://localhost:3306/stoktakip";
	//
	// conn = DriverManager.getConnection(connectionURL, "root", "root");
	// }
	//
	// public void close(){
	// if(conn != null){
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }

}
