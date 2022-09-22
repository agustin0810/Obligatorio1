package Obligatorio1;

import java.util.Scanner;

public class Formularios {
    static Equipo[] equipos = new Equipo[2];
    public static void menuPrincipalEquipos(Scanner entrada){

        System.out.println("Menú de equipos:");
        System.out.println("Ingrese nombre de equipo 1");
        Equipo equipo1 = new Equipo(entrada.nextLine());
        equipos[0] = equipo1;
        System.out.println("Ingrese nombre de equipo 2");
        Equipo equipo2 = new Equipo(entrada.nextLine());
        equipos[1] = equipo2;
        System.out.println("Elija un equipo que modificar:");
        System.out.println("1. "+equipos[0].getNombre());
        System.out.println("2. "+equipos[1].getNombre());
        int opcion = entrada.nextInt();
        if(opcion ==1){
            menuABMEquipos(equipos[0], 0);
        }
        else{
            menuABMEquipos(equipos[1], 1);
        }
    }
    public static void menuABMEquipos(Equipo pEquipo, int posicion){
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
}
