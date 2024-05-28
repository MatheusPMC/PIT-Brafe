package com.Brafe.Brafe.domain.mapper;

import com.Brafe.Brafe.adapter.in.model.Produto;
import com.Brafe.Brafe.domain.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    List<Produto> map(List<ProdutoEntity> obj);
    ProdutoEntity map(Produto obj);
    Produto map(ProdutoEntity obj);
}