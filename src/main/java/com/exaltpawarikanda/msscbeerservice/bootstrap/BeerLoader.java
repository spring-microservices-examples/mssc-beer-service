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
                   .beerStyle(BeerStyle.GOSE)
                   .quantityToBrew(200)
                   .minOnHand(12)
                   .upc(61397311111L)
                   .price(new BigDecimal("23.45"))
                   .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.ALE)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(61397313311L)
                    .price(new BigDecimal("123.45"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Castle")
                    .beerStyle(BeerStyle.LAGER)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(613973343411L)
                    .price(new BigDecimal("43.45"))
                    .build());
        }
    }


}
