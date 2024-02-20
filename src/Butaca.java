public class Butaca {
    // ATRIBITOS
    int id;
    private boolean accesibilidad;
    private boolean disponibilidad;

    String posicion;

    // CONSTRUCTORES
    Butaca(){}
    Butaca(int id, boolean accesibilidad, boolean disponibilidad, String posicion){
        this.id=id;
        this.accesibilidad=accesibilidad;
        this.disponibilidad=disponibilidad;
        this.posicion=posicion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Butaca{" +
                "id='" + id + '\'' +
                ", accesibilidad='" + accesibilidad + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                '}';
    }
    public boolean ocuparBuataca(){
        if (disponibilidad){
            disponibilidad=false;
            System.out.println("Butaca "+id+" acaba de ser ocuapada." );
        }else {
            System.out.println("Butaca "+id+" ya esta ocupada.");
        }
        return false;
    }
    public void desocuparButaca(){
        if (!disponibilidad) {
            disponibilidad=true;
            System.out.println("Butaca "+id+" acaba de ser desocupada");
        }else {
            System.out.println("Buataca "+id+" ya estaba desocupada");
        }

    }
}
