import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Year;

public class Validaciones {
    // FUNCION COMPROBAR ASIENTOS //

    /**
     * Método que sirve para validar si el asiento escogido es correcto o no en estructura
     *
     * @param asiento_seleccionado
     * @return
     */
    public static boolean comprobar_asiento(String asiento_seleccionado) {
        boolean comprobacion_asiento = false;

        if (asiento_seleccionado.length() == 2) {
            asiento_seleccionado = asiento_seleccionado.toUpperCase();
            char letra = asiento_seleccionado.charAt(0);
            char numero = asiento_seleccionado.charAt(1);
            if (asiento_seleccionado.equals("A1") || asiento_seleccionado.equals("B5") || asiento_seleccionado.equals("C6")) {
                System.out.println("Los asientos elegidos estan ocupados, reserve otros");
            } else if ((numero < '1' || numero > '6') || (letra < 'A' || letra > 'C')) {
                System.out.println("El asiento seleccionado no existe");
            } else {
                comprobacion_asiento = true;
            }
        }
        return comprobacion_asiento;
    }

    // FUNCION COMPROBAR TELEFONO //

    /**
     * Método que sirve para validar si el telefono escogido es correcto o no en estructura
     *
     * @param telefono_seleccionado
     * @return
     */
    public static boolean comprobar_tel(String telefono_seleccionado) {
        boolean comprobacion_tel = false;
        for (int t = 0; t < telefono_seleccionado.length(); t++) {
            if (telefono_seleccionado.charAt(t) < '0' || telefono_seleccionado.charAt(t) > '9') {
                System.out.println("Número de telefono incorrecto.");
                return false;
            } else if (telefono_seleccionado.length() < 9) {
                System.out.println("Número de telefono incorrecto.");
                return false;
            } else if (telefono_seleccionado.length() > 9) {
                System.out.println("Número de telefono incorrecto.");
                return false;
            } else {
                comprobacion_tel = true;
            }
        }
        return comprobacion_tel;
    }

    // FUNCION COMPROBAR NOMBRE //

    /**
     * Método que sirve para validar si el nombre escogido es correcto o no en estructura
     *
     * @param nombre_seleccionado
     * @return
     */
    public static boolean comprobar_nomb(String nombre_seleccionado) {
        boolean comprobacion_nomb = false;
        for (int n = 0; n < nombre_seleccionado.length(); n++) {
            if ((nombre_seleccionado.charAt(n) > 'z' || nombre_seleccionado.charAt(n) < 'A') && (nombre_seleccionado.charAt(n) != 32 && nombre_seleccionado.charAt(n) != 'ñ') && nombre_seleccionado.charAt(n) != 'ü') {
                System.out.println("Nombre inválido");
                return false;
            } else if (nombre_seleccionado.length() < 2) {
                System.out.println("Nombre inválido");
                return false;
            } else if (nombre_seleccionado.length() > 30) {
                System.out.println("Nombre inválido");
                return false;
            } else {
                comprobacion_nomb = true;
            }
        }
        return comprobacion_nomb;
    }

    // FUNCION COMPROBAR DNI //

    /**
     * Método que sirve para validar si el dni escogido es correcto o no en estructura
     *
     * @param dni_seleccionado
     * @return
     */
    public static boolean comprobar_dni(String dni_seleccionado) {
        boolean comprobacion_dni = false;
        for (int d = 0; d < 8; d++) {
            if (dni_seleccionado.length() == 9) {
                dni_seleccionado = dni_seleccionado.toUpperCase();
                char letradni;
                letradni = dni_seleccionado.charAt(d);
                if (dni_seleccionado.charAt(d) > '9' || dni_seleccionado.charAt(d) < '0') {
                    System.out.println("DNI inválido");
                    return false;
                } else if (dni_seleccionado.length() > 9) {
                    System.out.println("DNI inválido");
                    return false;
                } else if (dni_seleccionado.length() < 9) {
                    System.out.println("DNI inválido");
                    return false;
                } else if (dni_seleccionado.charAt(8) < 'A' || dni_seleccionado.charAt(8) > 'Z') {
                    System.out.println("DNI inválido");
                    return false;
                } else {
                    comprobacion_dni = true;
                }
            } else {
                System.out.println("DNI inválido");
                return false;
            }

            if (comprobacion_dni) {
                char letradni = dni_seleccionado.charAt(8);
                int restodni = (Integer.parseInt(dni_seleccionado.substring(0, 8))) % 23;
                String letras_verdaderas = "TRWAGMYFPDXBNJZSQVHLCKE";
                if (letradni == letras_verdaderas.charAt(restodni)) {
                    comprobacion_dni = true;
                } else {
                    comprobacion_dni = false;
                }
            }
        }
        return comprobacion_dni;
    }

