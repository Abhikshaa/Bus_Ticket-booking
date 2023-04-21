package com.BusBooking.entities;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_payment_methods")
public class UserPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}


