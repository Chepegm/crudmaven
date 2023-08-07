package com.example_apimongo.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Document(value = "cliente")
@Data
@AllArgsConstructor
public class ClienteEntity {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private Integer id;
    @NotEmpty(message = "El campo nombre esta vacío")
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    @Email(message = "Correo no Completado")
    private String correo;

}