    // FUNCION COMPROBAR MAIL //

    /**
     * Método que sirve para validar si el mail escogido es correcto o no en estructura
     *
     * @param mail_seleccionado
     * @return
     */
    public static boolean comprobar_mail(String mail_seleccionado) {
        int arroba = 0;
        if (mail_seleccionado.length() != 0) {
            if (mail_seleccionado.charAt(0) == '@' || mail_seleccionado.charAt(0) == '.') {
                System.out.println("Email inválido");
                return false;
            } else {
                for (int m = 0; m < mail_seleccionado.length(); m++) {
                    if ((mail_seleccionado.charAt(m) > 'z' || mail_seleccionado.charAt(m) < 'a') && (mail_seleccionado.charAt(m) < '0' || mail_seleccionado.charAt(m) > '9') && (mail_seleccionado.charAt(m) != '.')) {
                        if (mail_seleccionado.charAt(m) == '@') {
                            arroba++;
                        } else {
                            System.out.println("Email invalido");
                            return false;
                        }
                    }
                }
                if (arroba != 1) {
                    System.out.println("Email inválido");
                    return false;
                } else if (mail_seleccionado.indexOf('@') > mail_seleccionado.lastIndexOf('.')) {
                    System.out.println("Email invalido");
                    return false;
                }
            }
        } else {
            System.out.println("ERROR");
            return false;
        }
        return true;
    }

    // FUNCION TOKEN //

    /**
     * Método que sirve para hacer un token con numeros caracteres y simbolos
     *
     * @param
     * @return
     */
    public static String comprobar_token() {
        String token_finalizado = "";
        String caract_perm = "!@#$%^&*";
        String nums_perm = "0123456789";
        String letras_perm = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char caracteres_token;
        char letras_token;
        char numeros_token;

        int max_nums = 7;
        int max_caract = 3;
        int max_letras = 7;

        // CARACTERES TOKEN //
        for (int tk = 0; tk < max_caract; tk++) {
            caracteres_token = caract_perm.charAt((int) (Math.random() * caract_perm.length()));
            token_finalizado += caracteres_token;
            caract_perm = caract_perm.replace(String.valueOf(caracteres_token), "");
        }
        // LETRAS TOKEN //
        for (int tk = 0; tk < max_letras; tk++) {
            letras_token = letras_perm.charAt((int) (Math.random() * letras_perm.length()));
            token_finalizado += letras_token;
            letras_perm = letras_perm.replace(String.valueOf(letras_token), "");
        }
        // NUMEROS TOKEN //
        for (int tk = 0; tk < max_nums; tk++) {
            numeros_token = nums_perm.charAt((int) (Math.random() * nums_perm.length()));
            token_finalizado += numeros_token;
            nums_perm = nums_perm.replace(String.valueOf(numeros_token), "");
        }
        return token_finalizado;
    }

    // FUNCION IBAN //

    /**
     * Método que sirve para validar si el iban escogido es correcto o no en estructura
     *
     * @param iban_seleccionado
     * @return
     */
    public static boolean comprobar_iban(String iban_seleccionado) {
        if (iban_seleccionado.length() != 24) {
            return false;
        } else {
            for (int ib = 0; ib < 2; ib++) {
                if (iban_seleccionado.charAt(ib) < 'A' || iban_seleccionado.charAt(ib) > 'Z') {
                    System.out.println("IBAN inválido");
                    return false;
                }
            }


            for (int ib = 2; ib < iban_seleccionado.length(); ib++) {
                if (iban_seleccionado.charAt(ib) < '0' || iban_seleccionado.charAt(ib) > '9') {
                    System.out.println("IBAN inválido");
                    return false;
                }
            }
        }

        iban_seleccionado = iban_seleccionado.substring(4) + iban_seleccionado.substring(0, 4);


        for (int ib = 0; ib < iban_seleccionado.length(); ib++) {
            if (iban_seleccionado.charAt(ib) >= 'A' && iban_seleccionado.charAt(ib) <= 'Z') {
                String cambiado = String.valueOf(iban_seleccionado.charAt(ib) - 55);
                iban_seleccionado = iban_seleccionado.substring(0, ib) + cambiado + iban_seleccionado.substring(ib + 1, iban_seleccionado.length());
            }
        }


        BigInteger iban_seleccionado_final = new BigInteger(iban_seleccionado);


        BigInteger divis = iban_seleccionado_final.mod(new BigInteger("97"));
        String ibanfuncionando = divis.toString();

        if (ibanfuncionando.equals("1")) {
            return true;
        } else {
            System.out.println("IBAN inválido");
            return false;
        }
    }

