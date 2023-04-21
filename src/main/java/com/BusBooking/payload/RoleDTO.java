package com.BusBooking.payload;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RoleDTO {
    private Long id;

    @NotEmpty(message = "Role name cannot be empty")
    @Size(min = 2, max = 50, message = "Role name must")
    private String roleName;
}

