package com.codemonkey.config;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix="aplicacion")
@Validated
@Component
public class Propiedades{
    private @Getter @Setter String home;
    private @Getter @Setter String usuarios;
    private @Getter @Setter String computadoras;
    private @Getter @Setter String departamentos;
    private @Getter @Setter String detalle;
}
