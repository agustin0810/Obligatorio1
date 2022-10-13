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
                '}';
    }

    private String fecha;
    private String hora;
    private String clima;
    private int minutosJugados;

}
