package co.edu.uniandes.dse.parcialprueba.services;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.nullable;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {
@Autowired
private PacienteRepository pacienteRepository;


@Transactional
public PacienteEntity createconsulta(PacienteEntity pacienteEntity) throws IllegalOperationException {
    log.info("Inicia proceso de creación de la consulta");
    
    if(pacienteEntity.getNombre() == null|| pacienteEntity.getNombre().trim().isEmpty())
    {
        throw new IllegalOperationException("El nombre del médico no puede ser nulo");
    }
    if(pacienteEntity.getEdad() == null|| pacienteEntity.getEdad().equals(null))
    {
        throw new IllegalOperationException("El nombre del médico no puede ser nulo");
    }
    if(pacienteEntity.getCelular() == null|| pacienteEntity.getCelular().equals(null))
    {
        throw new IllegalOperationException("El paciente no tiene le celular");
    }
    if(pacienteEntity.getCorreo() == null|| pacienteEntity.getCorreo().trim().isEmpty())
    {
        throw new IllegalOperationException("El nombre del médico no puede ser nulo");
    }

    
    log.info("Termina proceso de creacion del medico");
    return pacienteRepository.save(pacienteEntity);
    
}
}
