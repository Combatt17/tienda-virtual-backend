package com.tiendavirtual.app.entidades;

import com.tiendavirtual.app.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @NotNull(message = "El nombre es requerido.")
    private String nombre;

    @Column(name = "precio")
    @NotNull(message = "El precio unitario es requerido.")
    private BigDecimal precio;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "precio_compra")
    @NotNull(message = "El precio de compra es requerido.")
    private BigDecimal precioCompra;

    @Column(name = "estado")
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @NotNull(message = "la categoria  es requerida")
    // Relacion muchos a UNo//
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @PrePersist
    public void prePersist() {
    	this.fechaRegistro = LocalDate.now();
    }
}
