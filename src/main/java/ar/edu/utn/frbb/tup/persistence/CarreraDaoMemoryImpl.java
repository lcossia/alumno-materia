package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.persistence.exception.DuplicatedEntityException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CarreraDaoMemoryImpl implements CarreraDao {

    private static final Map<Long, Carrera> repositorioCarrera = new HashMap<>();

    @Override
    public Carrera createCarrera(Carrera carrera) {
        if (repositorioCarrera.containsValue(carrera)) {
            throw new DuplicatedEntityException("La materia ya existe en el repositorio.");
        }

        try {
            Random random = new Random();
            carrera.setId(random.nextLong());
            repositorioCarrera.put(carrera.getId(), carrera);
            return carrera;
        } catch (Exception e) {
            throw new DaoException("Error al crear la carrera: " + e.getMessage());
        }
    }

    @Override
    public Carrera getCarreraById(long idcarrera) {
        Carrera carrera = repositorioCarrera.get(idcarrera);
        if (carrera != null) {
            return carrera;
        } else {
            throw new MateriaNotFoundException("No se encontró ninguna carrera con el ID " + idcarrera);
        }
    }

    @Override
    public Carrera updateCarrera(Carrera carrera) {
        if (repositorioCarrera.containsKey(carrera.getId())) {
            repositorioCarrera.put(carrera.getId(), carrera);
            return carrera;
        } else {
            throw new MateriaNotFoundException("La carrera a actualizar no existe en el repositorio.");
        }
    }

    @Override
    public void deleteCarrera(long idCarrera) {
        if (repositorioCarrera.containsKey(idCarrera)) {
            repositorioCarrera.remove(idCarrera);
        } else {
            throw new MateriaNotFoundException("No existe ninguna carrera con el ID proporcionado.");
        }
    }
}

