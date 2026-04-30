package com.bruno.bff_agendadortarefas.infrastructure.client;



import com.bruno.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
     void enviarEmail(@RequestBody TarefasDTOResponse dto);

    }
