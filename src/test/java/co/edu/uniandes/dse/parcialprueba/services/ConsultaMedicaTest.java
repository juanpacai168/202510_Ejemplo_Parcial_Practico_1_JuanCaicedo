package co.edu.uniandes.dse.parcialprueba.services;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import({ConsultaMedicaService.class})
public class ConsultaMedicaTest {

    @Autowired
    private ConsultaMedicaService medicoEspecialidadService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private List<ConsultaMedicaEntity> medicoList = new ArrayList<>();

    @BeforeEach
    void setup() {
        clearData();
        insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("DELETE FROM ConsultaMedicaEntity").executeUpdate();
        
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ConsultaMedicaEntity medicoEntity = factory.manufacturePojo(ConsultaMedicaEntity.class);
        
        }
    }

    
    @Test
    void addconsulta() throws EntityNotFoundException {
        ConsultaMedicaEntity consulta = factory.manufacturePojo(ConsultaMedicaEntity.class);
        consulta.setId(n
    
        ConsultaMedicaEntity result = medicoEspecialidadService.createConsulta(consulta);
    
        assertNotNull(result);
        assertNotNull(result.getId());
    
        ConsultaMedicaEntity consultaBD = entityManager.find(ConsultaMedicaEntity.class, result.getId());
        assertNotNull(consultaBD);
        assertEquals(consulta.getFecha(), consultaBD.getFecha());
        assertEquals(consulta.getMedico(), consultaBD.getMedico());
        assertEquals(consulta.getPaciente(), consultaBD.getPaciente());
    }

    @Test
    void addconsulta() throws EntityNotFoundException{}
}
