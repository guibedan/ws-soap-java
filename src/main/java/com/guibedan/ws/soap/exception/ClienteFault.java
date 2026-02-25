package com.guibedan.ws.soap.exception;

import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "ClienteFault")
public class ClienteFault {
    private String mensagem;
}
