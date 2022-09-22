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

    public Jugador[] getJugadoresTitulares() {
        return jugadoresTitulares;
    }

    public void setJugadoresTitulares(Jugador[] jugadoresTitulares) {
        this.jugadoresTitulares = jugadoresTitulares;
    }

    public Jugador[] getJugadoresSuplentes() {
        return jugadoresSuplentes;
    }

    public void setJugadoresSuplentes(Jugador[] jugadoresSuplentes) {
        this.jugadoresSuplentes = jugadoresSuplentes;
    }

    public Entrenador[] getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador[] entrenador) {
        this.entrenador = entrenador;
    }

    public Equipo(String nombre, Jugador[] jugadoresTitulares, Jugador[] jugadoresSuplentes, Entrenador[] entrenador) {
        this.nombre = nombre;
        this.jugadoresTitulares = jugadoresTitulares;
        this.jugadoresSuplentes = jugadoresSuplentes;
        this.entrenador = entrenador;
    }
    public Equipo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadoresTitulares=" + Arrays.toString(jugadoresTitulares) +
                ", jugadoresSuplentes=" + Arrays.toString(jugadoresSuplentes) +
                ", entrenador=" + Arrays.toString(entrenador) +
                '}';
    }

    private String nombre;
    private Jugador[] jugadoresTitulares;
    private Jugador[] jugadoresSuplentes;
    private Entrenador[] entrenador;

}
