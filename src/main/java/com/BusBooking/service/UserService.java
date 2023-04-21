package com.BusBooking.service;

import com.BusBooking.payload.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    void deleteUser(long userId);

    Page<UserDTO> getUser(Pageable pageable);
}
