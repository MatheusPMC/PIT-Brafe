package com.Brafe.Brafe.domain.mapper;

import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    Usuario map(UsuarioEntity obj);
    UsuarioEntity mapToEntity(Usuario obj);
}