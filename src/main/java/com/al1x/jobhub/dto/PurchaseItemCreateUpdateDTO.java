package com.al1x.jobhub.dto;

import lombok.Data;

@Data
public class PurchaseItemCreateUpdateDTO {
    private Integer jobId;
    private Integer quantity;
    private Float price;
}
