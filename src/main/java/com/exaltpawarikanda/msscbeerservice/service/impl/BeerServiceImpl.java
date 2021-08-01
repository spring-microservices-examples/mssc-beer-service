package com.exaltpawarikanda.msscbeerservice.service.impl;

import com.exaltpawarikanda.msscbeerservice.domain.Beer;
import com.exaltpawarikanda.msscbeerservice.enums.BeerStatus;
import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.exaltpawarikanda.msscbeerservice.exceptions.NotFoundException;
import com.exaltpawarikanda.msscbeerservice.mappers.BeerMapper;
import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.model.BeerPagedList;
import com.exaltpawarikanda.msscbeerservice.repository.BeerRepository;
import com.exaltpawarikanda.msscbeerservice.service.api.BeerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Exalt Pawarikanda on 8/1/21
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyle beerStyle, PageRequest pageRequest) {
       BeerPagedList beerPagedList;
        Page<Beer> beerPage;

        if(!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)){
            //search both
            beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName,beerStyle,pageRequest);
        }else if(!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)){
            //search by beer name
            beerPage = beerRepository.findAllByBeerName(beerName,pageRequest);
        }else if(StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)){
            //search by beer style
            beerPage = beerRepository.findAllByBeerStyle(beerStyle,pageRequest);
        }else{
            beerPage = beerRepository.findAll(pageRequest);
        }

        beerPagedList = new BeerPagedList(beerPage
                .getContent()
                .stream()
                .map(beerMapper::beerToBeerDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(beerPage.getPageable().getPageNumber(),
                                beerPage.getPageable().getPageSize()),
                beerPage.getTotalElements());

        return beerPagedList;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto deleteBeerById(UUID beerId) {
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new);

        beer.setStatus(BeerStatus.DELETED.name());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }


}
