package com.exaltpawarikanda.msscbeerservice.service.api;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 8/1/21
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
