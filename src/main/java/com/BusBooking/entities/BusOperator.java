package com.BusBooking.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bus_operators")
public class BusOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private Long contactPhone;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "busOperator", cascade = CascadeType.ALL)
    private Set<Bus> buses;

}

