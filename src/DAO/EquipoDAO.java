package DAO;

import BEAN.Empleado;
import BEAN.Equipo;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class EquipoDAO {
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    public Equipo buscarEquipo(int id) {
        Equipo equipo = new Equipo();
        Empleado empleado;
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Equipos WHERE id_equipo = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                equipo.setId_equipo(resultSet.getInt(1));
                empleado = empleadoDAO.buscarEmpleado(resultSet.getInt(2));
                equipo.setUsuario(empleado);
                equipo.setMarca(resultSet.getString(3));
                equipo.setModelo(resultSet.getString(4));
                equipo.setNum_serie(resultSet.getString(5));
                equipo.setEstado(resultSet.getInt(6));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return equipo;
    }
    
    public Vector<Equipo> listarEquipos(boolean siFiltrar, String filtro) {
        Vector<Equipo> equipos = new Vector<Equipo>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Equipos";
        ResultSet resultSet;
        Equipo equipo;
        
        if(siFiltrar) {
            sql = sql + " WHERE modelo LIKE '%" + filtro + "%' OR marca LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                equipo = new Equipo();
                equipo.setId_equipo(resultSet.getInt(1));
                Empleado empleado = empleadoDAO.buscarEmpleado(resultSet.getInt(2));
                equipo.setUsuario(empleado);
                equipo.setMarca(resultSet.getString(3));
                equipo.setModelo(resultSet.getString(4));
                equipo.setNum_serie(resultSet.getString(5));
                equipo.setEstado(resultSet.getInt(6));
                equipos.add(equipo);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return equipos;
    }
    
    
    public boolean registrarEquipo(Equipo equipo, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
        
        if (procedimiento.toLowerCase().equals("insert")) {
            sql = "INSERT INTO Equipos VALUES("
                    + equipo.getId_equipo() + ", " + equipo.getUsuario().getId_empleado() + ", '" + equipo.getMarca() + "', '"
                    + equipo.getModelo() + "', '" + equipo.getNum_serie() + "', " + equipo.getEstado() + ")";
        } else if(procedimiento.toLowerCase().equals("update")) {
            sql = "UPDATE Equipos SET id_usuario = " + equipo.getUsuario().getId_empleado() + ", marca = '" + equipo.getMarca()
                    + "', modelo = '" + equipo.getModelo() + "', num_serie = '" + equipo.getNum_serie() + "', estado = " + equipo.getEstado()
                    + " WHERE id_equipo = " + equipo.getId_equipo();
        }
        
        System.out.println(sql);
        
        try {
            db.insUpd(sql);
            sw = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
            sw = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sw;
    }
}