package com.guibedan.ws.soap.ws.endpoint;

import com.guibedan.ws.soap.domain.Cliente;
import com.guibedan.ws.soap.domain.ClienteResultado;
import com.guibedan.ws.soap.exception.ClienteException;
import com.guibedan.ws.soap.service.ClienteService;
import com.guibedan.ws.soap.ws.contract.ClienteWs;
import com.guibedan.ws.soap.ws.dto.request.BuscarClienteRequest;
import com.guibedan.ws.soap.ws.dto.response.BuscarClienteResponse;
import jakarta.jws.WebService;
import org.springframework.stereotype.Component;

@Component
@WebService(
        endpointInterface = "com.guibedan.ws.soap.ws.contract.ClienteWs",
        serviceName = "ClienteService"
)
public class ClienteEndpoint implements ClienteWs {

    private final ClienteService service;

    public ClienteEndpoint(ClienteService service) {
        this.service = service;
    }

    @Override
    public BuscarClienteResponse buscarCliente(BuscarClienteRequest request) throws ClienteException {
        ClienteResultado resultado = service.buscarPorCpf(request.getCpf());

        if (resultado.temErro()) {
            throw new ClienteException(resultado.getErro());
        }

        BuscarClienteResponse response = new BuscarClienteResponse();
        response.setNome(resultado.getCliente().getNome());

        return response;
    }

}
