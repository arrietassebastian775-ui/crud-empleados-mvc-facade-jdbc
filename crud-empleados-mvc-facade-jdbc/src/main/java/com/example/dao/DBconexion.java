package com.example.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBconexion implements AutoCloseable {
	
	private String username;
	private String password;
	private Connection connection;
	
	private static final Logger LOG = Logger.getLogger("DBconexion");
	
	public DBconexion(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// Metodo que establece la conexion a la base de datos 
	
	public Connection getConexion() throws ClassNotFoundException {
		
		String urlConnection = "jdbc:mysql://localhost:3306/empresa-crud-empleados";
		Properties info = new Properties();
		
		info.put("user", this.username);
		info.put("password", this.password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(urlConnection, info);
			LOG.info("Conexion establecida con exito");
		} catch (SQLException e) {
			LOG.info("Error al establecer la conexion a la base de datos: ");
			e.printStackTrace();
		}
		
		return this.connection;
	}

	@Override
	public void close() throws Exception {
		this.connection.close();
		
	}

}
