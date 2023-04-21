package com.BusBooking.entities;


import com.BusBooking.utils.UserOfferId;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_offers")
@IdClass(UserOfferId.class)
@Data
@NoArgsConstructor
public class UserOffer implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", nullable = false)
    private Offer offer;
}

