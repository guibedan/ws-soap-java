package com.guibedan.ws.soap.exception;

import jakarta.xml.ws.WebFault;

@WebFault(name = "ClienteFault")
public class ClienteException extends Exception {
    private final ClienteFault faultInfo;

    public ClienteException(String message) {
        super(message);
        this.faultInfo = new ClienteFault(message);
    }

    public ClienteFault getFaultInfo() {
        return faultInfo;
    }
}
