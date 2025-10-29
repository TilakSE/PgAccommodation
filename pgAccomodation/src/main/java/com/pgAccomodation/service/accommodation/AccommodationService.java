package com.pgAccomodation.service.accommodation;

import java.util.*;

import com.pgAccomodation.entity.Accommodation;

public interface AccommodationService {
	Accommodation create(Accommodation accommodation);
    Accommodation update(Long id, Accommodation accommodation);
    void delete(Long id);
    Optional<Accommodation> findById(Long id);
    List<Accommodation> findByCity(String city);
    List<Accommodation> findAll();
    List<Accommodation> searchByLocality(String locality);
    List<Accommodation> searchByLocalityAndMaxRent(String locality, Double maxRent);
}
