package com.example.SkyLine.service;
// UserService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.SkyLine.model.User;
import com.example.SkyLine.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById1(int userId) throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new NotFoundException();
        }
    }

    public List<User> getchild(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return userRepository.findAll(sort);
    }

    public List<User> gettchild(int offset, int pagesize) {
        Pageable page = PageRequest.of(offset,pagesize);
        return userRepository.findAll(page).getContent();
    }

    public List<User> getttchild(int offset, int pagesize, String field) {
        return userRepository.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }

    


}
