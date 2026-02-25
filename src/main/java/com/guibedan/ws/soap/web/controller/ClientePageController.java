package com.guibedan.ws.soap.web.controller;

import com.guibedan.ws.soap.domain.Cliente;
import com.guibedan.ws.soap.domain.ClienteResultado;
import com.guibedan.ws.soap.domain.Erro;
import com.guibedan.ws.soap.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClientePageController {

    private final ClienteService service;

    public ClientePageController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String paginaCliente() {
        return "cliente";
    }

    @PostMapping("/buscar")
    public String buscarCliente(@RequestParam String cpf, HttpServletRequest request) {

        ClienteResultado resultado = service.buscarPorCpf(cpf);

        if (resultado.temErro()) {
            request.setAttribute("mensagem", resultado.getErro());
            request.setAttribute("cpf", cpf);
            return "erro";
        }

        request.setAttribute("nome", resultado.getCliente().getNome());
        request.setAttribute("cpf", cpf);

        return "cliente";
    }

}
