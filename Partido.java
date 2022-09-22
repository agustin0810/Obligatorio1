package Obligatorio1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Partido {
    private String lugar;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
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

    public Partido(String lugar, LocalDate fecha, LocalTime hora, String clima, int minutosJugados) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.clima = clima;
        this.minutosJugados = minutosJugados;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "lugar='" + lugar + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", clima='" + clima + '\'' +
                ", minutosJugados=" + minutosJugados +
                '}';
    }

    private LocalDate fecha;
    private LocalTime hora;
    private String clima;
    private int minutosJugados;

}
