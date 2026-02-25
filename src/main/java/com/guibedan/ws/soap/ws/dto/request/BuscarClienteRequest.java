package com.guibedan.ws.soap.ws.dto.request;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "BuscarClienteRequest")
@XmlType(
        name = "BuscarClienteRequestDTO",
        namespace = "http://soap.seuprojeto.com/ws/dto"
)
@Getter
@Setter
public class BuscarClienteRequest {
    private String cpf;
}
