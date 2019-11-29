package BEAN;

public class Tipo_Mantenimiento {
    private int id_tipoMant;
    private String tipoMant_desc;

    public Tipo_Mantenimiento(int id_tipoMant, String tipoMant_desc) {
        this.id_tipoMant = id_tipoMant;
        this.tipoMant_desc = tipoMant_desc;
    }

    public Tipo_Mantenimiento() {}

    public int getId_tipoMant() {
        return id_tipoMant;
    }

    public void setId_tipoMant(int id_tipoMant) {
        this.id_tipoMant = id_tipoMant;
    }

    public String getTipoMant_desc() {
        return tipoMant_desc;
    }

    public void setTipoMant_desc(String tipoMant_desc) {
        this.tipoMant_desc = tipoMant_desc;
    }
}
