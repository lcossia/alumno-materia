package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;
import ar.edu.utn.frbb.tup.persistence.exception.DuplicatedEntityException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AsignaturaDaoMemoryImpl implements AsignaturaDao {

    private static Map<Long, Asignatura> repositorioAsignatura = new HashMap<>();

    @Override
    public Asignatura createAsignatura(Asignatura asignatura) {
        if (repositorioAsignatura.containsValue(asignatura)) {
            throw new DuplicatedEntityException("La asignatura ya existe en el repositorio.");
        }

        try {
            Random random = new Random();
            asignatura.setId(random.nextLong());
            repositorioAsignatura.put(asignatura.getId(), asignatura);
            return asignatura;
        } catch (Exception e) {
            throw new DaoException("Error al crear la asignatura: " + e.getMessage());
        }
    }

    @Override
    public Asignatura getAsignaturaById(long idAsignatura) {
        Asignatura asignatura = repositorioAsignatura.get(idAsignatura);
        if (asignatura == null) {
            throw new AsignaturaNotFoundException("No se encontró ninguna asignatura con el ID " + idAsignatura);
        }
        return asignatura;
    }

    @Override
    public Asignatura updateAsignatura(Asignatura asignatura) {
        if (repositorioAsignatura.containsKey(asignatura.getId())) {
            repositorioAsignatura.put(asignatura.getId(), asignatura);
            return asignatura;
        } else {
            throw new AsignaturaNotFoundException("La asignatura a actualizar no existe en el repositorio.");
        }
    }

    @Override
    public void deleteAsignatura(long id) {
        Asignatura asignaturaAEliminar = repositorioAsignatura.get(id);
        if (asignaturaAEliminar != null) {
            repositorioAsignatura.remove(id);
        } else {
            throw new AsignaturaNotFoundException("No existe ninguna asignatura con el ID proporcionado.");
        }
    }
}