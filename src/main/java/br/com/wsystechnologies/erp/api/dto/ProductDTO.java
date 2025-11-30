package br.com.wsystechnologies.erp.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private UUID id;

    @NotNull
    private UUID companyId;

    @NotBlank
    @Size(max = 64)
    private String sku;

    @NotBlank
    @Size(max = 255)
    private String name;

    private String description;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal unitPrice;

    private Boolean active;
}