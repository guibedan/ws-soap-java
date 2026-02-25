package com.guibedan.ws.soap.ws.contract;

import com.guibedan.ws.soap.exception.ClienteException;
import com.guibedan.ws.soap.ws.dto.request.BuscarClienteRequest;
import com.guibedan.ws.soap.ws.dto.response.BuscarClienteResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
        name = "ClienteService",
        targetNamespace = "http://ws.soap.com/ws"
)
public interface ClienteWs {

    @WebMethod
    BuscarClienteResponse buscarCliente(BuscarClienteRequest request) throws ClienteException;

}
