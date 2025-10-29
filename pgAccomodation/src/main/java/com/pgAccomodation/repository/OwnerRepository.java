package com.pgAccomodation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgAccomodation.entity.Owner;

public interface OwnerRepository  extends JpaRepository<Owner, Long> {

}
