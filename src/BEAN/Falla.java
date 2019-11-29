package BEAN;

public class Falla {
    private int id_falla;
    private String tipo_falla;
    private String falla_desc;

    public Falla(int id_falla, String tipo_falla, String falla_desc) {
        this.id_falla = id_falla;
        this.tipo_falla = tipo_falla;
        this.falla_desc = falla_desc;
    }

    public Falla() {}
    

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public String getTipo_falla() {
        return tipo_falla;
    }

    public void setTipo_falla(String tipo_falla) {
        this.tipo_falla = tipo_falla;
    }

    public String getFalla_desc() {
        return falla_desc;
    }

    public void setFalla_desc(String falla_desc) {
        this.falla_desc = falla_desc;
    }
    
    
}
