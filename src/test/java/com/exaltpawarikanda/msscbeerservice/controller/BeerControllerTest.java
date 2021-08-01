package com.exaltpawarikanda.msscbeerservice.controller;

import com.exaltpawarikanda.msscbeerservice.bootstrap.BeerLoader;
import com.exaltpawarikanda.msscbeerservice.enums.BeerStyle;
import com.exaltpawarikanda.msscbeerservice.model.BeerDto;
import com.exaltpawarikanda.msscbeerservice.service.api.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    BeerDto validBeerDto;

    @BeforeEach
    public void setUp(){
        validBeerDto= BeerDto.builder()
                .beerName("Castle")
                .beerStyle(BeerStyle.LAGER)
                .upc(BeerLoader.BEER_1_UPC)
                .price(new BigDecimal("2.99"))
                .build();
    }

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any(),any())).willReturn(validBeerDto);
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {

        BeerDto beerDto = validBeerDto;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.createBeer(any())).willReturn(validBeerDto);

        mockMvc.perform(post("/api/v1/beer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isOk());
    }

    @Test
    void updateBeerById() throws Exception{
        BeerDto beerDto = validBeerDto;
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.updateBeerById(any(),any())).willReturn(validBeerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isOk());
    }

    @Test
    void deleteBeerById()  throws Exception{
        given(beerService.deleteBeerById(any())).willReturn(validBeerDto);

        mockMvc.perform(delete("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}