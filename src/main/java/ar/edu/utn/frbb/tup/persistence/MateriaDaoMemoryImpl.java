package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.persistence.exception.DuplicatedEntityException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MateriaDaoMemoryImpl implements MateriaDao {

    private static final Map<Long, Materia> repositorioMateria = new HashMap<>();

    @Override
    public Materia createMateria(Materia materia) {
        if (repositorioMateria.containsValue(materia)) {
            throw new DuplicatedEntityException("La materia ya existe en el repositorio.");
        }

        try {
            Random random = new Random();
            materia.setId(random.nextLong());
            repositorioMateria.put(materia.getId(), materia);
            return materia;
        } catch (Exception e) {
            throw new DaoException("Error al crear la materia: " + e.getMessage());
        }
    }

    @Override
    public Materia getMateriaById(long idMateria) {
        Materia materia = repositorioMateria.get(idMateria);
        if (materia != null) {
            return materia;
        } else {
            throw new MateriaNotFoundException("No se encontró ninguna materia con el ID " + idMateria);
        }
    }

    @Override
    public Materia updateMateria(Materia materia) {
        if (repositorioMateria.containsKey(materia.getId())) {
            repositorioMateria.put(materia.getId(), materia);
            return materia;
        } else {
            throw new MateriaNotFoundException("La materia a actualizar no existe en el repositorio.");
        }
    }

    @Override
    public void deleteMateria(long idMateria) {
        if (repositorioMateria.containsKey(idMateria)) {
            repositorioMateria.remove(idMateria);
        } else {
            throw new MateriaNotFoundException("No existe ninguna materia con el ID proporcionado.");
        }
    }

}