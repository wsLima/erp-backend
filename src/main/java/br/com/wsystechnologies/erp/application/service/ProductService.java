package br.com.wsystechnologies.erp.application.service;

import br.com.wsystechnologies.erp.api.dto.ProductDTO;
import br.com.wsystechnologies.erp.application.mapper.ProductMapper;
import br.com.wsystechnologies.erp.domain.model.Product;
import br.com.wsystechnologies.erp.infrastructure.persistence.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO create(ProductDTO dto) {
        Product entity = productMapper.toEntity(dto);
        entity = productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> listAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(UUID id) {
        Product entity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productMapper.toDto(entity);
    }

    public ProductDTO update(UUID id, ProductDTO dto) {
        Product entity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productMapper.updateEntityFromDto(dto, entity);
        entity = productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    public void delete(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}