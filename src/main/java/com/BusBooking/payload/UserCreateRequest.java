package com.BusBooking.payload;

import org.springframework.web.multipart.MultipartFile;

public class UserCreateRequest {
    private UserDTO userDTO;
    private MultipartFile profileImage;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MultipartFile getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }
}
//This payload class is typically used by a Spring MVC controller to handle the HTTP request,
// extract the user input and image
// file data from the request, and pass it to a service layer for further processing.