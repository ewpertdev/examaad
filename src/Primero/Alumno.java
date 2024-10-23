package Primero;

import java.io.Serializable;

// implements Serializable
public class Alumno implements Serializable {
    private int id;

    public Alumno(int id, int nota) {
        this.id = id;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Primero.Alumno{" +
                "id=" + id +
                ", nota=" + nota +
                '}';
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    private int nota;

}