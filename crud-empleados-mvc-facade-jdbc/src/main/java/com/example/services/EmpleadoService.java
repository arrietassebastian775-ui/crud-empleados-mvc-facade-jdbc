package com.example.services;

import java.sql.SQLException;

public interface EmpleadoService {
	
	// Metodo para comprobar la conexion a la base de datos
	public abstract boolean isConnectionOK() throws SQLException;

}
