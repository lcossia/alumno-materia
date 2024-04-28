package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Asignatura;

public interface AsignaturaDao {

    Asignatura createAsignatura(Asignatura asignatura);

    Asignatura getAsignaturaById(long idAsignatura);

    Asignatura updateAsignatura(Asignatura asignatura);

    void deleteAsignatura(long idAsignatura);

}
