package com.al1x.jobhub.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDetailsDTO {
    private LocalDate dateCreated;
    private JobDetailsDTO job;
}