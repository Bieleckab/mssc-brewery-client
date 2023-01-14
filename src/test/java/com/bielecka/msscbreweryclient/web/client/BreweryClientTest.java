package com.bielecka.msscbreweryclient.web.client;

import com.bielecka.msscbreweryclient.web.model.BeerDto;
import com.bielecka.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        //given
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Joe").build();

        URI uri = client.saveNewCustomer(dto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Jim").build();

        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}