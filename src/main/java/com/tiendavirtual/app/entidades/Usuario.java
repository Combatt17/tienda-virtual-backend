package com.tiendavirtual.app.entidades;

import com.tiendavirtual.app.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    // Relaciones entre clases de Usuario//
    @Column(name = "estado")
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private DetalleUsuario detalle;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;
    @PrePersist
    public void prePersist() {
    	this.fechaRegistro = LocalDate.now();
    }
}
