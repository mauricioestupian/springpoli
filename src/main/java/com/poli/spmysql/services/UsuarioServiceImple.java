package com.poli.spmysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poli.spmysql.dto.UsuarioDto;
import com.poli.spmysql.mapper.UsuarioMapper;
import com.poli.spmysql.models.Usuario;
import com.poli.spmysql.repositoryes.UsuarioRepository;

@Service
public class UsuarioServiceImple implements UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDto);
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioDto> getUsuarios() {
        return usuarioMapper.toUsuariosDtos(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto getUsuario(Integer usuarioid) {
        Usuario usuario = usuarioRepository.findById(usuarioid).get();
        return usuarioMapper.toUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto update(Integer usuarioid, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(usuarioid).get();
        usuarioMapper.updateUsuario(usuario, usuarioDto);
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto deleteUsuario(Integer usuarioid) {
        Usuario usuario = usuarioRepository.findById(usuarioid).get();
        UsuarioDto usuarioDto = usuarioMapper.toUsuarioDto(usuario);
        return usuarioDto;
    }

}
