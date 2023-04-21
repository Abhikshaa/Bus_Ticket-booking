package com.BusBooking.repository;

import com.BusBooking.entities.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {
}
