package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Profesor;

public interface ProfesorDao {

    Profesor createProfesor(Profesor profesor);

    Profesor getProfesorById(long id);

    Profesor getProfesorByApellido(String apellido);

    Profesor updateProfesor(Profesor profesor);

    void deleteProfesor(long idProfesor);

}