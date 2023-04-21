package com.BusBooking.payload;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PassengerDTO {
    private Long id;
    private Long bookingId;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be")
    private String lastName;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 1, message = "Age must be greater than ")
    private Integer age;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    @NotNull(message = "Seat Number cannot be empty")
    @Min(value = 1, message = "Seat Number must be greater than")
    private Integer seatNumber;
}

