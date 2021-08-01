package com.exaltpawarikanda.msscbeerservice.service.api;

import com.exaltpawarikanda.msscbeerservice.model.BeerDto;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 8/1/21
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto deleteBeerById(UUID beerId);
}
