package com.pgAccomodation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgAccomodation.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long>{

}
