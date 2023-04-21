package com.BusBooking.repository;

import com.BusBooking.entities.UserOffer;
import com.BusBooking.utils.UserOfferId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOfferRepository extends JpaRepository<UserOffer, UserOfferId> {
}

