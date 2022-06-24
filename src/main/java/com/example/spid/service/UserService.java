package com.example.spid.service;

import com.example.spid.entities.User;
import com.example.spid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(long id, User user) throws Exception {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty() || findUser == null) {
            throw new Exception("User does not exist");
        }
        findUser.get().setName(user.getName());
        findUser.get().setSurname(user.getSurname());
        User updatedUser = userRepository.save(findUser.get());
        return userRepository.save(updatedUser);
    }

    public User getUser(Long id) throws Exception {
        Optional<User> retrieveUser = userRepository.findById(id);
        if (retrieveUser.isEmpty()){
            throw new Exception("User does not exist");
        }
        return retrieveUser.get();
    }

}
