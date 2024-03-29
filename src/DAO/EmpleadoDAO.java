package DAO;

import BEAN.Empleado;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class EmpleadoDAO {
    
    public Empleado buscarEmpleado(int id) {
        Empleado empleado = new Empleado();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Empleados WHERE id_empleado = " + id;
        
        try {
            ResultSet resultSet = db.execSql(sql);
            
            while(resultSet.next()) {
                empleado.setId_empleado(resultSet.getInt(1));
                empleado.setApellidos(resultSet.getString(2));
                empleado.setNombres(resultSet.getString(3));
                empleado.setTipo(resultSet.getInt(4));
                empleado.setArea(resultSet.getString(5));
                empleado.setEstado(resultSet.getInt(6));
            }
                
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return empleado;
    }
    
    public Vector<Empleado> listarEmpleados(boolean siFiltrar, String filtro) {
        Vector<Empleado> empleados = new Vector<Empleado>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Empleados";
        ResultSet resultSet;
        Empleado empleado;
        
        if(siFiltrar) {
            sql = sql + " WHERE apellidos LIKE '%" + filtro + "%' OR nombre LIKE '%" + filtro + "%'";
        }
        
        try{
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                empleado = new Empleado();
                empleado.setId_empleado(resultSet.getInt(1));
                empleado.setApellidos(resultSet.getString(2));
                empleado.setNombres(resultSet.getString(3));
                empleado.setTipo(resultSet.getInt(4));
                empleado.setArea(resultSet.getString(5));
                empleado.setEstado(resultSet.getInt(6));
                
                empleados.add(empleado);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return empleados;
    }
    
    public boolean registrarEmpleado(Empleado emp, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
        if (procedimiento.toLowerCase().equals("insert")) {
            sql = "INSERT INTO Empleados VALUES("+emp.getId_empleado()+",'"+emp.getApellidos()+"','"+emp.getNombres()+"',"+emp.getTipo()+",'"+emp.getArea()+"',"+emp.getEstado()+" )";
        } else if (procedimiento.toLowerCase().equals("update")) {
            sql = "UPDATE Empleados SET apellidos='"+emp.getApellidos()+"',nombre='"+emp.getNombres()+"',tipo="+emp.getTipo()+",area='"+emp.getArea()+"',estado="+emp.getEstado()+" "
                    + " WHERE id_empleado = " + emp.getId_empleado();
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
