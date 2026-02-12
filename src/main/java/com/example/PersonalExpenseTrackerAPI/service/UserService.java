package com.example.PersonalExpenseTrackerAPI.service;

import com.example.PersonalExpenseTrackerAPI.entity.User;
import com.example.PersonalExpenseTrackerAPI.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User registerUser(User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already registered");
        }
        else {
            return userRepository.save(user);
        }
    }

}
