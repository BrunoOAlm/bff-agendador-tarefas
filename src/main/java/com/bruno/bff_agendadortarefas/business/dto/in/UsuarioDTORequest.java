package com.bruno.bff_agendadortarefas.business.dto.in;

import com.bruno.bff_agendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.bruno.bff_agendadortarefas.business.dto.out.TelefoneDTOResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;



}
