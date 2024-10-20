package com.al1x.jobhub.domain.entity;

import com.al1x.jobhub.domain.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float total;  // Total de la compra
    private LocalDateTime createdAt;  // Fecha y hora de la compra

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_purchase_user"))
    private User user;  // Usuario que realizó la compra

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseItem> items;  // Lista de artículos en la compra

    public Purchase() {}

    public Purchase(Integer id) {
        this.id = id;
    }
}