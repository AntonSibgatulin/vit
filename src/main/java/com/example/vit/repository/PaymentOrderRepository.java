package com.example.vit.repository;

import com.example.vit.entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {
    PaymentOrder getPaymentOrderByNumber(Integer number);
}
