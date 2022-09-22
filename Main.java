package Obligatorio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
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
                Formularios.menuPrincipalEquipos(entrada); // Llamamos a función estática para separar código
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
