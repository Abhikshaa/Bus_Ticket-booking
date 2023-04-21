package com.BusBooking.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_name", nullable = false)
    private String offerName;

    @Column(name = "promo_code", nullable = false)
    private String promoCode;

    @Column(name = "discount_type", nullable = false)
    private String discountType;

    @Column(name = "discount_value",nullable = false)
    private Double discountValue;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private Set<UserOffer> userOffers;

}


