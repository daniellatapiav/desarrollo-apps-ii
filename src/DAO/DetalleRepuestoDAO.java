package DAO;

import BEAN.Detalle_Repuesto;
import BEAN.Repuesto;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class DetalleRepuestoDAO {
    RepuestoDAO repuestoDAO = new RepuestoDAO();
    
    public Vector<Detalle_Repuesto> buscarDetalle(int id_orden) {
        Vector<Detalle_Repuesto> detalle_repuestos = new Vector<Detalle_Repuesto>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Detalle_Repuestos WHERE id_ordenServicio = " + id_orden;
        ResultSet resultSet;
        Detalle_Repuesto detalle_repuesto;
        
        try {
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                detalle_repuesto = new Detalle_Repuesto();
                detalle_repuesto.setOrden_servicio(resultSet.getInt(1));
                detalle_repuesto.setId_repuesto(resultSet.getInt(2));
                detalle_repuesto.setRep_cant(resultSet.getInt(3));
                detalle_repuesto.setRep_tipo(resultSet.getString(4));
                detalle_repuestos.add(detalle_repuesto);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return detalle_repuestos;
    }
    
    public Vector<Repuesto> buscarRepuestos(int id_orden) {
        Vector<Detalle_Repuesto> detalle_repuestos = new Vector<Detalle_Repuesto>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Detalle_Repuestos WHERE id_ordenServicio = " + id_orden;
        ResultSet resultSet;
        Detalle_Repuesto detalle_repuesto;
        
        try {
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                detalle_repuesto = new Detalle_Repuesto();
                detalle_repuesto.setOrden_servicio(resultSet.getInt(1));
                detalle_repuesto.setId_repuesto(resultSet.getInt(2));
                detalle_repuesto.setRep_cant(resultSet.getInt(3));
                detalle_repuesto.setRep_tipo(resultSet.getString(4));
                detalle_repuestos.add(detalle_repuesto);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        Vector<Repuesto> repuestos = new Vector<Repuesto>();
        Vector<Integer> datosAdicionales = new Vector<Integer>();
        Repuesto repuesto;
        
        for(int i = 0; i < detalle_repuestos.size(); i++) {
            repuesto = repuestoDAO.buscarRepuesto(detalle_repuestos.elementAt(i).getId_repuesto());
            repuestos.add(repuesto);
        }
        
        return repuestos;
    }
    
    public boolean registrarDetalle(Vector<Detalle_Repuesto> detalle_repuestos, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
       
        int id_orden, id_repuesto, cantidad;
        String tipo;
        
        for(int i = 0; i < detalle_repuestos.size(); i++) {
            id_orden = detalle_repuestos.get(i).getOrden_servicio();
            id_repuesto = detalle_repuestos.get(i).getId_repuesto();
            cantidad = detalle_repuestos.get(i).getRep_cant();
            tipo = detalle_repuestos.get(i).getRep_tipo();
            
            if (procedimiento.toLowerCase().equals("i")) {
            sql = "INSERT INTO Detalle_Repuestos VALUES("
                    + id_orden + ", " + id_repuesto + ", " + cantidad + ", '" + tipo + "')";
            } else if (procedimiento.toLowerCase().equals("u")) {
                sql = "UPDATE Detalle_Repuestos SET id_ordenServicio = " + id_orden + ", id_repuesto = " + id_repuesto
                        + ", rep_cant = " + cantidad + ", rep_tipo = '" + tipo + "' WHERE id_ordenServicio = " + id_orden + " AND id_repuesto = " + id_repuesto;
            }
            
            System.out.println(sql);
            
            try {
                db.insUpd(sql);
                sw = true;
            } catch(SQLException e) {
                e.printStackTrace();
            }
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
