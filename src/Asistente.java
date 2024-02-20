import java.time.LocalDate;

public class Asistente {

    //ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private LocalDate fecha_nacimiento;
    private boolean esAdmin;
    private String password;

    //CONSTRUCTORES

    Asistente(){}

    Asistente(String nombre, String apellidos,String email, String dni, LocalDate fecha_nacimiento, String password){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.email=email;
        this.dni=dni;
        this.fecha_nacimiento=fecha_nacimiento;
        this.password=password;
    }
    Asistente(String nombre, String apellidos, String email,String password,boolean esAdmin){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.email=apellidos;
        this.password=password;
        this.esAdmin=esAdmin;
    }
    //GETTER SETTER

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getPassword() {
        return password;
    }
    //METODO

    @Override
    public String toString() {
        return "Asistente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                '}';
    }
    public void ifoBasica(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("Email: "+email);
        System.out.println("DNI: "+dni);
    }
}
