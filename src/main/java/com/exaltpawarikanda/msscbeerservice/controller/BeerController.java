package com.exaltpawarikanda.msscbeerservice.controller;

import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.model.BeerPagedList;
import com.exaltpawarikanda.msscbeerservice.service.api.BeerService;
import com.exaltpawarikanda.msscbeerservice.util.ApiConstants;
import com.exaltpawarikanda.msscbeerservice.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE= 25;
    private final BeerService beerService;

    @Operation(summary = "Get all beers")
    @GetMapping(produces = "application/json")
    public ApiResponse<BeerPagedList> listBeers(
            @RequestParam(value = "pageNumber",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",required = false)Integer pageSize,
            @RequestParam(value = "beerName",required = false)String beerName,
            @RequestParam(value = "beerStyle",required = false) BeerStyle beerStyle){

        if(pageNumber == null || pageNumber < 0){
           pageNumber =  DEFAULT_PAGE_NUMBER;
        }

        if(pageSize == null || pageSize < 1){
            pageSize =  DEFAULT_PAGE_SIZE;
        }

        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.OK,beerService.listBeers(beerName,beerStyle, PageRequest.of(pageNumber,pageSize)));
    }

    @Operation(summary = "Get a beer by beer id")
    @GetMapping("/{beerId}")
    public ApiResponse<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.OK,beerService.getBeerById(beerId));
    }

    @Operation(summary = "Create a beer")
    @PostMapping
    public ApiResponse<?> createBeer( @Validated @RequestBody BeerDto beerDto){
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.CREATED,beerService.createBeer(beerDto));
    }

    @Operation(summary = "Update a beer by beer id")
    @PutMapping("/{beerId}")
    public ApiResponse<?> updateBeerById(@PathVariable("beerId") UUID beerId,@Validated @RequestBody BeerDto beerDto){
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.OK,beerService.updateBeerById(beerId,beerDto));
    }

    @Operation(summary = "Delete a beer by beer id")
    @DeleteMapping("/{beerId}")
    public ApiResponse<?> deleteBeerById(@PathVariable("beerId") UUID beerId){
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.OK,beerService.deleteBeerById(beerId));
    }


}
