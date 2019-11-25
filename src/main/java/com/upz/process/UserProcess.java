package com.upz.process;

import com.upz.dto.User;
import com.upz.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UserProcess {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity registerUser(User userDto) {

        userDto.setActive(true);
        userDto.setRoles("USER");


        this.userRepository.save(userDto);
        if (userDto.getId() > 0) {
            return new ResponseEntity(userDto.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(userDto.getId(), HttpStatus.CONFLICT);
        }

    }
}
