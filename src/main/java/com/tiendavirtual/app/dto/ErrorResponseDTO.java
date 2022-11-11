package com.tiendavirtual.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {
	private String mensaje;
	private int codigoEstado;
	private String path;
	
	private List<ValidationErrorDTO> errores;
}
