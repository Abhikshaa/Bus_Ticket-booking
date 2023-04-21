package com.BusBooking.utils;

import java.io.Serializable;
import java.util.Objects;

public class UserOfferId implements Serializable {

    private Long user;
    private Long offer;

    public UserOfferId() {
    }

    public UserOfferId (Long user, Long offer) {
        this.user = user;
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(o == null || getClass() != o.getClass())
            return false;
        UserOfferId that = (UserOfferId) o;
        return Objects.equals(user, that.user) && Objects.equals(offer, that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, offer);
    }
}
