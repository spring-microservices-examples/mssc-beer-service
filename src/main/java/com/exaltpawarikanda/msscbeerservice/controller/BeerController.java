package com.exaltpawarikanda.msscbeerservice.controller;

import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.util.ApiConstants;
import com.exaltpawarikanda.msscbeerservice.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @Operation(summary = "Get a beer by beer id")
    @GetMapping("/{beerId}")
    public ApiResponse<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){

        //todo impl
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.OK,null);
    }

    @Operation(summary = "Create a beer")
    @PostMapping(value = "{id}")
    public ApiResponse<?> createBeer( @Validated @RequestBody BeerDto beerDto){

        //todo impl
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.CREATED,null);
    }

    @Operation(summary = "Update a beer by beer id")
    @PutMapping("/{beerId}")
    public ApiResponse<?> updateBeerById(@PathVariable("beerId") UUID beerId,@Validated @RequestBody BeerDto beerDto){

        //todo impl
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.NO_CONTENT,null);
    }

    @Operation(summary = "Delete a beer by beer id")
    @DeleteMapping("/{beerId}")
    public ApiResponse<?> deleteBeerById(@PathVariable("beerId") UUID beerId){

        //todo impl
        return new ApiResponse<>(ApiConstants.StatusCodes.SUCCESS, ApiConstants.Messages.NO_CONTENT,null);
    }


}
