package ar.edu.utn.frbb.tup.model;

import java.util.List;
import java.util.Random;

public class Profesor {

    private long id = 12;
    private String nombre;
    private String apellido;
    private String titulo;
    private long dni;
    private List<Materia> materiasDictadas;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String titulo, long dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.dni = dni;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(List<Materia> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }
}
