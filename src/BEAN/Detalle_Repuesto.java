package BEAN;

public class Detalle_Repuesto {
    private int orden_servicio;
    private int id_repuesto;
    private int rep_cant;
    private String rep_tipo;

    public Detalle_Repuesto(int orden_servicio, int id_repuesto, int rep_cant, String rep_tipo) {
        this.orden_servicio = orden_servicio;
        this.id_repuesto = id_repuesto;
        this.rep_cant = rep_cant;
        this.rep_tipo = rep_tipo;
    }

    public Detalle_Repuesto() {}

    public int getOrden_servicio() {
        return orden_servicio;
    }

    public void setOrden_servicio(int orden_servicio) {
        this.orden_servicio = orden_servicio;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public int getRep_cant() {
        return rep_cant;
    }

    public void setRep_cant(int rep_cant) {
        this.rep_cant = rep_cant;
    }

    public String getRep_tipo() {
        return rep_tipo;
    }

    public void setRep_tipo(String rep_tipo) {
        this.rep_tipo = rep_tipo;
    }
}
