package com.BusBooking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPaymentMethodDTO {
    private Long id;
    private Long userId;

    @NotEmpty(message = "Payment type cannot be empty")
    @Size(min = 2, max = 50, message = "Payment type")
    private String paymentType;

    @NotEmpty(message = "Card Number cannot be empty")
    @Size(min = 13, max = 19, message = "Password must be")
    private String cardNumber;

    @NotEmpty(message = "Expiration Date cannot be empty")
    private String expirationDate;

    @NotEmpty(message = "Card holder name cannot be empty")
    @Size(min = 2, max = 100, message = "Card holder name must be")
    private String cardHolderName;
}
