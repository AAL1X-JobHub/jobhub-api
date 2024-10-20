package com.al1x.jobhub.service;

import com.al1x.jobhub.dto.PaymentCaptureResponse;
import com.al1x.jobhub.dto.PaymentOrderResponse;

import jakarta.mail.MessagingException;

public interface CheckoutService {
    PaymentOrderResponse createPayment(Integer purchaseId, String returnUrl, String cancelUrl) throws MessagingException;
    PaymentCaptureResponse capturePayment(String orderId) throws MessagingException;
}