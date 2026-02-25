package com.guibedan.ws.soap.service;

import com.guibedan.ws.soap.domain.Cliente;
import com.guibedan.ws.soap.domain.ClienteResultado;
import com.guibedan.ws.soap.domain.Erro;
import com.guibedan.ws.soap.entity.ClienteEntity;
import com.guibedan.ws.soap.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteResultado buscarPorCpf(String cpf) {

        if (!StringUtils.hasText(cpf)) {
            return ClienteResultado.erro("O campo não pode ser vazio");
        }

        Optional<ClienteEntity> entity =
                repository.findById(cpf);

        if (entity.isPresent()) {
            return ClienteResultado.sucesso(new Cliente(entity.get().getNome()));
        }

        return ClienteResultado.erro("Cliente não encontrado");
    }

}
