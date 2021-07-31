package com.exaltpawarikanda.msscbeerservice.controller;

import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
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
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){

        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @Operation(summary = "Create a beer")
    @PostMapping
    public ResponseEntity createBeer( @Validated @RequestBody BeerDto beerDto){

        //todo impl
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update a beer by beer id")
    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@Validated @RequestBody BeerDto beerDto){

        //todo impl
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete a beer by beer id")
    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId){

        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
