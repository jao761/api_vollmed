package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private Cancelamento motivoCancelamento;

    public Consulta() {}

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime data, Cancelamento motivoCancelamento) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Cancelamento getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void cancelar(Cancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }
}
