package com.tiendavirtual.app.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relacion de clases//

    @OneToOne(fetch = FetchType.LAZY) //1//

    @JoinColumn(name = "pedido_id") //2//
    private Pedido pedido;

    // relacion de Clases//
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;


    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private BigDecimal precio;
}
