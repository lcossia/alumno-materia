package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.persistence.exception.DuplicatedEntityException;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProfesorDaoMemoryImpl implements ProfesorDao {

    private static Map<Long, Profesor> repositorioProfesor = new HashMap<>();

    @Override
    public Profesor createProfesor(Profesor profesor) {
        if (repositorioProfesor.containsValue(profesor)) {
            throw new DuplicatedEntityException("El profesor ya existe en el repositorio.");
        }

        try {
            Random random = new Random();
            profesor.setId(random.nextLong());
            repositorioProfesor.put(profesor.getId(), profesor);
            return profesor;
        } catch (Exception e) {
            throw new DaoException("Error al crear la materia: " + e.getMessage());
        }
    }

    @Override
    public Profesor getProfesorById(long idProfesor) {
        Profesor profesor = repositorioProfesor.get(idProfesor);
        if (profesor != null) {
            return profesor;
        } else {
            throw new ProfesorNotFoundException("No se encontró ningún profesor con el ID " + idProfesor);
        }
    }

    @Override
    public Profesor getProfesorByApellido (String apellido) {
        Profesor profesor = repositorioProfesor.get(apellido);
        if (profesor != null) {
            return profesor;
        } else {
            throw new ProfesorNotFoundException("No se encontró ningún profesor con el ID " + apellido);
        }
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        if (repositorioProfesor.containsKey(profesor.getId())) {
            repositorioProfesor.put(profesor.getId(), profesor);
            return profesor;
        } else {
            throw new ProfesorNotFoundException("El profesor a actualizar no existe en el repositorio.");
        }
    }

    @Override
    public void deleteProfesor(long idProfesor) {
        if (repositorioProfesor.containsKey(idProfesor)) {
            repositorioProfesor.remove(idProfesor);
        } else {
            throw new ProfesorNotFoundException("No existe ningún profesor con el ID proporcionado.");
        }
    }
}