package com.BusBooking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOfferDTO {

    private Long userId;
    private Long offerId;

}
