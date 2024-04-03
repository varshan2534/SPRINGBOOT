package com.java.meets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.meets.model.Meet;
import com.java.meets.service.MeetService;

@RestController
@RequestMapping("/api/meets")
public class MeetController {
    @Autowired
    private MeetService meetService;

    @PostMapping
    public ResponseEntity<Meet> addMeet(@RequestBody Meet meet) {
        Meet addedMeet = meetService.addMeet(meet);
        if (addedMeet != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedMeet);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping
    public ResponseEntity<List<Meet>> getAllMeets() {
        List<Meet> meets = meetService.getAllMeets();
        if (meets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(meets);
    }

    @GetMapping("/{meetId}")
    public ResponseEntity<Meet> getMeetById(@PathVariable Integer meetId) {
        Meet meet = meetService.getMeetById(meetId);
        if (meet != null) {
            return ResponseEntity.ok(meet);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{meetId}")
    public ResponseEntity<Void> deleteMeetById(@PathVariable Integer meetId) {
        if (meetService.getMeetById(meetId) != null) {
            meetService.deleteMeetById(meetId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
