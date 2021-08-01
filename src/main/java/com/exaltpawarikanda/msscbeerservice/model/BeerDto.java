package com.exaltpawarikanda.msscbeerservice.model;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonIgnore
    @Null
    private UUID id;

    @JsonIgnore
    @Null
    private Long version;

    @Null
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdAt;

    @JsonIgnore
    @Null
    private OffsetDateTime lastUpdatedAt;

    @NotBlank
    private String beerName;

    @JsonProperty("beer-style")
    @NotNull
    private BeerStyle beerStyle;

    @NotNull
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;
}
