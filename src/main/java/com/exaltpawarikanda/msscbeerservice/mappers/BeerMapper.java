package com.exaltpawarikanda.msscbeerservice.mappers;

import com.exaltpawarikanda.msscbeerservice.domain.Beer;
import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by Exalt Pawarikanda on 7/31/21
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
