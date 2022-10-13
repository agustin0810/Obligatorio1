package Obligatorio1;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;


public class Formularios {
    static Equipo[] equipos = new Equipo[2];
    static ArrayList<Arbitro> ternaArbitral = new ArrayList<Arbitro>();
    static Partido unPartido = new Partido();
    static Scanner entrada = new Scanner(System.in);

    public static void menuPrincipal(){
        //Menú principal:
        System.out.println("MENÚ PRINCIPAL:");
        System.out.println("Ingrese una de las siguientes opciones:");
        System.out.println("1. EQUIPOS");
        System.out.println("2. TERNA ARBITRAL");
        System.out.println("3. PARTIDOS");
        System.out.println("4. COMENZAR PARTIDO");
        // Llevar a menú de partido en juego
        // No dejar que se comience sin configuraciones de arriba
        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();
        switch (opcion){
            case 1:
                menuPrincipalEquipos(); // Llamamos a función estática de menú equipos para separar código
                break;
            case 2:
                menuPrincipalTernaArbitral(); // Llamamos a función estatica de menú terna arbitral
                break;
            case 3:
                menuPrincipalPartido(); // Llamamos a función estatica de menú partido
                break;
            case 4:
                break;
        }
    }

    //region Menús Equipos
    public static void menuPrincipalEquipos() {
        if(equipos[0]==null){
            System.out.println("Menú principal del juego:");
            System.out.println("Ingrese nombre de equipo 1");
            Equipo equipo1 = new Equipo(entrada.nextLine());
            equipos[0] = equipo1;
            System.out.println("Ingrese nombre de equipo 2");
            Equipo equipo2 = new Equipo(entrada.nextLine());
            equipos[1] = equipo2;

        }
        elegirEquipo();
    }
    public static void elegirEquipo(){
        System.out.println("Elija un equipo que modificar (0 para salir):");
        System.out.println("1. " + equipos[0].getNombre());
        System.out.println("2. " + equipos[1].getNombre());
        int opcion = entrada.nextInt();
        if (opcion == 1) {
            menuABMEquipos(equipos[0], 0);
        } else if (opcion==2) {
            menuABMEquipos(equipos[1], 1);
        }
        else{
            menuPrincipal();
        }
    }
    public static void menuABMEquipos(Equipo pEquipo, int posicion) {

        System.out.println("Menú de equipos (0 para salir):");
        System.out.println("1. Titulares");
        System.out.println("2. Suplentes");
        System.out.println("3. Director técnico");
        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                menuABMTitulares(pEquipo, posicion);
                break;
            case 2:
                menuABMSuplentes(pEquipo, posicion);
                break;
            case 3:
                menuABMDT(pEquipo, posicion);
                break;
            default:
                elegirEquipo();
        }
    }
    public static void menuABMTitulares(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione jugador titular: ");

        ArrayList<Jugador> Titulares = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            Titulares = pEquipo.getJugadoresTitulares();

            for (int i = 0; i < 11; i++) {
                if (Titulares.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Titulares.get(i).toString());
                }
            }
            System.out.println("Ingrese opcion (0 para salir)");
            opcion = entrada.nextInt();

            if(opcion == 0){
                menuABMEquipos(pEquipo, posicion);
            }

            System.out.println("Ingrese la cédula (solo números): ");
            int ci = entrada.nextInt();
            System.out.println("Ingrese nombre: ");
            String nombre = entrada.next();
            System.out.println("Ingrese apellido: ");
            String apellido = entrada.next();
            System.out.println("Ingrese edad: ");
            int edad = entrada.nextInt();
            System.out.println("Ingrese el puesto: ");
            String puesto = entrada.next();
            System.out.println("Ingrese el número: ");
            int numero = entrada.nextInt();

            Jugador titular = new Jugador(ci, nombre, apellido, edad, puesto, numero);

            Titulares.set(opcion - 1, titular);

            pEquipo.setJugadoresTitulares(Titulares);
        }
    }
    public static void menuABMSuplentes(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione jugador suplente: ");

        ArrayList<Jugador> Suplentes = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            Suplentes = pEquipo.getJugadoresSuplentes();

            for (int i = 0; i < 5; i++) {
                if (Suplentes.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Suplentes.get(i).toString());
                }
            }
            System.out.println("Ingrese opcion (0 para salir)");
            opcion = entrada.nextInt();

            if(opcion == 0){
                menuABMEquipos(pEquipo, posicion);
            }

            System.out.println("Ingrese la cédula (solo números): ");
            int ci = entrada.nextInt();
            System.out.println("Ingrese nombre: ");
            String nombre = entrada.next();
            System.out.println("Ingrese apellido: ");
            String apellido = entrada.next();
            System.out.println("Ingrese edad: ");
            int edad = entrada.nextInt();
            System.out.println("Ingrese el puesto: ");
            String puesto = entrada.next();
            System.out.println("Ingrese el número: ");
            int numero = entrada.nextInt();

            Jugador suplente = new Jugador(ci, nombre, apellido, edad, puesto, numero);

            Suplentes.set(opcion - 1, suplente);

            pEquipo.setJugadoresSuplentes(Suplentes);
        }
    }
    public static void menuABMDT(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione director técnico: ");

        ArrayList<Entrenador> Entrenador = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            Entrenador = pEquipo.getEntrenador();

            if (Entrenador.get(0).toString() != null) {
                System.out.println((0 + 1) + " - " + Entrenador.get(0).toString());
            }
            System.out.println("Ingrese opcion (0 para salir)");
            opcion = entrada.nextInt();

            if(opcion == 0){
                menuABMEquipos(pEquipo, posicion);
            }

            System.out.println("Ingrese la cédula (solo números): ");
            int ci = entrada.nextInt();
            System.out.println("Ingrese nombre: ");
            String nombre = entrada.next();
            System.out.println("Ingrese apellido: ");
            String apellido = entrada.next();
            System.out.println("Ingrese edad: ");
            int edad = entrada.nextInt();

            Entrenador entrenador = new Entrenador(ci, nombre, apellido, edad);

            Entrenador.set(opcion - 1, entrenador);

            pEquipo.setEntrenador(Entrenador);
        }
    }
    //endregion

    //region Menús Terna Arbitral
    public static void menuPrincipalTernaArbitral(){
        int opcion =-1;
        for (int i = 0; i < 3; i++) {
            ternaArbitral.add(new Arbitro());
            System.out.println((i + 1) + ternaArbitral.get(i).toString());
        }
        while (opcion != 0) {

            System.out.println("Seleccione una opción (0 para salir): ");

            opcion = entrada.nextInt();

            if (opcion == 1 || opcion == 2 || opcion == 3) {
                System.out.println("Ingrese cédula: ");
                int cedula = entrada.nextInt();
                System.out.println("Ingrese nombre: ");
                String nombre = entrada.next();
                System.out.println("Ingrese apellido: ");
                String apellido = entrada.next();
                System.out.println("Ingrese puesto: ");
                String puesto = entrada.next();
                ternaArbitral.set(opcion-1, new Arbitro(cedula, nombre, apellido, puesto));

            } else {
                menuPrincipal();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + " " + ternaArbitral.get(i).toString());
            }
        }
    }

    //endregion

    //region Menús Partido
    public static void menuPrincipalPartido(){
        int opcion =-1;
        while(opcion!=0){

            System.out.println("Menú principal partido (ingrese 0 para salir): ");
            System.out.println(unPartido.toString());
            System.out.println("1. Modificar");

            opcion = entrada.nextInt();
            entrada.nextLine();
            if(opcion==1){
                System.out.println("Ingrese lugar");
                String lugar = entrada.next();
                entrada.nextLine();
                System.out.println("Ingrese día");
                String dia = entrada.nextLine();
                System.out.println("Ingrese hora");
                String hora = entrada.next();
                System.out.println("Ingrese clima");
                String clima = entrada.next();
                unPartido.setLugar(lugar);
                unPartido.setFecha(dia);
                unPartido.setHora(hora);
                unPartido.setClima(clima);
            }
            else{
                menuPrincipal();
            }
        }
    }

    //endregion
}
