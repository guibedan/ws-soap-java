package com.guibedan.ws.soap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

    @Id
    @Column(length = 11)
    private String cpf;
    private String nome;

}
