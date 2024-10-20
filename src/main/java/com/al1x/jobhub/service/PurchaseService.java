package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.PurchaseCreateUpdateDTO;
import com.al1x.jobhub.dto.PurchaseDTO;
import com.al1x.jobhub.dto.PurchaseReportDTO;

import java.util.List;

public interface PurchaseService {
    PurchaseDTO createPurchase(PurchaseCreateUpdateDTO purchaseDTO);
    //List<PurchaseDTO> getPurchaseHistoryByUserId(Integer userId);
    List<PurchaseDTO> getPurchaseHistoryByUserId();

    List<PurchaseReportDTO> getPurchaseReportByDate();

    List<PurchaseDTO> getAllPurchases();
    PurchaseDTO confirmPurchase(Integer purchaseId);
    PurchaseDTO getPurchaseById(Integer id);
}
