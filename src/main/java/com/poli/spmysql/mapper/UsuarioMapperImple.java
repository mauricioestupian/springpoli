package com.poli.spmysql.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poli.spmysql.dto.UsuarioDto;
import com.poli.spmysql.models.Usuario;

@Component
public class UsuarioMapperImple implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId_user(usuarioDto.getId_user());
        usuario.setNombres(usuarioDto.getNombres());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setId_ciudad(usuarioDto.getId_ciudad());

        return usuario;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId_user(usuario.getId_user());
        usuarioDto.setNombres(usuario.getNombres());
        usuarioDto.setApellidos(usuario.getApellidos());
        usuarioDto.setId_ciudad(usuario.getId_ciudad());

        return usuarioDto;
    }

    @Override
    public List<UsuarioDto> toUsuariosDtos(List<Usuario> usuarios) {
        if (usuarios == null) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>(usuarios.size());
        for (Usuario usuario : usuarios) {
            list.add(toUsuarioDto(usuario));
        }
        return list;
    }

    @Override
    public void updateUsuario(Usuario usuario, UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return;
        }

        usuario.setId_user(usuarioDto.getId_user());
        usuario.setNombres(usuarioDto.getNombres());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setId_ciudad(usuarioDto.getId_ciudad());

    }

}
