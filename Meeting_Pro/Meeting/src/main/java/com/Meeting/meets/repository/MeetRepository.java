// OrderItemRepository.java
package com.Meeting.meets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Meeting.meets.model.MeetData;

import java.util.List;

@Repository
public interface MeetRepository extends JpaRepository<MeetData, Integer> {
    List<MeetData> findByLoginId(int loginId);
}
