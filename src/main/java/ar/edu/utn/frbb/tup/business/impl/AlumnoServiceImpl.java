package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDao alumnoDao;
    private final AsignaturaService asignaturaService;

    @Autowired
    public AlumnoServiceImpl(AlumnoDao alumnoDao, AsignaturaService asignaturaService) {
        this.alumnoDao = alumnoDao;
        this.asignaturaService = asignaturaService;
    }

    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno(alumno.getNombre(), alumno.getApellido(), alumno.getDni());
        return alumnoDao.createAlumno(a);
    }

    @Override
    public void aprobarAsignatura(long materiaId, int nota, long dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException {
        Asignatura a = asignaturaService.getAsignatura(materiaId, dni);
        for (Materia m : a.getMateria().getCorrelatividades()) {
            Asignatura correlativa = asignaturaService.getAsignatura(m.getId(), dni);
            if (!EstadoAsignatura.APROBADA.equals(correlativa.getEstado())) {
                throw new CorrelatividadesNoAprobadasException("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getNombreAsignatura());
            }
        }
        a.aprobarAsignatura(nota);
        asignaturaService.actualizarAsignatura(a);
        Alumno alumno = alumnoDao.getAlumnoById(dni);
        alumno.actualizarAsignatura(a);
        alumnoDao.updateAlumno(alumno);
    }

    @Override
    public Alumno buscarAlumnoPorApellido(String apellido) {
        return alumnoDao.getAlumnoByApellido(apellido);
    }
}