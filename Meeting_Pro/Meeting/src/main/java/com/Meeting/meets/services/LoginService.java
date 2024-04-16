package com.Meeting.meets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Meeting.meets.model.Login;
import com.Meeting.meets.repository.LoginRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepo repo;

    public Login createLogin(Login login) {
        return repo.save(login);
    }
    public List<Login> getAllLogins() {
        return repo.findAll();
    }

    public Page<Login> getAllLogin(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return repo.findAll(pageable);
    }

    public Optional<Login> getLoginById(Integer loginId) {
        return repo.findById(loginId);
    }

    public Login updateLogin(Login login) {
        return repo.save(login);
    }

    public void deleteLogin(Integer loginId) {
        repo.deleteById(loginId);
    }
    
    // Custom method to retrieve login details by name
    public List<Login> getLoginByName(String name) {
        return repo.findByName(name);
    }
    
    // Custom method to retrieve login details by username
    public List<Login> getLoginByUsername(String username) {
        return repo.findByUsername(username);
    }
}
