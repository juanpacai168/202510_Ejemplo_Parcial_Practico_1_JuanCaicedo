package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;
@Slf4j
@Service
public class PacienteConsultaMedicaService {
    @Autowired
    private ConsultaMedicaRepository consultamedicaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    

    @Transactional
    public PacienteEntity addConsulta(Long consultamedicaId, Long pacienteId) throws EntityNotFoundException {
        log.info("Inicia proceso de agregar consulta a un paciente");

        
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(pacienteId);
        if (pacienteEntity.isEmpty()) {
            throw new EntityNotFoundException("paciente no  encontrado con id: " + pacienteId);
        }


        Optional<ConsultaMedicaEntity> consultamedicaEntity = consultamedicaRepository.findById(consultamedicaId);
        if (consultamedicaEntity.isEmpty()) {
            throw new EntityNotFoundException("Consulta médica no encontrada con id: " + consultamedicaId);
        }

        pacienteEntity.get().getReviews().add(consultamedicaEntity.get());

     
        pacienteRepository.save(pacienteEntity.get());

        log.info("Termina proceso de agregar consulta con id = {} al paciente con id = {}");
        return pacienteEntity.get();
        }

        @Transactional
        public PacienteEntity addConsultasprogramadas(Long pacienteId) throws EntityNotFoundException {
        Optional<PacienteEntity> pacienteEnt = pacienteRepository.findById(pacienteId);
        if (pacienteEnt.isEmpty()) {
            throw new EntityNotFoundException("No hay");
        }
        return pacienteEnt.get();
}}
