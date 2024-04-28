package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.persistence.exception.DuplicatedEntityException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Service
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static Map<Long, Alumno> repositorioAlumnos = new HashMap<>();

    @Override
    public Alumno createAlumno(Alumno alumno) {
        if (repositorioAlumnos.containsValue(alumno)) {
            throw new DuplicatedEntityException("El alumno ya existe en el repositorio.");
        }

        try {
            Random random = new Random();
            alumno.setId(random.nextLong());
            repositorioAlumnos.put(alumno.getId(), alumno);
            return alumno;
        } catch (Exception e) {
            throw new DaoException("Error al crear el alumno: " + e.getMessage());
        }
    }

    @Override
    public Alumno getAlumnoById(long idAlumno) {
        Alumno alumno = repositorioAlumnos.get(idAlumno);
        if (alumno == null) {
            throw new AlumnoNotFoundException("No se encontró ningún alumno con el ID " + idAlumno);
        }
        return alumno;
    }

    @Override
    public Alumno getAlumnoByApellido(String apellido) {
        Alumno alumno = repositorioAlumnos.get(apellido);
        if (alumno == null) {
            throw new AlumnoNotFoundException("No se encontró ningún alumno con el apellido " + apellido);
        }
        return alumno;
    }

    @Override
    public Alumno updateAlumno(Alumno alumno) {
        if (repositorioAlumnos.containsKey(alumno.getId())) {
            repositorioAlumnos.put(alumno.getId(), alumno);
            return alumno;
        } else {
            throw new AlumnoNotFoundException("No se encontró ningún alumno con el ID proporcionado.");
        }
    }

    @Override
    public void deleteAlumno(long idAlumno) {
        if (repositorioAlumnos.containsKey(idAlumno)) {
            repositorioAlumnos.remove(idAlumno);
        } else {
            throw new AlumnoNotFoundException("No se encontró ningún alumno con el ID " + idAlumno);
        }
    }

}