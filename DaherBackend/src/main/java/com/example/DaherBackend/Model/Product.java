package com.example.DaherBackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Product is an entity class representing a product in the system.
 * It is mapped to the "products" table in the database.
 */
@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "price", nullable = false)
    private double price;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "created_date", nullable = false)
    private Date creationDate;

    /**
     * Gets the unique identifier of the product.
     *
     * @return the product's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id the product's ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the product's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the product.
     *
     * @return the product's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the product's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the category of the product.
     *
     * @return the product's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category the product's category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price of the product.
     *
     * @return the product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the product's price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the creation date of the product record.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the product record.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets the ID of the product using a Long value.
     *
     * @param id the product's ID as a Long value
     */
    public void setId(Long id) {
        this.id = id;
    }
}
