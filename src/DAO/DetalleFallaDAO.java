package DAO;

import BEAN.Detalle_Falla;
import BEAN.Falla;
import BEAN.Orden_Servicio;
import java.sql.*;
import java.util.Vector;
import util.dbBean;

public class DetalleFallaDAO {
    FallaDAO fallaDAO = new FallaDAO();
    
    public Vector<Falla> buscarDetalle(int id_orden) {
        Vector<Detalle_Falla> detalle_fallas = new Vector<Detalle_Falla>();
        dbBean db = new dbBean();
        String sql = "SELECT * FROM Detalle_Fallas WHERE id_ordenServicio = " + id_orden;
        ResultSet resultSet;
        Detalle_Falla detalle_falla;
        
        try {
            resultSet = db.execSql(sql);
            while(resultSet.next()) {
                detalle_falla = new Detalle_Falla();
                detalle_falla.setOrden_servicio(resultSet.getInt(1));
                detalle_falla.setId_falla(resultSet.getInt(2));
                detalle_fallas.add(detalle_falla);
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        try {
            db.disconnect();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        Vector<Falla> fallas = new Vector<Falla>();
        Falla falla;
        
        for(int i = 0; i < detalle_fallas.size(); i++) {
            falla = fallaDAO.buscarFalla(detalle_fallas.elementAt(i).getId_falla());
            fallas.add(falla);
        }
        
        return fallas;
    }
    
    public boolean registrarDetalle(Vector<Detalle_Falla> detalle_fallas, String procedimiento) {
        boolean sw = false;
        dbBean db = new dbBean();
        String sql = "";
       
        int id_orden, id_falla;
        
        for(int i = 0; i < detalle_fallas.size(); i++) {
            id_orden = detalle_fallas.get(i).getOrden_servicio();
            id_falla = detalle_fallas.get(i).getId_falla();
            
            if (procedimiento.toLowerCase().equals("i")) {
            sql = "INSERT INTO Detalle_Fallas VALUES("
                    + id_orden + ", " + id_falla + ")";
            } else if (procedimiento.toLowerCase().equals("u")) {
                sql = "UPDATE Detalle_Fallas SET id_ordenServicio = " + id_orden + ", id_falla = " + id_falla
                        + " WHERE id_ordenServicio = " + id_orden + " AND id_falla = " + id_falla;
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
