package BEAN;

public class Repuesto {
    private int id_repuesto;
    private String rep_desc;
    private float costo_unitario;

    public Repuesto(int id_repuesto, String rep_desc, float costo_unitario) {
        this.id_repuesto = id_repuesto;
        this.rep_desc = rep_desc;
        this.costo_unitario = costo_unitario;
    }

    public Repuesto() {}

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getRep_desc() {
        return rep_desc;
    }

    public void setRep_desc(String rep_desc) {
        this.rep_desc = rep_desc;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }
}
