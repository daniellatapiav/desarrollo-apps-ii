package BEAN;

public class Orden_Servicio {
    private int id_ordenServicio;
    private String fecha_mant;
    private String plantel;
    private Empleado usuario;
    private Equipo equipo;
    private Tipo_Mantenimiento tipoMant;
    private String obserRec;
    private String obserDev;
    private Empleado emplRec;
    private Empleado emplDev;
    private int estado;

    public Orden_Servicio(int orden_servicio, String fecha_mant, String plantel, Empleado usuario, Equipo equipo, Tipo_Mantenimiento tipoMant, String obserRec, String obserDev, Empleado emplRec, Empleado emplDev, int estado) {
        this.id_ordenServicio = orden_servicio;
        this.fecha_mant = fecha_mant;
        this.plantel = plantel;
        this.usuario = usuario;
        this.equipo = equipo;
        this.tipoMant = tipoMant;
        this.obserRec = obserRec;
        this.obserDev = obserDev;
        this.emplRec = emplRec;
        this.emplDev = emplDev;
        this.estado = estado;
    }

    public Orden_Servicio() {}

    public int getId_ordenServicio() {
        return id_ordenServicio;
    }

    public void setId_ordenServicio(int id_ordenServicio) {
        this.id_ordenServicio = id_ordenServicio;
    }

    public String getFecha_mant() {
        return fecha_mant;
    }

    public void setFecha_mant(String fecha_mant) {
        this.fecha_mant = fecha_mant;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Tipo_Mantenimiento getTipoMant() {
        return tipoMant;
    }

    public void setTipoMant(Tipo_Mantenimiento tipoMant) {
        this.tipoMant = tipoMant;
    }

    public String getObserRec() {
        return obserRec;
    }

    public void setObserRec(String obserRec) {
        this.obserRec = obserRec;
    }

    public String getObserDev() {
        return obserDev;
    }

    public void setObserDev(String obserDev) {
        this.obserDev = obserDev;
    }
    
    public Empleado getEmplRec() {
        return emplRec;
    }

    public void setEmplRec(Empleado emplRec) {
        this.emplRec = emplRec;
    }

    public Empleado getEmplDev() {
        return emplDev;
    }

    public void setEmplDev(Empleado emplDev) {
        this.emplDev = emplDev;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
