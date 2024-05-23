package com.Brafe.Brafe.port.in;

import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;

public interface ValidationUtilPort {

    UsuarioEntity validandoDadosNulosUsuarios(Usuario usuario, UsuarioEntity usuarioEntity);
}
