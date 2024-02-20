import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    //ATRIBUTOS
    private ArrayList <Evento>  lista_eventos;
    public Sala[] listado_salas;
    private ArrayList <Asistente> lista_asistentes;
    private ArrayList <Reserva> listado_reservas;
    //CONSTRUCTOR

    public Gestor() {
        this.lista_eventos = new ArrayList<>();
        this.listado_salas = new Sala[5];
        this.lista_asistentes=new ArrayList<>();
        this.listado_reservas=new ArrayList<>();
        info_inicial();
    }

    public ArrayList<Asistente> getLista_asistentes() {
        return lista_asistentes;
    }

    public ArrayList<Evento> getLista_eventos() {
        return lista_eventos;
    }

    public ArrayList<Reserva> getListado_reservas() {
        return listado_reservas;
    }

    public Sala[] getListado_salas() {
        return listado_salas;
    }

    public void setLista_asistentes(ArrayList<Asistente> lista_asistentes) {
        this.lista_asistentes = lista_asistentes;
    }

    public void setLista_eventos(ArrayList<Evento> lista_eventos) {
        this.lista_eventos = lista_eventos;
    }

    public void setListado_reservas(ArrayList<Reserva> listado_reservas) {
        this.listado_reservas = listado_reservas;
    }

    public void setListado_salas(Sala[] listado_salas) {
        this.listado_salas = listado_salas;
    }

    //METODOS
    private void info_inicial(){
        //Lista asistentes
        lista_asistentes.add(new Asistente("Alejandro","Barbera","alejandro@gmail.com","1234.asdf.",true));
        lista_asistentes.add(new Asistente("Moises","Martinez","moises@gmail.com","1234.asdf.",false));
        lista_asistentes.add(new Asistente("Oscar","Congost","oscar@gmail.com","1234.asdf.",false));




        int identificador=1;
        for (int i=0; i<5; i++) {


            ArrayList<Butaca> misButacas=new ArrayList<>();
            //GENERAR BUTACAS
            for (char fila = 'A'; fila <= 'F'; fila++) {
                for (int columna = 1; columna <= 6; columna++) {
                    identificador++;
                    String pos=fila+""+columna+"";
                    misButacas.add(new Butaca((i*1)*100+columna,false,false,pos));
                }
            }
            listado_salas[i]=new Sala("SALA "+i,200,100.0,misButacas);
        }
        //Lista eventos
        lista_eventos.add(new Evento("Concierto","30",listado_salas[0],"2024-03-20","11:00",30,"Regueaton",30,"20"));
        lista_eventos.add(new Evento("Opera","30",listado_salas[1],"2024-04-02","11:00",30,"Opera",30,"20"));
        lista_eventos.add(new Evento("Concierto Dance","30",listado_salas[2],"2024-03-28","11:00",30,"Dance",30,"20"));
        lista_eventos.add(new Evento("Paco y sus colegas","30",listado_salas[3],"2024-02-03","11:00",30,"Monólogo",30,"20"));
        lista_eventos.add(new Evento("Teatro EL CAMPICO","30",listado_salas[4],"2024-01-30","11:00",30,"Flamenco",30,"20"));
        //Listado reservas
        listado_reservas.add(new Reserva(Validaciones.comprobar_token(),lista_asistentes.get(1),lista_eventos.get(0),lista_eventos.get(0).getSala().lista_butacas.get(0)));
    }
    public boolean login(Asistente asistente){
        Scanner sc=new Scanner(System.in);
        String usuario;
        String password;
        System.out.println("Bienvenido al login!");
        System.out.println("Nombre de usuario: ");
        usuario= sc.nextLine();
        System.out.println("Contraseña: ");
        password= sc.nextLine();
        //SABER SI ES ADMIN
        for (Asistente a : lista_asistentes){
            if (a.getNombre().equals(usuario) && a.getPassword().equals(password)){
                asistente = a;
                if (a.isEsAdmin()){
                    System.out.println("¡¡Bienvenido Administrador!!");
                    return true;
                }else {
                    System.out.println("¡¡ Bienvenido "+usuario+" !!");
                    menu_asistente(asistente);
                }
                return true;
            }
        }
        System.out.println("Inicio de sesion fallido, intentalo de nuevo");
        return false;
    }
    public void menu_asistente(Asistente asistente){
        Scanner sc=new Scanner(System.in);

        Asistente a=new Asistente();
        Evento e=new Evento();
        Butaca b=new Butaca();

        boolean repetir=true;
        String opcion;

        do {
            System.out.println("### DELECTARE MULTIEVENTOS ###");
            System.out.println("------------------------------");
            System.out.println("1. Seleccionar evento");
            System.out.println("2. Información reservas");
            System.out.println("3. Salir");
            System.out.println("Por favor, escoja una opción;");
            opcion= sc.nextLine();

            switch (opcion){
                case "1":
                    System.out.println("¡Bienvenido a la seleccion de eventos!");
                    hacer_reserva(a,e,b);
                    repetir=true;
                    break;
                case "2":
                    System.out.println("¡Bienvenido a la informacion de reservas!");
                    mostrarReserva(asistente);
                    menu_asistente(asistente);
                    repetir=true;
                    break;
                case "3":
                    System.out.println("Saliendo...");
                    repetir=true;
                    break;
                default:
                    System.out.println("Error, selecciona con numeros");
                    repetir=false;
                    break;
            }
        }while (!repetir);
    }

    public void mostrarReserva(Asistente asistente){
        for (Reserva reserva : listado_reservas){
            if (reserva.getAsistente() == asistente) {
                System.out.println("Id reserva: " + reserva.getId());
                System.out.println("Nombre del asistente: " + reserva.getAsistente().getNombre());
                System.out.println("Evento: " + reserva.getEvento().getTipo_evento());
                System.out.println("Sala: " + reserva.getEvento().getSala().getNombre());
                System.out.println("Butaca: " + reserva.getButaca().getPosicion());
                System.out.println("Fecha: " + reserva.getEvento().getFecha());
                System.out.println("Hora: " + reserva.getEvento().getHora());
            }else {
                System.out.println("No hay reservas realizadas con este usuario.");
            }
        }
    }
    public void hacer_reserva(Asistente asistente,Evento evento, Butaca butaca){
        Scanner sc=new Scanner(System.in);

        int eventoDefinitivo;
        String eventoelegido;
        Boolean eventocorrecto = true;
        do {
            int i=0;
            for (Evento e : lista_eventos){
                System.out.println(i+" - "+e.getNombre());
                i++;
            }
            System.out.println("Introduce el numero del evento que quieras reservar: ");
            eventoelegido=sc.nextLine();
            if (Validaciones.comprobar_num(eventoelegido) && (eventoelegido.length() == 1 || eventoelegido.length() == 2)){
                eventoDefinitivo=Integer.parseInt(eventoelegido);
                if (eventoDefinitivo >= 0 && eventoDefinitivo <= lista_eventos.size()){
                    System.out.println("Nombre: "+lista_eventos.get(eventoDefinitivo).getNombre());
                    System.out.println("Fecha: "+lista_eventos.get(eventoDefinitivo).getFecha());
                    System.out.println("Hora: "+lista_eventos.get(eventoDefinitivo).getHora());
                    System.out.println("Precio: "+lista_eventos.get(eventoDefinitivo).getPrecio());
                    System.out.println("Sala: "+lista_eventos.get(eventoDefinitivo).getSala().getNombre());
                    eventocorrecto=true;

                }else{
                    System.out.println("No has introducido ninguno de los números de los eventos disponibles.");
                    eventocorrecto=false;
                }
            }else{
                System.out.println("No has introducido ninguno de los números de los eventos disponibles.");
                eventocorrecto=false;
            }
        }while (!eventocorrecto);

    }


    public Asistente registro(){
        //REGISTRO
        Asistente asistente=new Asistente();

        Scanner sc=new Scanner(System.in);
        String nombre;
        String apellidos;
        String email;
        String dni;
        String fecha_nacimiento;
        boolean esAdmin;
        String password;
        LocalDate fecha_parseda;
        do {
            System.out.println("Introduce tu nombre: ");
            nombre= sc.nextLine();
        }while (!Validaciones.comprobar_nomb(nombre));
        do {
            System.out.println("Introduce tus apellido: ");
            apellidos= sc.nextLine();
        }while (!Validaciones.comprobar_apellido(apellidos));
        do {
            System.out.println("Introduce tu mail: ");
            email=sc.nextLine();
        }while (!Validaciones.comprobar_mail(email));
        do {
            System.out.println("Introduce tu contraseña");
            System.out.println("15 caracteres maximo");
            System.out.println("Introduce contraseña:");
            password= sc.nextLine();
        } while (Validaciones.comprobar_contrasena(password));
        do {
            System.out.println("Introduce tu DNI: ");
            dni=sc.nextLine();
            esAdmin=false;
        }while (!Validaciones.comprobar_dni(dni));

        do {
            System.out.println("Introduce tu fecha de nacimiento, con el siguiente formato: DD-MM-YYYY: ");
            fecha_nacimiento=sc.nextLine();
        }while (!Validaciones.comprobar_fecha(fecha_nacimiento));

        fecha_parseda = Validaciones.parsearFecha(fecha_nacimiento);

        lista_asistentes.add(new Asistente(nombre,apellidos,email,dni,fecha_parseda,password));
        login(asistente);
        return new Asistente();
    }
    /*
    public Evento eleccionEvento(){
        Scanner sc=new Scanner(System.in);
        int seleccion_evento=0;
        String eleccion;
        int i=0;
        for (Evento e : lista_eventos){
            System.out.println(i+" - "+e.getNombre());
            i++;
        }

        do {
            System.out.println("Selecciona el evento para reservar: ");
            eleccion=sc.nextLine();
            Validaciones.comprobar_num(eleccion);
        }while(!Validaciones.comprobar_num(eleccion) && !Validaciones.long_num(eleccion));

    }

     */

}
