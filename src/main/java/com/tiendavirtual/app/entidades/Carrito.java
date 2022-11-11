package com.tiendavirtual.app.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // definimos la relacion Muchos a Uno//
    @ManyToOne(fetch = FetchType.EAGER)
    // esta anotacion Nos permite identificar el nombtre de la columna en la tabla//
    @JoinColumn(name = "producto_id")
    private Producto producto;


    // Relacion uno a uno//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "cantidad")
    private Integer cantidad;

    private BigDecimal subtotal = BigDecimal.ZERO;

}
