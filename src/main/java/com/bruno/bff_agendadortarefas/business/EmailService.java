package com.bruno.bff_agendadortarefas.business;


import com.bruno.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.bruno.bff_agendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail( TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }

}