package com.catchup.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateEventRequest {

    private String title;

    private String description;

    private String location;

    private LocalDate eventDate;

    private String category;

    private String imageUrl;
}