package Obligatorio1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partido {
    private String lugar;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public Partido(String lugar, String fecha, String hora, String clima, int minutosJugados) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.clima = clima;
        this.minutosJugados = minutosJugados;
    }
    public Partido(){

    }
    @Override
    public String toString() {
        return "Partido{" +
                "lugar='" + lugar + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", clima='" + clima + '\'' +
                ", minutosJugados=" + minutosJugados +
                ", arbitros=[" + ternaArbitral.get(0).toString() + ternaArbitral.get(1).toString() + ternaArbitral.get(2).toString() +"]"+
                '}';
    }
    private String fecha;
    private String hora;
    private String clima;
    private int minutosJugados;

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public ArrayList<Jugador> getGoleadores1() {
        return goleadores1;
    }

    public void setGoleadores1(ArrayList<Jugador> goleadores1) {
        this.goleadores1 = goleadores1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public ArrayList<Jugador> getGoleadores2() {
        return goleadores2;
    }

    public void setGoleadores2(ArrayList<Jugador> goleadores2) {
        this.goleadores2 = goleadores2;
    }

    private int golesEquipo1 = 0;
    private ArrayList<Jugador> goleadores1 = new ArrayList<Jugador>();
    private int golesEquipo2 = 0;
    private ArrayList<Jugador> goleadores2 = new ArrayList<Jugador>();

    public ArrayList<Arbitro> getTernaArbitral() {
        return ternaArbitral;
    }

    public void setTernaArbitral(ArrayList<Arbitro> ternaArbitral) {
        this.ternaArbitral = ternaArbitral;
    }

    private ArrayList<Arbitro> ternaArbitral = new ArrayList();

}
