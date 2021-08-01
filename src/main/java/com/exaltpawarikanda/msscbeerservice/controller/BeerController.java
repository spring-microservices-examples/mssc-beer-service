package com.exaltpawarikanda.msscbeerservice.controller;

import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.service.api.BeerService;
import com.exaltpawarikanda.msscbeerservice.util.ApiConstants;
import com.exaltpawarikanda.msscbeerservice.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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

    private final BeerService beerService;

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
