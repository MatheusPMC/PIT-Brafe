package com.Brafe.Brafe.domain.mapper;

import com.Brafe.Brafe.adapter.in.model.Endereco;
import com.Brafe.Brafe.adapter.in.model.Usuario;
import com.Brafe.Brafe.domain.entity.EnderecoEntity;
import com.Brafe.Brafe.domain.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper( EnderecoMapper.class );

    Endereco map(EnderecoEntity obj);
    List<Endereco> map(List<EnderecoEntity> obj);
    EnderecoEntity mapToEntity(Endereco obj);

}