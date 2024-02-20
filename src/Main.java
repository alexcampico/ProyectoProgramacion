import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion1;
        boolean comprobarLista;
        boolean comprobarLogin= true;

        Gestor gestor_eventos = new Gestor();
        Asistente asistente=new Asistente();

        // gestor_eventos.listado_salas[0].mostrar_butacas();

        do {
            System.out.println("### DELECTARE MULTIENVENTOS ###");
            System.out.println("-------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Registro");
            System.out.println("0. Salir");
            System.out.println("-------------------------------");
            System.out.println("Por favor, escoja una opción: ");

            opcion1 = sc.nextLine();
                switch (opcion1) {
                    case "1":
                        do {
                            if (gestor_eventos.login(asistente)){
                                comprobarLogin=false;
                                break;
                            }
                        }while (comprobarLogin);
                        comprobarLista = true;
                        break;
                    case "2":
                        System.out.println("Bienvenido al Registro!");
                        gestor_eventos.registro();
                        comprobarLista = true;
                        break;
                    case "0":
                        System.out.println("Saliendo del registro...");
                        comprobarLista=true;
                        break;
                    default:
                        System.out.println("Error, vuelva a intentarlo");
                        comprobarLista=false;
                        break;
                }
        }while (!comprobarLista);
    }
}