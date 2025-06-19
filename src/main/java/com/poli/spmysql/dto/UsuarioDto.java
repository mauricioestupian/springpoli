package com.poli.spmysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    private Integer id_user;
    private String nombres;
    private String apellidos;
    private byte id_ciudad;

}
