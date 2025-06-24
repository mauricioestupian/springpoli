package com.poli.spmysql.services;

import java.util.List;

import com.poli.spmysql.dto.UsuarioDto;

public interface UsuarioServices {

    public List<UsuarioDto> getUsuarios();

    public UsuarioDto save(UsuarioDto usuarioDto);

    public UsuarioDto getUsuario(Integer usuarioid);

    public UsuarioDto update(Integer usuarioid, UsuarioDto usuarioDto);

    public UsuarioDto deleteUsuario(Integer usuarioid);

}
