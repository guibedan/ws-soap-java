package com.guibedan.ws.soap.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResultado {
    private Cliente cliente;
    private String erro;

    public static ClienteResultado sucesso(Cliente cliente) {
        ClienteResultado r = new ClienteResultado();
        r.cliente = cliente;
        return r;
    }

    public static ClienteResultado erro(String mensagem) {
        ClienteResultado r = new ClienteResultado();
        r.erro = mensagem;
        return r;
    }

    public boolean temErro() {
        return erro != null;
    }
}
