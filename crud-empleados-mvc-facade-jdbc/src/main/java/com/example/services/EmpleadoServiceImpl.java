package com.example.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.dao.DBconexion;
import com.example.models.Empleado;
import com.example.models.Genero;

public class EmpleadoServiceImpl implements EmpleadoService {
	
	private static final Logger Log = Logger.getLogger("EmpleadoServiceImpl");
		
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

	@Override
	public List<Empleado> getEmpleados() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		try (DBconexion dbConexion = new DBconexion("root", "Temp2026");
				Connection connection = dbConexion.getConexion()) {
			
			ResultSet rs = dbConexion.getEmpleados(connection);
			
			while (rs.next()) {
				empleados.add(Empleado.builder()
						.id(rs.getInt("id"))
						.nombre(rs.getString("nombre"))
						.primerApellido(rs.getString("primerApellido"))
						.SegundoApellido(rs.getString("segundoApellido"))
						.fechaAlta(rs.getDate("fechaAlta").toLocalDate())
						.genero(Genero.valueOf(rs.getString("genero")))
						.salario(new BigDecimal(rs.getDouble("salario")))
						.departamentos_id(rs.getInt("departamentos_id"))
						.build());
			}
		} catch (Exception e) {
			Log.severe("Error al recuperar los empleados: " + e.getMessage());
			e.printStackTrace();
		}	
		return empleados;
	}
	

	}


