package com.Meeting.meets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class MeetData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "meeting_name")
    private String MeetingName;

    @Column(name = "meeting_time")
    private String Meetingtime;
    
    @Column(name = "meeting_date")
    private String MeetingDate;

    // Other order details...

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;

    // Constructors, getters, setters
}
