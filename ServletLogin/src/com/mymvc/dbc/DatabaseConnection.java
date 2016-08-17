package com.mymvc.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	private Properties prop = new Properties();// π§æﬂ¿‡
	private Connection conn;
	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;

	public DatabaseConnection() throws Exception {
		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("Myconfig.properties"));

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}

}
