package com.exaltpawarikanda.msscbeerservice.bootstrap;

import com.exaltpawarikanda.msscbeerservice.domain.Beer;
import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.exaltpawarikanda.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Exalt Pawarikanda on 7/27/21
 */
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "00424121423414";
    public static final String BEER_2_UPC = "00894794874873";
    public static final String BEER_3_UPC = "00432628468341";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
           beerRepository.save(Beer.builder()
                   .beerName("Amarula")
                   .beerStyle("GOSE")
                   .quantityToBrew(200)
                   .minOnHand(12)
                   .upc(BEER_1_UPC)
                   .price(new BigDecimal("23.45"))
                   .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("123.45"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Castle")
                    .beerStyle("LAGER")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("43.45"))
                    .build());
        }
    }


}
