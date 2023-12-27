package com.example.DaherBackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * SaleItem is an entity class representing an item within a sale in the system.
 * It is mapped to the "sale_items" table in the database.
 */
@Entity
@Table(name = "sale_items")
@EntityListeners(AuditingEntityListener.class)
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @OneToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sale_id", nullable=false)
    private Sale sale;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "created_date", nullable = false)
    private Date creationDate;

    /**
     * Gets the unique identifier of the sale item.
     *
     * @return the sale item's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the sale item.
     *
     * @param id the sale item's ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the product associated with the sale item.
     *
     * @return the product object
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product associated with the sale item.
     *
     * @param product the product object
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the sale associated with the sale item.
     *
     * @return the sale object
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Sets the sale associated with the sale item.
     *
     * @param sale the sale object
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }

    /**
     * Gets the quantity of the product in the sale item.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the sale item.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the creation date of the sale item record.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the sale item record.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
