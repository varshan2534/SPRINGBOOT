package com.java.meets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.meets.model.Meet;

@Repository
public interface MeetRepo extends JpaRepository<Meet, Integer> {

}
