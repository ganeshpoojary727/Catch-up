package com.catchup.controller;

import com.catchup.entity.Event;
import com.catchup.service.InterestedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class InterestedController {

    private final InterestedService interestedService;

    @PostMapping("/{eventId}/interested")
    public String markInterested(@PathVariable Long eventId) {

        interestedService.markInterested(eventId);

        return "Marked as Interested";
    }

    @GetMapping("/interested")
    public List<Event> getMyInterestedEvents() {

        return interestedService.getMyInterestedEvents();

    }
    @DeleteMapping("/{eventId}/interested")
    public ResponseEntity<String> removeInterested(
            @PathVariable Long eventId) {

        interestedService.removeInterested(eventId);

        return ResponseEntity.ok("Interest Removed");
    }

}