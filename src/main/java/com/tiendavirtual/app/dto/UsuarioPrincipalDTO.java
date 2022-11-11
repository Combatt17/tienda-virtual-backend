package com.tiendavirtual.app.dto;

import com.tiendavirtual.app.entidades.DetalleUsuario;
import com.tiendavirtual.app.entidades.Rol;
import com.tiendavirtual.app.entidades.Usuario;
import com.tiendavirtual.app.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
@Data
public class UsuarioPrincipalDTO implements UserDetails {
    private String email;
    private String password;
    private LocalDate fechaRegistro;
    private Estado estado;
    private DetalleUsuario detalle;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipalDTO(String email, String password, LocalDate fechaRegistro, Estado estado, DetalleUsuario detalle,  Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.detalle = detalle;
        this.authorities = authorities;
    }

    public static UsuarioPrincipalDTO construir(Usuario usuario){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre());
        authorities.add(authority);

        return new UsuarioPrincipalDTO(usuario.getEmail(), usuario.getPassword(), usuario.getFechaRegistro(), usuario.getEstado(), usuario.getDetalle() ,authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
