package RufHelenaJuegoPeliculas;

import java.time.LocalDate;

public class RufHelenaJugador {

    private String nombre;
    private int puntuacion;


    public RufHelenaJugador(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "RufHelenaJugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}