package com.exaltpawarikanda.msscbeerservice.domain;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by Exalt Pawarikanda on 7/27/21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer extends BaseEntity {

    private String beerName;
    private BeerStyle beerStyle;

    @Column(unique = true)
    private Long upc;

    private BigDecimal price;
    private Integer quantityOnHand;
    private Integer minOnHand;
    private Integer quantityToBrew;

}
