package co.edu.uniandes.dse.parcialprueba.services;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.nullable;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsultaMedicaService {
@Autowired
private ConsultaMedicaRepository consultaMedicaRepository;


@Transactional
public ConsultaMedicaEntity createconsulta(ConsultaMedicaEntity consultamedicaEntity) throws IllegalOperationException {
    log.info("Inicia proceso de creación de la consulta");
    
    if(consultamedicaEntity.getCausa() == null|| consultamedicaEntity.getCausa().trim().isEmpty())
    {
        throw new IllegalOperationException("El nombre del médico no puede ser nulo");
    }
    if(consultamedicaEntity.getFecha().after(new Date()) == false ) 
    {throw new IllegalOperationException ("la fecha de consulta no es mayor a la actual");}
    log.info("Termina proceso de creacion de la consulta");
    return consultaMedicaRepository.save(consultamedicaEntity);
    }

    


    
}

