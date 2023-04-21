package com.BusBooking.payload;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FeedbackDTO {
    private Long id;
    private Long userId;

    @NotNull(message = "Rating cannot be empty")
    @Min(value = 1, message = "Rating must be between 1 to 5")
    @Max(value = 5, message = "Rating must be between 1 to 5")
    private Integer rating;

    private String comments;
}
