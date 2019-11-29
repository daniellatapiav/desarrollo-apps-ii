package BEAN;

public class Equipo {
    private int id_equipo;
    private Empleado usuario;
    private String marca;
    private String modelo;
    private String num_serie;
    private int estado;

    public Equipo(int id_equipo, Empleado usuario, String marca, String modelo, String num_serie, int estado) {
        this.id_equipo = id_equipo;
        this.usuario = usuario;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.estado = estado;
    }

    public Equipo() {}
    
    public String getDescCompleta() {
        return marca + " " + modelo;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
