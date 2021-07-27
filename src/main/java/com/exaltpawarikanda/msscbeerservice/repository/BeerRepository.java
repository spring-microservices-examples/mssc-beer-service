package com.exaltpawarikanda.msscbeerservice.repository;

import com.exaltpawarikanda.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/27/21
 */
@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
