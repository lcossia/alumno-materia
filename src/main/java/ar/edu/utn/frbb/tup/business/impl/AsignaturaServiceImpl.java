package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaServiceImpl implements AsignaturaService {

    @Override
    public Asignatura getAsignatura(long materiaId, long dni) {
        return null;
    }

    @Override
    public void actualizarAsignatura(Asignatura a) {

    }
}
