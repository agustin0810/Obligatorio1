package Obligatorio1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Formularios {
    static Equipo[] equipos = new Equipo[2];
    static Scanner entrada = new Scanner(System.in);

    public static void menuPrincipalEquipos() {

        System.out.println("Menú principal del juego:");
        System.out.println("Ingrese nombre de equipo 1");
        Equipo equipo1 = new Equipo(entrada.nextLine());
        equipos[0] = equipo1;
        System.out.println("Ingrese nombre de equipo 2");
        Equipo equipo2 = new Equipo(entrada.nextLine());
        equipos[1] = equipo2;
        System.out.println("Elija un equipo que modificar:");
        System.out.println("1. " + equipos[0].getNombre());
        System.out.println("2. " + equipos[1].getNombre());
        int opcion = entrada.nextInt();
        if (opcion == 1) {
            menuABMEquipos(equipos[0], 0);
        } else {
            menuABMEquipos(equipos[1], 1);
        }
    }

    public static void menuABMEquipos(Equipo pEquipo, int posicion) {

        System.out.println("Menú de equipos:");
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
        }
        /*
        jugadores titulares

        1.
        2. 
        3.
        4.
        5.
        6.
        7.



         */
    }

    public static void menuABMTitulares(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione jugador titular: ");

        ArrayList<Jugador> Titulares = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            Titulares = pEquipo.getJugadoresTitulares();

            for (int i = 0; i < 10; i++) {
                if (Titulares.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Titulares.get(i).toString());
                }
            }
            System.out.println("Ingrese opcion (0 para salir)");
            opcion = entrada.nextInt();

            if(opcion == 0){
                break;
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

            for (int i = 0; i < 4; i++) {
                if (Suplentes.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Suplentes.get(i).toString());
                }
            }
            System.out.println("Ingrese opcion (0 para salir)");
            opcion = entrada.nextInt();

            if(opcion == 0){
                break;
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
                break;
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
}
