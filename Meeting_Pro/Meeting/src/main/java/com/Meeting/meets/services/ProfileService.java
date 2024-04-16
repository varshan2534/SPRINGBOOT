package com.Meeting.meets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Meeting.meets.model.Profile;
import com.Meeting.meets.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfileByLoginId(int loginId) {
        return profileRepository.findByLoginId(loginId);
    }
}
