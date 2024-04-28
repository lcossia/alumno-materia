package ar.edu.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private long id;
    private final String nombre;
    private int cantidadAnios;
    private List<Materia> materiasList;

    public Carrera(String nombre, int cantidadAnios) {
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;

        materiasList = new ArrayList<>();
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

    public int getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void agregarMateria(Materia materia) {
        this.materiasList.add(materia);
    }
}
