package com.BusBooking.repository;

import com.BusBooking.entities.UserRole;
import com.BusBooking.utils.UserRoleId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}

