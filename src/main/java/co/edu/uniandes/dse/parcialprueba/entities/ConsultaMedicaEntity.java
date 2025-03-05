package co.edu.uniandes.dse.parcialprueba.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
public class ConsultaMedicaEntity extends BaseEntity{

    private Date fecha;
    private String causa;

    @ManyToOne
	private PacienteEntity pacienteEntity;
    

}
    


