package com.BusBooking.payload;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BusOperatorDTO {
    private Long id;

    @NotEmpty(message = "Operator Name cannot be empty")
    @Size(min = 2, max = 100, message = "Operator Name must be")
    private String operatorName;

    @NotEmpty(message = "Invalid Email Format")
    private String contactEmail;

    @NotEmpty(message = "Contact Phone Number cannot be empty")
    @Size(min = 10, max = 15, message = "Contact Phone Number must be")
    private String contactPhone;

    private String logoUrl;


}

