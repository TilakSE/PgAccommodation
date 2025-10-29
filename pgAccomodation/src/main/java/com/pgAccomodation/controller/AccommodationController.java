package com.pgAccomodation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pgAccomodation.entity.Accommodation;
import com.pgAccomodation.service.accommodation.AccommodationService;

@RestController
@RequestMapping("/pg")
public class AccommodationController {
    private final AccommodationService service;

    public AccommodationController(AccommodationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Accommodation> all() {
        return service.findAll();
    }

//    @GetMapping("/{city}")
//    public ResponseEntity<Accommodation> get(@PathVariable String city) {
//        return service.findByCity(city).map(ResponseEntity::ok)
//                      .orElse(ResponseEntity.notFound().build());
//    }
    
    @GetMapping("/{city}")
    public List<Accommodation> get(@PathVariable String city) {
        return service.findByCity(city);
    }

    @PostMapping
    public ResponseEntity<Accommodation> create(@RequestBody Accommodation accommodation) {
        Accommodation saved = service.create(accommodation);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody Accommodation accommodation) {
        return ResponseEntity.ok(service.update(id, accommodation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Accommodation> search(@RequestParam(required = false) String locality,
                                      @RequestParam(required = false) Double maxRent) {
        if (locality != null && maxRent != null) {
            return service.searchByLocalityAndMaxRent(locality, maxRent);
        } else if (locality != null) {
            return service.searchByLocality(locality);
        } else if (maxRent != null) {
            // fallback repository call (could be a method in service)
            return service.findAll().stream()
                          .filter(a -> a.getRent() != null && a.getRent() <= maxRent)
                          .toList();
        } else {
            return service.findAll();
        }
    }
}