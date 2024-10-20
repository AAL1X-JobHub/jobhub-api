package com.al1x.jobhub.dto;

import lombok.Data;

@Data
public class PaymentCaptureResponse {
    private boolean completed;
    private Integer purchaseId;
}
