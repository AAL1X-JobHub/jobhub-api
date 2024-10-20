package com.al1x.jobhub.dto;

import com.al1x.jobhub.domain.entity.User;
import com.al1x.jobhub.domain.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDTO {
    private Integer id;
    private Float total;
    private LocalDateTime createdAt;
    private PaymentStatus paymentStatus;
    private String userName;
    private List<PurchaseItemDTO> items;
}
