package com.BusBooking.payload;





import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BusDTO {
    private Long id;
    private Long operatorId;

    @NotEmpty(message = "Bus type cannot be empty")
    @Size(min = 2, max = 50, message = "Bus type must be")
    private String busType;

    @NotNull(message = "Password cannot be empty")
    @Min(value = 1, message = "Password must be greater than 1")
    private Integer totalSeats;

    private String amenities;
}

