package com.example.services;

import java.sql.Connection;

import com.example.dao.DBconexion;

public class EmpleadoServiceImpl implements EmpleadoService {

	@Override
	public boolean isConnectionOK() throws Exception  {
		
		boolean connectionOK = false;

		
		try (DBconexion dbConexion = new DBconexion("root", "Temp2026");
				Connection conn = dbConexion.getConexion()) {
			
					if (conn != null)
						
				       connectionOK = true;
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return connectionOK;
	}
	

	}


