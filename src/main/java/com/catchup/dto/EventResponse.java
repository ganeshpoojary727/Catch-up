package com.catchup.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EventResponse {

    private Long id;

    private String title;

    private String description;

    private String location;

    private LocalDate eventDate;

    private String category;

    private String imageUrl;

    private int interestedCount;

    private int goingCount;

    private int commentCount;

    private LocalDateTime createdAt;

    private UserResponse createdBy;
}