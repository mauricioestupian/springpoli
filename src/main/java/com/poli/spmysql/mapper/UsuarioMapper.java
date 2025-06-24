package com.poli.spmysql.mapper;

import java.util.List;

import com.poli.spmysql.dto.UsuarioDto;
import com.poli.spmysql.models.Usuario;

public interface UsuarioMapper {

    Usuario toUsuario(UsuarioDto usuarioDto);

    UsuarioDto toUsuarioDto(Usuario usuario);

    List<UsuarioDto> toUsuariosDtos(List<Usuario> usuarios);

    void updateUsuario(Usuario usuario, UsuarioDto usuarioDto);

}
