package com.Brafe.Brafe.domain.mapper;

import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
//public abstract class SimpleDestinationMapperUsingInjectedService {
//
//}
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
        Usuario map(UsuarioEntity obj);
}
