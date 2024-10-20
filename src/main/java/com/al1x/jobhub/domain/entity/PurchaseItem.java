package com.al1x.jobhub.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_items")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float price;  // Precio del artículo

    @Column(name = "quantity", nullable = false)
    private Integer quantity;  // Cantidad del artículo comprado

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_purchase_item_job"))
    private Job job;  // Referencia al trabajo (job) que se está comprando

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_purchase_item_purchase"))
    private Purchase purchase;  // Referencia a la compra a la que pertenece este artículo

    public PurchaseItem() {}

    public PurchaseItem(Integer id) {
        this.id = id;
    }
}
