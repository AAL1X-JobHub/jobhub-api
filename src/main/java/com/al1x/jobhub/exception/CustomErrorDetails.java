package com.al1x.jobhub.exception;

import lombok.Data;

@Data
public class CustomErrorDetails {
    private String title;
    private int status;
    private String detail;
}
