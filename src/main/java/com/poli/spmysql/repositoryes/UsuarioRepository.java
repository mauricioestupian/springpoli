package com.poli.spmysql.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.spmysql.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
