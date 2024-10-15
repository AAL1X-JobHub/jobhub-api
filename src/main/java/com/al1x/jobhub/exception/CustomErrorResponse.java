package com.al1x.jobhub.exception;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private String title;
    private int status;
    private String details;
}
