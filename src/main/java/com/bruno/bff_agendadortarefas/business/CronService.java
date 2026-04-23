package com.bruno.bff_agendadortarefas.business;

import com.bruno.bff_agendadortarefas.business.dto.in.LoginRequestDTO;
import com.bruno.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.bruno.bff_agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime agora = LocalDateTime.now().minusSeconds(5);
        LocalDateTime futuro = agora.plusHours(1);

        log.info("Agora: " + agora);
        log.info("Futuro: " + futuro);

        //Qualquer tarefa que fique entre hora atual - e a hora futura + 1
        // Se agora é 13:35h - qualquer tarefa entre 13:35 e 14:35
        //Antes --> era Se agora é 22h - qualquer tarefa entre 23h e 23h05

        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(agora, futuro, token);
        log.info("Tarefas Encontradas " + listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuario " + tarefa.getEmailUsuario());
            tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);

        });
            log.info("Finalizada a busca e notificação de tarefas");
    }

    public String login(LoginRequestDTO dto) {
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO() {
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }

}


