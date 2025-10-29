package com.pgAccomodation.service.accommodation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pgAccomodation.entity.Accommodation;
import com.pgAccomodation.repository.AccommodationRepository;

@Service
public class AccommodationServiceImpl implements AccommodationService{

	private final AccommodationRepository repo;
	
	public AccommodationServiceImpl(AccommodationRepository repo) {
        this.repo = repo; // constructor injection
    }
	
	@Override
	public Accommodation create(Accommodation accommodation) {
		return repo.save(accommodation);
	}

	@Override
	public Accommodation update(Long id, Accommodation accommodation) {
		return repo.findById(id).map(existing -> {
            existing.setTitle(accommodation.getTitle());
            existing.setDescription(accommodation.getDescription());
            existing.setRent(accommodation.getRent());
            existing.setRoomType(accommodation.getRoomType());
            existing.setAvailableFrom(accommodation.getAvailableFrom());
            existing.setAddress(accommodation.getAddress());
            existing.setOwner(accommodation.getOwner());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Accommodation not found: " + id));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Accommodation> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Accommodation> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Accommodation> searchByLocality(String locality) {
		return repo.findByAddress_LocalityIgnoreCase(locality);
	}

	@Override
	public List<Accommodation> searchByLocalityAndMaxRent(String locality, Double maxRent) {
		return repo.findByAddress_LocalityIgnoreCaseAndRentLessThanEqual(locality, maxRent);
	}

	@Override
	public List<Accommodation> findByCity(String city) {
		return repo.findByAddress_City(city);
	}

}
