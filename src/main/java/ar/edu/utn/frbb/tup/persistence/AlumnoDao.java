package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;

public interface AlumnoDao {

    Alumno createAlumno(Alumno alumno);

    Alumno getAlumnoById(long idAlumno);

    Alumno getAlumnoByApellido(String apellido);

    Alumno updateAlumno(Alumno alumno);

    void deleteAlumno(long idAlumno);

}