    //FUNCION APELLIDOS
    public static boolean comprobar_apellido(String nombre_seleccionado) {
        boolean comprobacion_nomb = false;
        for (int n = 0; n < nombre_seleccionado.length(); n++) {
            if ((nombre_seleccionado.charAt(n) > 'z' || nombre_seleccionado.charAt(n) < 'A') && (nombre_seleccionado.charAt(n) != 32 && nombre_seleccionado.charAt(n) != 'ñ') && nombre_seleccionado.charAt(n) != 'ü') {
                System.out.println("Apellido inválido");
                return false;
            } else if (nombre_seleccionado.length() < 2) {
                System.out.println("Apellido inválido");
                return false;
            } else if (nombre_seleccionado.length() > 30) {
                System.out.println("Apellido inválido");
                return false;
            } else {
                comprobacion_nomb = true;
            }
        }
        return comprobacion_nomb;
    }

    public static boolean comprobar_contrasena(String password) {
        boolean comprobacion_contrasena = false;
        if (password.length() == 0) {
            System.out.println("Error contraseña");
            comprobacion_contrasena = true;
        } else if (password.length() < 15) {
            comprobacion_contrasena = false;
        } else {
            System.out.println("Error contraseña");
            comprobacion_contrasena = true;
        }
        return comprobacion_contrasena;
    }

    public static boolean comprobar_num(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) < '0' || numero.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static LocalDate parsearFecha(String fecha) {
        String[] dia_mes_anyo = fecha.split("-");
        int dia = Integer.parseInt(dia_mes_anyo[0]);
        int mes = Integer.parseInt(dia_mes_anyo[1]);
        int anyo = Integer.parseInt(dia_mes_anyo[2]);

        LocalDate fecha_parseada = LocalDate.of(anyo, mes, dia);
        return fecha_parseada;
    }


    public static boolean long_num(String num){
        if (num.length()>2){
            return false;
        }
        return true;
    }

    /**
     * Metodo qeu sirve para validar la fecha
     *
     * @param fecha_nacimiento
     * @return
     */
    public static boolean comprobar_fecha(String fecha_nacimiento) {
        if (fecha_nacimiento.length() != 10) {
            System.out.println("Introduce la fecha en el formato indicado DD-MM-YYYY");
            return false;
        } else {
            String numsfecha = fecha_nacimiento.replace("-", "");
            if (Validaciones.comprobar_num(numsfecha)) {
                String[] dia_mes_ano = fecha_nacimiento.split("-");

                int dia = Integer.parseInt(dia_mes_ano[0]);
                int mes = Integer.parseInt(dia_mes_ano[1]);
                int ano = Integer.parseInt(dia_mes_ano[2]);
                if (ano > 1920 && ano < (Integer.parseInt(String.valueOf(Year.now())))) {
                    if (mes > 0 && mes <= 12) {
                        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                            if (dia < 1 || dia > 31) {
                                System.out.println("Día no válido.");
                                return false;
                            } else {
                                return true;
                            }
                        } else if (mes == 2) {
                            if (ano % 400 == 0) {
                                if (dia < 1 || dia > 29) {
                                    System.out.println("Día no válido.");
                                    return false;
                                } else {
                                    return true;
                                }
                            } else {
                                if (dia < 1 || dia > 28) {
                                    System.out.println("Día no válido.");
                                    return false;
                                } else {
                                    return true;
                                }
                            }
                        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                            if (dia < 1 || dia > 30) {
                                System.out.println("Día no válido.");
                                return false;
                            } else {
                                return true;
                            }
                        }
                    } else {
                        System.out.println("Més no válido.");
                        return false;
                    }
                } else {
                    System.out.println("Año no válido.");
                    return false;

                }
            }
            return true;
        }
    }
}



