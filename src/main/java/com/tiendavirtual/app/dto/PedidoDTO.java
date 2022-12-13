package com.tiendavirtual.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.tiendavirtual.app.entidades.DetallePedido;

import com.tiendavirtual.app.entidades.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
 
    private Long codigo;

    private LocalDate fechaPedido;

    private BigDecimal total;


    private Usuario usuario;

    private List<DetallePedido> detallePedido;
}
