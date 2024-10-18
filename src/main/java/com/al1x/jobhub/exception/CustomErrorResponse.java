package com.al1x.jobhub.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {
    private String title;
    private int status;
    private String details;
}