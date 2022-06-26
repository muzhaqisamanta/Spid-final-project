package com.example.spid.service;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import com.example.spid.entities.enums.Status;
import com.example.spid.exceptions.customExceptions.NoSpidsFoundException;
import com.example.spid.exceptions.customExceptions.NoUserFoundException;
import com.example.spid.repositories.SpidRepository;
import com.example.spid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpidService {
    @Autowired
    SpidRepository spidRepository;
    @Autowired
    UserRepository userRepository;

    public List<Spid> retrieveAllSpids() throws NoSpidsFoundException {
        if (spidRepository.findAll().isEmpty()) {
            throw new NoSpidsFoundException("There are no spids");
        }
        return spidRepository.findAll();
    }

    public Spid createSpid(Spid spid) throws Exception, NoUserFoundException {
        Long userId = spid.getUser().getId();
        if (userRepository.findById(userId).isEmpty()) {
            throw new NoUserFoundException("doesn't exist");
        }
        Optional<User> getUser = userRepository.findById(userId);
        spid.setUser(getUser.get());
        spid.setStatus(Status.PENDING);
        spid.setCreatedBy(getUser.get().getUsername());
        return spidRepository.save(spid);
    }

    public void deleteSpid(long id) throws Exception {
        Optional<Spid> findSpid = spidRepository.findById(id);
        if (findSpid.get().getStatus() != Status.PENDING) {
            throw new Exception("Spid must be deleted only if its status is pending");
        }
        spidRepository.delete(findSpid.get());
    }

    public Spid changeStatus(Long id) throws Exception {
        Optional<Spid> findSpid = spidRepository.findById(id);
        if (findSpid.get().getStatus().equals(Status.PENDING)) {
            findSpid.get().setStatus(Status.READY_FOR_REVIEW);
        } else throw new Exception("Status is already READY_FOR_REVIEW");
        return spidRepository.save(findSpid.get());
    }

    public List<Spid> searchSpids(String keyword){
        return spidRepository.searchSpid(keyword);
    }

}
