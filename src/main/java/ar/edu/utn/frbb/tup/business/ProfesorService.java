package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;

public interface ProfesorService {

    public Profesor crearProfesor(ProfesorDto Profesor);

    public Profesor buscarProfesorPorApellido(String apellido);

    public Profesor buscarProfesor(long id);
}
