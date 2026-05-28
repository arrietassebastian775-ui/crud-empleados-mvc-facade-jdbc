package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Empleado;

public interface EmpleadoService {
	
	// Metodo para comprobar la conexion a la base de datos
	boolean isConnectionOK() throws SQLException, Exception;
	List<Empleado> getEmpleados();
	

}
