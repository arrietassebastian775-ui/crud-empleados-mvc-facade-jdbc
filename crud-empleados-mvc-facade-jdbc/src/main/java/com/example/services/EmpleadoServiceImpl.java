package com.example.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.DBconexion;

public class EmpleadoServiceImpl implements EmpleadoService {

	@Override
	public boolean isConnectionOK() throws SQLException  {
		// Conectar con la capa DAO
		DBconexion dbConexion = new DBconexion("root", "Temp2026");
		
		boolean connectionOK = false;
		
		
		// TODO: cerrar la conexion
		
		Connection conn = null;
		try {
			conn = dbConexion.getConexion();
					if (conn != null);
				       connectionOK = true;
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) 
			    conn.close();
		}
		
		return connectionOK;
	}
	

	}


