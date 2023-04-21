package com.BusBooking.payload;

import com.BusBooking.entities.Role;
import com.BusBooking.entities.User;
import com.BusBooking.utils.UserRoleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserRoleDTO {

    private long userId;

    private long roleId;
}
