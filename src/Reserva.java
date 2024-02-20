public class Reserva {
    //ATRIBUTOS
    private String id;
    private Asistente asistente;
    private Evento evento;
    private Butaca butaca;
    private String fecha;
    private String hora;

    public Reserva(String id, Asistente asistente, Evento evento, Butaca butaca) {
        this.id = id;
        this.asistente = asistente;
        this.evento = evento;
        this.butaca = butaca;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }


    public boolean comprobarDisponibilidad(){
        if (butaca.isDisponibilidad()){
            return true;
        }else {
            return false;
        }
    }


    public static String generarToken(){
        String token_finalizado= "";
        String caract_perm = "!@#$%^&*";
        String nums_perm = "0123456789";
        String letras_perm = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char caracteres_token;
        char letras_token;
        char numeros_token;

        int max_nums= 7;
        int max_caract= 3;
        int max_letras= 7;

        // CARACTERES TOKEN //
        for (int tk = 0; tk < max_caract; tk++){
            caracteres_token = caract_perm.charAt((int) (Math.random() * caract_perm.length()));
            token_finalizado += caracteres_token;
            caract_perm = caract_perm.replace(String.valueOf(caracteres_token), "");
        }
        // LETRAS TOKEN //
        for (int tk = 0; tk < max_letras; tk++){
            letras_token = letras_perm.charAt((int) (Math.random() * letras_perm.length()));
            token_finalizado+= letras_token;
            letras_perm = letras_perm.replace(String.valueOf(letras_token), "");
        }
        // NUMEROS TOKEN //
        for (int tk = 0; tk < max_nums; tk++){
            numeros_token = nums_perm.charAt((int) (Math.random() * nums_perm.length()));
            token_finalizado += numeros_token;
            nums_perm = nums_perm.replace(String.valueOf(numeros_token), "");
        }
        return token_finalizado;
    }
    public void mostrarInfoReserva(){
        System.out.println("Id reserva: "+id);
        System.out.println("Nombre del asistente: "+asistente.getNombre());
        System.out.println("Evento: "+evento.getTipo_evento());
        System.out.println("Sala: "+evento.getSala());
        System.out.println("Butaca: "+butaca.getPosicion());
        System.out.println("Fecha: "+evento.getFecha());
        System.out.println("Hora: "+evento.getHora());
    }
}
