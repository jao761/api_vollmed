package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class CancelarConsultaComAntecendencia {

    public void validar(DadosDetalhamentoConsulta dados) {

        var agora = LocalDateTime.now();
        var dataConsulta = dados.data();

        var difrencaEmHoras = Duration.between(agora, dataConsulta).toHours();

        if (difrencaEmHoras < 24) {
            throw new ValidacaoException("Nescessário cancelar 24 horas antes da consulta");
        }

    }
}
