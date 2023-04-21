package com.BusBooking.payload;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfferDTO {
    private Long id;

    @NotEmpty(message = "Offer Name cannot be empty")
    @Size(min = 2, max = 100, message = "Offer Name must be")
    private String offerName;

    @NotEmpty(message = "Promo Code cannot be empty")
    @Size(min = 2, max = 50, message = "Promo Code must be")
    private String promoCode;

    @NotEmpty(message = "Discount type cannot be empty")
    private String discountType;

    @NotNull(message = "Discount value cannot be empty")
    private Double discountValue;

    @NotNull(message = "Start Date cannot be empty")
    private Date startDate;

    @NotNull(message = "End Date cannot be empty")
    private Date endDate;

}
