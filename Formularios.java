package Obligatorio1;

import java.util.*;

public class Formularios {
    static Equipo[] equipos = new Equipo[2]; // Array de objeto equipo para guardar los equipos
    static Partido unPartido = new Partido(); // Instanciado de partido
    static Scanner entrada = new Scanner(System.in); // Variable Scanner para usarla en toda la clase


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
        try{

            int opcion = Integer.parseInt(entrada.nextLine());
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
                    menuPartidoIniciado(); // Llamamos a función estatica para empezar el partido
                    break;
                default:
                    menuPrincipal();
                    break;
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            menuPrincipal();
        }
    }

    //region Menús Equipos
    public static void menuPrincipalEquipos() {
        //Menú para ingresar los equipos
        if(equipos[0]==null){ // Solo deja ingresar si no hay equipos ingresados
            System.out.println("Menú principal del juego:");
            System.out.println("Ingrese nombre de equipo 1");
            Equipo equipo1 = new Equipo(entrada.next());
            equipos[0] = equipo1;
            System.out.println("Ingrese nombre de equipo 2");
            Equipo equipo2 = new Equipo(entrada.next());
            equipos[1] = equipo2;
        }
        elegirEquipo();
    }
    public static void elegirEquipo(){
        //Menú para elegir equipo luego de que se ingresaron
        System.out.println("Elija un equipo que modificar (0 para salir):");
        System.out.println("1. " + equipos[0].getNombre());
        System.out.println("2. " + equipos[1].getNombre());
        try {
            int opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion == 1) {
                menuABMEquipos(equipos[0], 0); // Llama al menú para un equipo
            } else if (opcion == 2) {
                menuABMEquipos(equipos[1], 1); // Llama al menú para el otro
            } else {
                menuPrincipal(); // Si la opción es 0 o cualquier caracter, vuelve al principio
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            elegirEquipo();
        }
    }
    public static void menuABMEquipos(Equipo pEquipo, int posicion) {
        // Menú principal para el equipo seleccionado
        System.out.println("Menú de equipos (0 para salir):");
        System.out.println("1. Titulares");
        System.out.println("2. Suplentes");
        System.out.println("3. Director técnico");
        try {
            int opcion = entrada.nextInt();
            entrada.nextLine();

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
                    elegirEquipo(); // En caso de que no sea 1, 2 o 3, vuelve al menú anterior.
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            menuABMEquipos(pEquipo, posicion);
        }
    }
    public static void menuABMTitulares(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione jugador titular: ");
        // Creamos lista de titulares temporal para asignar luego a equipo
        ArrayList<Jugador> Titulares = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) { // Mientras la opción no sea 0, muestra el formulario
            Titulares = pEquipo.getJugadoresTitulares(); // Llama a los jugadores del equipo ya existentes
            for (int i = 0; i < 11; i++) {
                if (Titulares.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Titulares.get(i).toString());
                }
            }
            try {
                System.out.println("Ingrese opcion (0 para salir)");
                opcion = entrada.nextInt();
                entrada.nextLine();

                if (opcion == 0) {
                    menuABMEquipos(pEquipo, posicion);
                } // Si la opción es 0, vuelve al menú principal

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

                try {
                    if (existeDorsal(numero, posicion) && Titulares.get(opcion - 1).getNombre() == null) { // Checkeamos si existe dorsal con un método pasando la posición del equipo en el array y el dorsal
                        System.out.println("El número de dorsal ya existe, pruebe con otro");
                        menuABMTitulares(pEquipo, posicion);
                    } else {
                        Jugador titular = new Jugador(ci, nombre, apellido, edad, puesto, numero);

                        Titulares.set(opcion - 1, titular);

                        pEquipo.setJugadoresTitulares(Titulares); // setea los jugadores en el equipo
                    }
                } catch (Exception ex) {
                    System.out.println("Ocurrió un problema: opción inválida");
                }
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuABMTitulares(pEquipo, posicion);
            }
        }
    }
    public static void menuABMSuplentes(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione jugador suplente: ");

        ArrayList<Jugador> Suplentes = new ArrayList<>(); // Arraylist temporal de suplentes

        int opcion = -1;

        while (opcion != 0) {
            Suplentes = pEquipo.getJugadoresSuplentes(); // Consigue los suplentes actuales del equipo

            for (int i = 0; i < 5; i++) {
                if (Suplentes.get(i).toString() != null) {
                    System.out.println((i + 1) + " - " + Suplentes.get(i).toString());
                }
            }
            try {
                System.out.println("Ingrese opcion (0 para salir)");
                opcion = entrada.nextInt();

                if (opcion == 0) {
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
                try {

                    if (existeDorsal(numero, posicion) && Suplentes.get(opcion - 1).getNombre() == null) { // Checkeamos si existe dorsal con un método pasando la posición del equipo en el array y el dorsal
                        System.out.println("El número de dorsal ya existe, pruebe con otro");
                        menuABMSuplentes(pEquipo, posicion);
                    } else {

                        Jugador suplente = new Jugador(ci, nombre, apellido, edad, puesto, numero);

                        Suplentes.set(opcion - 1, suplente);

                        pEquipo.setJugadoresSuplentes(Suplentes); // Setea los jugadores suplentes al equipo
                    }
                } catch (Exception ex) {
                    System.out.println("Ocurrió un problema, opción inválida.");
                }
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuABMSuplentes(pEquipo, posicion);
            }
        }
    }
    public static void menuABMDT(Equipo pEquipo, int posicion) {
        System.out.println("Seleccione director técnico: ");

        ArrayList<Entrenador> Entrenador = new ArrayList<>(); // Entrenador temporal, podría ser un objeto, pero por motivos de escalabilidad, se decide usar arraylist

        int opcion = -1;

        while (opcion != 0) {
            Entrenador = pEquipo.getEntrenador();

            if (Entrenador.get(0).toString() != null) {
                System.out.println("1 - " + Entrenador.get(0).toString());
            }
            try {
                System.out.println("Ingrese opcion (0 para salir)");
                opcion = entrada.nextInt();

                if (opcion == 0) {
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

                try {
                    Entrenador.set(opcion - 1, entrenador);
                } catch (Exception ex) {
                    System.out.println("Ocurrió un problema, opción inválida.");
                }
                pEquipo.setEntrenador(Entrenador); // Setea el entrenador en el equipo
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuABMDT(pEquipo, posicion);
            }
        }
    }
    //endregion
    //region Menús Terna Arbitral
    public static void menuPrincipalTernaArbitral(){
        int opcion =-1;
        for (int i = 0; i < 3; i++) {
            unPartido.getTernaArbitral().add(new Arbitro());
            System.out.println((i + 1) + unPartido.getTernaArbitral().get(i).toString());
        } // Genera los arbitros temporales (nulos) para listarlos
        while (opcion != 0) {

            System.out.println("Seleccione una opción (0 para salir): ");
            try {
                opcion = entrada.nextInt();

                if (opcion == 1 || opcion == 2 || opcion == 3) {
                    System.out.println("Ingrese cédula: ");
                    int cedula = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese apellido: ");
                    String apellido = entrada.nextLine();
                    System.out.println("Ingrese puesto: ");
                    String puesto = entrada.nextLine();
                    unPartido.getTernaArbitral().set(opcion - 1, new Arbitro(cedula, nombre, apellido, puesto));

                } else {
                    menuPrincipal();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + " " + unPartido.getTernaArbitral().get(i).toString());
                }
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuPrincipalTernaArbitral();
            }
        }
    }

    //endregion
    //region Menús Partido
    public static void menuPrincipalPartido(){
        // Menú de datos del partido
        int opcion =-1;
        while(opcion!=0){
            String prueba = unPartido.toString();
            System.out.println("Menú principal partido (ingrese 0 para salir): ");
            System.out.println(unPartido.toString());
            System.out.println("1. Modificar"); // Permite modificar, dar de alta o bajar el partido
            try {
                opcion = entrada.nextInt();
                entrada.nextLine();
                if (opcion == 1) { // Opción de modificar partido
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
                } else {
                    menuPrincipal();
                }
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuPrincipalPartido();
            }
        }
    }

    //endregion
    //region Métodos auxiliares
    public static boolean existeDorsal(int pDorsal, int pPosicion){
        Equipo equipo = equipos[pPosicion];
        for(int i =0; i<equipo.getJugadoresTitulares().size(); i++){ // Recorre los dorsales titulares
            if(equipo.getJugadoresTitulares().get(i).getNumero()== pDorsal){
                return true;
            }
        }
        for(int i =0; i<equipo.getJugadoresSuplentes().size(); i++){ // Recorre dorsales suplentes
            if(equipo.getJugadoresSuplentes().get(i).getNumero()== pDorsal){
                return true;
            }
        }
        return false;
    }
    public static boolean existenDatos(){
        // Método para saber si los datos principales fueron ingresados recorriendo los mismos
        if(equipos[0] != null && equipos[1] != null){
            for(int i = 0; i < equipos[0].getJugadoresTitulares().size(); i++){
                if(equipos[0].getJugadoresTitulares().get(i).getNombre()==null){
                    return false;
                }
            }
            for(int i = 0; i < equipos[0].getJugadoresSuplentes().size(); i++){
                if(equipos[0].getJugadoresSuplentes().get(i).getNombre()==null){
                    return false;
                }
            }
            for(int i = 0; i < equipos[1].getJugadoresTitulares().size(); i++){
                if(equipos[1].getJugadoresTitulares().get(i).getNombre()==null){
                    return false;
                }
            }
            for(int i = 0; i < equipos[1].getJugadoresSuplentes().size(); i++){
                if(equipos[1].getJugadoresSuplentes().get(i).getNombre()==null){
                    return false;
                }
            }
            for(int i =0; i< 2; i++){
                if(unPartido.getTernaArbitral().size() == 0){
                    return false;
                }
            }
            if(equipos[0].getEntrenador().get(0).getNombre()==null || equipos[1].getEntrenador().get(0).getNombre()==null){
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    //endregion
    //region Partido iniciado
    public static void menuPartidoIniciado(){
        // Menú para iniciar el partido
        if(existenDatos()){ // Checkeamos con método que estén todos los jugadores de los dos equipos
            System.out.println("El partido inició. Seleccione una de las opciones:");
            System.out.println("1. Realizar cambios");
            System.out.println("2. Registrar goles");
            System.out.println("3. Listado general");
            System.out.println("4. Finalizar el partido");
            try {
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        realizarCambios();
                        break;
                    case 2:
                        registrarGoles();
                        break;
                    case 3:
                        listadoGeneral("menuPartidoIniciado");
                        break;
                    case 4:
                        finalizarPartido();
                        break;
                    default:
                        menuPartidoIniciado();
                        break;
                }
            }
            catch(Exception ex){
                System.out.println("Ingrese un número válido");
                menuPartidoIniciado();
            }

        }
        else{
            System.out.println("Faltan equipos, jugadores, árbitro o partido para comenzar.");
            menuPrincipal();
        }
    }
    public static void realizarCambios(){
        // Realización de cambios de titulares por suplentes
        System.out.println("Elija el equipo al que va a hacer el cambio (0 para salir):");
        System.out.println("1. " + equipos[0].getNombre());
        System.out.println("2. " + equipos[1].getNombre());
        try {
            int opcion = entrada.nextInt();
            if (opcion == 1 || opcion == 2) { // Si el equipo ingresado es correcto
                System.out.println("Seleccione el jugador a salir: ");
                for (int i = 0; i < 11; i++) {
                    if (equipos[opcion - 1].getJugadoresTitulares().get(i).toString() != null) {
                        System.out.println((i + 1) + " - " + equipos[opcion - 1].getJugadoresTitulares().get(i).toString());
                    }
                }
                int jugadorSale = entrada.nextInt(); // Guarda el jugador a salir
                System.out.println("Seleccione el jugador a entrar: ");
                for (int i = 0; i < 5; i++) {
                    if (equipos[opcion - 1].getJugadoresSuplentes().get(i).toString() != null) {
                        System.out.println((i + 1) + " - " + equipos[opcion - 1].getJugadoresSuplentes().get(i).toString());
                    }
                }
                int jugadorEntra = entrada.nextInt(); // Guarda el jugador a entrar
                if (jugadorSale < 12 && jugadorEntra < 6 && jugadorSale > 0 && jugadorEntra > 0) { // Solo sustituye si los jugadores son válidos
                    ArrayList<Jugador> titulares = equipos[opcion - 1].getJugadoresTitulares();
                    Jugador titular = titulares.get(jugadorSale - 1);
                    ArrayList<Jugador> suplentes = equipos[opcion - 1].getJugadoresSuplentes();
                    titulares.set(jugadorSale - 1, suplentes.get(jugadorEntra - 1));
                    suplentes.set(jugadorEntra - 1, titular);
                    equipos[opcion - 1].setJugadoresTitulares(titulares);
                    equipos[opcion - 1].setJugadoresSuplentes(suplentes);
                    System.out.println("Se realizó el cambio.");
                    realizarCambios();
                } else {
                    System.out.println("Seleccione una opción válida");
                    realizarCambios();
                }
            } else {
                menuPartidoIniciado();
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            realizarCambios();
        }
    }
    public static void registrarGoles() {
        System.out.println("Elija el equipo que hizo el gol (0 para salir):");
        System.out.println("1. " + equipos[0].getNombre());
        System.out.println("2. " + equipos[1].getNombre());
        try {
            int opcion = entrada.nextInt(); // Pedimos el equipo

            if (opcion == 1) { // Si es el primer equipo, modificamos el mismo
                unPartido.setGolesEquipo1(unPartido.getGolesEquipo1() + 1); // Setea goles del equipo mas 1
                ;
                System.out.println("Seleccione el jugador que hizo el gol:");
                for (int i = 0; i < 11; i++) {
                    if (equipos[0].getJugadoresTitulares().get(i).toString() != null) {
                        System.out.println((i + 1) + " - " + equipos[0].getJugadoresTitulares().get(i).toString());
                    }
                } // Selecciona el jugador TITULAR del equipo
                int jugadorGol = entrada.nextInt();
                unPartido.getGoleadores1().add(equipos[0].getJugadoresTitulares().get(jugadorGol - 1)); // Le asigna el gol al jugador

                System.out.println("Gol registrado con éxito");

                menuPartidoIniciado();
            } else if (opcion == 2) { // Si es el segundo equipo lo modificamos
                unPartido.setGolesEquipo2(unPartido.getGolesEquipo2() + 1);
                System.out.println("Seleccione el jugador que hizo el gol:");
                for (int i = 0; i < 11; i++) {
                    if (equipos[1].getJugadoresTitulares().get(i).toString() != null) {
                        System.out.println((i + 1) + " - " + equipos[1].getJugadoresTitulares().get(i).toString());
                    }
                }
                int jugadorGol = entrada.nextInt();
                unPartido.getGoleadores2().add(equipos[1].getJugadoresTitulares().get(jugadorGol - 1));
                System.out.println("Gol registrado con éxito");
                menuPartidoIniciado();
            } else {
                System.out.println("Ingrese datos válidos");
                menuPartidoIniciado();
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            registrarGoles();
        }
    }

    public static void listadoGeneral(String back){
        // Recorremos todos los componentes de la aplicación para listarlos
        System.out.println("Equipo 1:");
        System.out.println("Titulares: ");
        for(int i =0; i<equipos[0].getJugadoresTitulares().size(); i++){
            System.out.println(equipos[0].getJugadoresTitulares().get(i));
        }
        System.out.println("Suplentes");
        for(int i =0; i<equipos[0].getJugadoresSuplentes().size(); i++){
            System.out.println(equipos[0].getJugadoresSuplentes().get(i));
        }
        System.out.println(" ");
        System.out.println("Equipo 2:");
        System.out.println("Titulares: ");
        for(int i =0; i<equipos[1].getJugadoresTitulares().size(); i++){
            System.out.println(equipos[1].getJugadoresTitulares().get(i));
        }
        System.out.println("Suplentes");
        for(int i =0; i<equipos[1].getJugadoresSuplentes().size(); i++){
            System.out.println(equipos[1].getJugadoresSuplentes().get(i));
        }

        System.out.println(" ");
        System.out.println("Terna arbitral: ");
        for(int i =0; i<3; i++){
            System.out.println(unPartido.getTernaArbitral().get(i).toString());
        }
        System.out.println(" ");
        System.out.println("Datos del partido");
        System.out.println(unPartido.toString());
        if(back.equals("finalizarPartido")){
            finalizarPartido();
        }
        else{
            menuPartidoIniciado();
        }
    }

    public static void finalizarPartido(){
        System.out.println("El partido finalizó: "+equipos[0].getNombre()+" "+unPartido.getGolesEquipo1()+ " - "+equipos[1].getNombre()+" "+unPartido.getGolesEquipo2() +".\nElija una opción (0 para finalizar el programa): ");
        System.out.println("1. Minutos jugados");
        System.out.println("2. Listar goleadores");
        System.out.println("3. Listado general");
        try {
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Pedimos la opción y la comparamos para llamar a las otras funciones
            switch (opcion) {
                case 3:
                    listadoGeneral("finalizarPartido");
                    finalizarPartido(); // Siempre desp de la función vuelve a la actual
                    break;
                case 2:
                    System.out.println("Goleadores " + equipos[0].getNombre());
                    System.out.println(unPartido.getGoleadores1());
                    System.out.println("Goleadores " + equipos[1].getNombre());
                    System.out.println(unPartido.getGoleadores2());
                    finalizarPartido();
                    break;
                case 1:
                    System.out.println("Ingrese los minutos jugados (entero): ");
                    int minutosJugados = entrada.nextInt();
                    unPartido.setMinutosJugados(minutosJugados);
                    finalizarPartido();
                    break;
                default:

                    System.exit(0); // Termina el programa por completo
                    break;
            }
        }
        catch(Exception ex){
            System.out.println("Ingrese un número válido");
            finalizarPartido();
        }
    }
    //endregion
}
