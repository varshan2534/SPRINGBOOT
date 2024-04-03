package com.java.meets.service;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.meets.model.Meet;
import com.java.meets.repository.MeetRepo;

@Service
public class MeetService {
    private final MeetRepo meetRepo;
    
    // @Autowired
    public MeetService(MeetRepo meetRepo){
        this.meetRepo = meetRepo;
    }

    public Meet addMeet(Meet meet){
        return meetRepo.save(meet);
    }

    public List<Meet> getAllMeets(){
        return meetRepo.findAll();
    }

    public Meet getMeetById(Integer id){
        return meetRepo.findById(id).orElse(null);
    }

    public void deleteMeetById(Integer id) {
        meetRepo.deleteById(id);
    }
}
