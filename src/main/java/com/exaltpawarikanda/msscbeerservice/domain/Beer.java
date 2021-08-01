package com.exaltpawarikanda.msscbeerservice.domain;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/27/21
 */
@Data
@NoArgsConstructor
@Entity
public class Beer extends BaseEntity{

    @Builder
    public Beer(UUID id, Long version, Timestamp createdAt, Timestamp lastUpdatedAt, String beerName, String beerStyle, String upc, BigDecimal price, Integer quantityOnHand, Integer minOnHand, Integer quantityToBrew, String status) {
        super(id, version, createdAt, lastUpdatedAt);
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.quantityOnHand = quantityOnHand;
        this.minOnHand = minOnHand;
        this.quantityToBrew = quantityToBrew;
        this.status = status;
    }


    @Column(name = "beerName")
    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private String upc;

    private BigDecimal price;
    private Integer quantityOnHand;
    private Integer minOnHand;
    private Integer quantityToBrew;
    private String status;

}
