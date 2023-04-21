package com.BusBooking.service.impl;

import com.BusBooking.entities.User;
import com.BusBooking.payload.UserDTO;
import com.BusBooking.repository.UserRepository;
import com.BusBooking.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;
    private  String uploadDirectory = "src/main/resources/static/user_profile_image/";

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = dtoToUser(userDTO);// this method is converted dto to entity
        user.setCreatedAt(new Date());//its give me date and time
        user.setUpdatedAt(new Date());//its give me to update date and time

        // Encode the password
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));

        MultipartFile profileImage = userDTO.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {//both conditions are true
            String fileName = saveProfileImage(profileImage);//then it is save the image
            user.setProfilePicture(fileName);
        }

        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }

    @Override
    public void deleteUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found with"));

        userRepository.delete(user);
    }

    @Override
    public Page<UserDTO> getUser(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        List<UserDTO> collect = users.stream().map(this::userToDto).collect(Collectors.toList());
        return new PageImpl<>(collect,pageable,users.getTotalElements());
    }

    private UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPasswordHash());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }

    private String saveProfileImage(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf('.'));
            String baseFileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
            String uniqueFileName = baseFileName + "_" + System.currentTimeMillis() + fileExtension;
            Path path = Paths.get(uploadDirectory + uniqueFileName);
            Files.write(path, bytes);

            return uniqueFileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save profile image", e);
        }
    }

    private User dtoToUser(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPassword());
        user.setPhoneNumber((userDTO.getPhoneNumber()));
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        return user;
    }
}
