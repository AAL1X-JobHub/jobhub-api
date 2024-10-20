package com.al1x.jobhub.dto;

import lombok.Data;

@Data
public class PurchaseItemDTO {
    private Integer id;
    private Float price;
    private Integer quantity;
    private String bookTitle;
}