package BEAN;

public class Empleado {
    private int id_empleado;
    private String apellidos;
    private String nombres;
    private int tipo;
    private String area;
    private int estado;

    public Empleado(int id_empleado, String apellidos, String nombre, int tipo, String area, int estado) {
        this.id_empleado = id_empleado;
        this.apellidos = apellidos;
        this.nombres = nombre;
        this.tipo = tipo;
        this.area = area;
        this.estado = estado;
    }
    
    public Empleado() {};
    
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
