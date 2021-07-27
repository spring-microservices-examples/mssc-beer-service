package com.exaltpawarikanda.msscbeerservice.model;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID id;
    private Long version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyle beerStyle;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;
}
