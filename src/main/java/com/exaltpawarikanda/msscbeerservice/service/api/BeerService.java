package com.exaltpawarikanda.msscbeerservice.service.api;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.model.BeerPagedList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 8/1/21
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto deleteBeerById(UUID beerId);

    BeerPagedList listBeers(String beerName, BeerStyle beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getBeerByUpc(String upc);
}
