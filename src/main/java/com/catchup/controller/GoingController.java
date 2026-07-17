package com.catchup.controller;

import com.catchup.entity.Event;
import com.catchup.service.GoingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class GoingController {

    private final GoingService goingService;

    @PostMapping("/{eventId}/going")
    public String markGoing(@PathVariable Long eventId) {

        goingService.markGoing(eventId);

        return "Marked as Going";
    }

    @GetMapping("/going")
    public List<Event> getMyGoingEvents() {

        return goingService.getMyGoingEvents();
    }
    @DeleteMapping("/{eventId}/going")
    public ResponseEntity<String> removeGoing(
            @PathVariable Long eventId) {

        goingService.removeGoing(eventId);

        return ResponseEntity.ok("Going Removed");
    }
}