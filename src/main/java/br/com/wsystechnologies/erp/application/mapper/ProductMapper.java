package br.com.wsystechnologies.erp.application.mapper;

import br.com.wsystechnologies.erp.api.dto.ProductDTO;
import br.com.wsystechnologies.erp.domain.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product entity);

    Product toEntity(ProductDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ProductDTO dto, @MappingTarget Product entity);
}