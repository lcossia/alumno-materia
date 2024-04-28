package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorDao profesorDao;


    @Override
    public Profesor crearProfesor(ProfesorDto profesor) {
        Profesor p = new Profesor();
        p.setNombre(profesor.getNombre());
        p.setApellido(profesor.getApellido());
        p.setDni(profesor.getDni());
        Random random = new Random();
        p.setId(random.nextInt());
        profesorDao.createProfesor(p);
        return p;
    }

    @Override
    public Profesor buscarProfesorPorApellido(String apellido) {
        return profesorDao.getProfesorByApellido(apellido);
    }

    @Override
    public Profesor buscarProfesor(long idProfesor) {
        return profesorDao.getProfesorById(idProfesor);
    }
}
