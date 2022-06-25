package com.example.spid.service;

import com.example.spid.entities.User;
import com.example.spid.exceptions.customExceptions.NoUserFoundException;
import com.example.spid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(Long id) throws NoUserFoundException {
        Optional<User> retrieveUser = userRepository.findById(id);
        if (retrieveUser.isEmpty()) {
            throw new NoUserFoundException("User does not exist");
        }
        return retrieveUser.get();
    }

    public User createUser(User user) {
        user.setCreatedBy(user.getUsername());
        return userRepository.save(user);
    }

    public User editUser(long id, User user) throws Exception, NoUserFoundException {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty() || findUser == null) {
            throw new NoUserFoundException("User does not exist");
        }
        findUser.get().setName(user.getName());
        findUser.get().setSurname(user.getSurname());
        user.setId(id);
        return userRepository.save(user);
    }


}
