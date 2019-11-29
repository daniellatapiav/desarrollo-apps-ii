package BEAN;

public class Detalle_Diagnostico {
    private int orden_servicio;
    private int id_diagnostico;

    public Detalle_Diagnostico(int orden_servicio, int id_diagnostico) {
        this.orden_servicio = orden_servicio;
        this.id_diagnostico = id_diagnostico;
    }

    public Detalle_Diagnostico() {}

    public int getOrden_servicio() {
        return orden_servicio;
    }

    public void setOrden_servicio(int orden_servicio) {
        this.orden_servicio = orden_servicio;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }
}
