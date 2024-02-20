import java.util.ArrayList;

public class Sala {
    //ATRIBUTOS
    private String nombre;
    private int capacidad_maxima;
    private String butacas_disponibles;
    private double dimensiones;
    private boolean accesibilidad;
    private String caracteristicas_acusticas;
    private String observaciones;
    ArrayList<Butaca> lista_butacas= new ArrayList<>();

    //CONSTRUCTOR

    public Sala(String nombre, int capacidad_maxima, double dimensiones, ArrayList<Butaca> lista_butacas) {
        this.nombre = nombre;
        this.capacidad_maxima = capacidad_maxima;
        this.dimensiones = dimensiones;
        this.lista_butacas = lista_butacas;
    }


    //METODOS


    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getButacas_disponibles() {
        return butacas_disponibles;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public String getCaracteristicas_acusticas() {
        return caracteristicas_acusticas;
    }



    public String getObservaciones() {
        return observaciones;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setButacas_disponibles(String butacas_disponibles) {
        this.butacas_disponibles = butacas_disponibles;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public void setCaracteristicas_acusticas(String caracteristicas_acusticas) {
        this.caracteristicas_acusticas = caracteristicas_acusticas;
    }

    public ArrayList<Butaca> getLista_butacas() {
        return lista_butacas;
    }

    public void setDimensiones(double dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getDimensiones() {
        return dimensiones;
    }

    public void setLista_butacas(ArrayList<Butaca> lista_butacas) {
        this.lista_butacas = lista_butacas;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean comprobarCapacidad(int asistentes){
        if (asistentes>this.capacidad_maxima){
            return false;
        }
        return true;
    }
    public void mostrar_butacas(){
        for(Butaca b:lista_butacas){
            System.out.println(b.posicion+"("+b.id+")");
        }
    }
}
