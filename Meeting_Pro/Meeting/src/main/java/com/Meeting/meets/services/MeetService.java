// OrderItemService.java
package com.Meeting.meets.services;

import org.springframework.stereotype.Service;

import com.Meeting.meets.model.MeetData;
import com.Meeting.meets.repository.MeetRepository;

import java.util.List;

@Service
public class MeetService {
    private final MeetRepository orderItemRepository;

    public MeetService(MeetRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public MeetData createOrderItem(MeetData orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<MeetData> getOrderItemsByLoginId(int loginId) {
        return orderItemRepository.findByLoginId(loginId);
    }
}
