package util;

import java.sql.*;

public class dbBean {
    private String dbURL = "jdbc:mysql://localhost:3306/ORDEN_SERVICIO";
    //private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORDEN_SERVICIO";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    //private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String usr = "root";
    //private String usr = "sa";
    private String psw = "123456789"; 
    private Connection dbCon;

    public dbBean() {
        connect();
    }
    
    public boolean connect() {
        try {
            Class.forName(this.dbDriver);
        } catch(java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try{
            dbCon = DriverManager.getConnection(this.dbURL, this.usr, this.psw);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
    
    public void disconnect() throws SQLException {
        dbCon.close();
    }
    
    public ResultSet execSql(String sql) throws SQLException {
        Statement s = dbCon.createStatement();
        ResultSet r = s.executeQuery(sql);
        if(r != null) {
            return r;
        } else {
            return null;
        }
    }
    
    public int insUpd (String sql) throws SQLException {
        Statement s = dbCon.createStatement();
        int r = s.executeUpdate(sql);
        if(r == 0){
            return 0;
        }else{
            return 1;
        }
    }
    
}
