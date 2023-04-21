package com.BusBooking.controller;

import com.BusBooking.payload.UserDTO;
import com.BusBooking.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phoneNumber") long phoneNumber,
            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) {
        //multiPartFile its help me to upload the image

        UserDTO userDTO = new UserDTO();//take that variable put on the dto
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setProfileImage(profileImage);

        UserDTO createdUser = userService.createUser(userDTO);//that dto create user
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId){

        userService.deleteUser(userId);

        return new ResponseEntity<>("user is deleted!!",HttpStatus.OK);
    }
@GetMapping
    public ResponseEntity <Page<UserDTO>> getUser(@PageableDefault(size = 10,sort = "id") Pageable pageable){

        Page<UserDTO> user = userService.getUser(pageable);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
}
