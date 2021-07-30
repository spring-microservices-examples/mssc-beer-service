package com.exaltpawarikanda.msscbeerservice.model;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Long version;
    @Null
    private OffsetDateTime createdAt;
    @Null
    private OffsetDateTime lastUpdatedAt;

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;
}
