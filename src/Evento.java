import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    //ATRIBUTOS
    private String nombre;
    private String invitado;
    private Sala sala;
    private LocalDate fecha;
    private LocalTime hora;
    private int precio;
    private String tipo_evento;
    private int numero_asistentes;
    private String lista_asistentes;

    //CONSTRUCTORES
    public Evento(String nombre, String invitado, Sala sala, String fecha, String hora, int precio, String tipo_evento, int numero_asistentes, String lista_asistentes) {
        this.nombre = nombre;
        this.invitado = invitado;
        this.sala = sala;
        this.fecha = LocalDate.parse(fecha);
        this.hora = LocalTime.parse(hora);
        this.precio = precio;
        this.tipo_evento = tipo_evento;
        this.numero_asistentes = numero_asistentes;
        this.lista_asistentes = lista_asistentes;
    }

    @Override
    public String toString() {
        return  "Nombre= '" + nombre + '\'' +
                " Invitado= '" + invitado + '\'' +
                " Sala= " + sala.getNombre() +
                " Fecha= " + fecha +
                " Hora= " + hora +
                " Precio= " + precio +
                " Tipo de evento= '" + tipo_evento + '\'' +
                " Numero asistentes= " + numero_asistentes +
                " Lista asistentes= '" + lista_asistentes + '\'';
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getInvitado() {
        return invitado;
    }

    public String getLista_asistentes() {
        return lista_asistentes;
    }

    public Evento() {
    }

    public Sala getSala() {
        return sala;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setInvitado(String invitado) {
        this.invitado = invitado;
    }

    public void setLista_asistentes(String lista_asistentes) {
        this.lista_asistentes = lista_asistentes;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNumero_asistentes(int numero_asistentes) {
        this.numero_asistentes = numero_asistentes;
    }

    public int getNumero_asistentes() {
        return numero_asistentes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    }
