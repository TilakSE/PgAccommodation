package com.pgAccomodation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgAccomodation.entity.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	List<Accommodation> findByAddress_LocalityIgnoreCase(String locality);
    List<Accommodation> findByRentLessThanEqual(Double maxRent);
    List<Accommodation> findByAddress_LocalityIgnoreCaseAndRentLessThanEqual(String locality, Double maxRent);
	List<Accommodation> findByAddress_City(String city);
}
