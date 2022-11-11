package com.tiendavirtual.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUsuarioDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
