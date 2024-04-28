package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;

public interface MateriaDao {

    Materia createMateria(Materia materia);

    Materia getMateriaById(long idMateria);

    Materia updateMateria(Materia materia);

    void deleteMateria(long idMateria);

}
