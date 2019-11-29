package BEAN;

public class Diagnostico {
    private int id_diagnostico;
    private String diag_desc;

    public Diagnostico(int id_diagnostico, String diag_desc) {
        this.id_diagnostico = id_diagnostico;
        this.diag_desc = diag_desc;
    }

    public Diagnostico() {}

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public String getDiag_desc() {
        return diag_desc;
    }

    public void setDiag_desc(String diag_desc) {
        this.diag_desc = diag_desc;
    }
}
