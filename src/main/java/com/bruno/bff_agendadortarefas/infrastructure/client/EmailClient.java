package com.bruno.bff_agendadortarefas.infrastructure.client;


import com.bruno.bff_agendadortarefas.business.dto.in.EnderecoDTORequest;
import com.bruno.bff_agendadortarefas.business.dto.in.LoginRequestDTO;
import com.bruno.bff_agendadortarefas.business.dto.in.TelefoneDTORequest;
import com.bruno.bff_agendadortarefas.business.dto.in.UsuarioDTORequest;
import com.bruno.bff_agendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.bruno.bff_agendadortarefas.business.dto.out.TarefasDTOResponse;
import com.bruno.bff_agendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.bruno.bff_agendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
     void enviarEmail(@RequestBody TarefasDTOResponse dto);

    }
