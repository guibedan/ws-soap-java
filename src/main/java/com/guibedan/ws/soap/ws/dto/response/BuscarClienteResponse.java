package com.guibedan.ws.soap.ws.dto.response;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "BuscarClienteResponse")
@XmlType(
        name = "BuscarClienteResponseDTO",
        namespace = "http://soap.seuprojeto.com/ws/dto"
)
@Getter
@Setter
public class BuscarClienteResponse {
    private String nome;
}
