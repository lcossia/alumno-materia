package ar.edu.utn.frbb.tup.model.dto;

public class AsignaturaDto {

    private String nombre;
    private int anio;
    private int cuatrimestre;
    private long alumnoId;

    public long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
