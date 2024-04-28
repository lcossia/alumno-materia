package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Carrera;

public interface CarreraDao {

    Carrera createCarrera(Carrera carrera);

    Carrera getCarreraById(long idCarrera);

    Carrera updateCarrera(Carrera carrera);

    void deleteCarrera(long idCarrera);

}
