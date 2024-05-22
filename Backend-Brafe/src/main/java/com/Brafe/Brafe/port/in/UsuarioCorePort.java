package com.Brafe.Brafe.port.in;

import com.Brafe.Brafe.adapter.in.model.Login;
import com.Brafe.Brafe.adapter.in.model.Usuario;

public interface UsuarioCorePort {
    Usuario login(Login login);
}
