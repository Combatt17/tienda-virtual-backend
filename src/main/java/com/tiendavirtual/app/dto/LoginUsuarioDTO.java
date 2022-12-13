package com.tiendavirtual.app.dto;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUsuarioDTO {

	   @NotBlank
	    private String email;
	    @NotBlank
	    private String password;

}
