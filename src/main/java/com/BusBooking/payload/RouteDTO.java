package com.BusBooking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {
    private Long id;

    @NotEmpty(message = "Origin cannot be empty")
    @Size(min = 2, max = 100, message = "Origin must be")
    private String origin;

    @NotEmpty(message = "Destination cannot be empty")
    @Size(min = 2, max = 100, message = "Destination must be")
    private String destination;

    @NotNull(message = "Distance cannot be empty")
    private Double distance;
}
