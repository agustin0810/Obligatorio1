package Obligatorio1;

import java.util.ArrayList;
import java.util.Arrays;

public class Equipo {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre){
        inicializarJugadoresTitulares();
        inicializarJugadoresSuplentes();
        inicializarEntrenador();
        this.nombre = nombre;
    }

    private String nombre;

    public ArrayList<Jugador> getJugadoresTitulares() {
        return jugadoresTitulares;
    }

    public void setJugadoresTitulares(ArrayList<Jugador> jugadoresTitulares) {
        this.jugadoresTitulares = jugadoresTitulares;
    }

    public ArrayList<Jugador> getJugadoresSuplentes() {
        return jugadoresSuplentes;
    }

    public void setJugadoresSuplentes(ArrayList<Jugador> jugadoresSuplentes) {
        this.jugadoresSuplentes = jugadoresSuplentes;
    }

    public ArrayList<Entrenador> getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(ArrayList<Entrenador> entrenador) {
        this.entrenador = entrenador;
    }

    public Equipo(String nombre, ArrayList<Jugador> jugadoresTitulares, ArrayList<Jugador> jugadoresSuplentes, ArrayList<Entrenador> entrenador) {
        inicializarJugadoresTitulares();
        inicializarJugadoresSuplentes();
        inicializarEntrenador();
        this.nombre = nombre;
        this.jugadoresTitulares = jugadoresTitulares;
        this.jugadoresSuplentes = jugadoresSuplentes;
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadoresTitulares=" + jugadoresTitulares +
                ", jugadoresSuplentes=" + jugadoresSuplentes +
                ", entrenador=" + entrenador +
                '}';
    }

    public void inicializarJugadoresTitulares(){
        for(int i = 0; i < 11; i++){
            Jugador temporal = new Jugador();
            jugadoresTitulares.add(temporal);
        }
    }
    public void inicializarJugadoresSuplentes(){
        for(int i = 0; i < 5; i++){
            Jugador temporal = new Jugador();
            jugadoresSuplentes.add(temporal);
        }
    }
    public void inicializarEntrenador(){
        for(int i = 0; i < 1; i++){
            Entrenador temporal = new Entrenador();
            entrenador.add(temporal);
        }
    }
    private ArrayList<Jugador> jugadoresTitulares = new ArrayList<>();
    private ArrayList<Jugador> jugadoresSuplentes = new ArrayList<>();
    private ArrayList<Entrenador> entrenador = new ArrayList<>();

}
