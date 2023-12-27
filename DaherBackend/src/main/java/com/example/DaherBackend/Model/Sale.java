package com.example.DaherBackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Sale is an entity class representing a sale transaction in the system.
 * It is mapped to the "sales" table in the database.
 */
@Entity
@Table(name = "sales")
@EntityListeners(AuditingEntityListener.class)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @Column(name = "sellerName", nullable = false)
    private String sellerName;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToMany(mappedBy="sale", fetch = FetchType.LAZY)
    private List<SaleItem> saleItems = new ArrayList<SaleItem>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "created_date", nullable = false)
    private Date creationDate;

    /**
     * Gets the unique identifier of the sale.
     *
     * @return the sale's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the sale.
     *
     * @param id the sale's ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the client associated with the sale.
     *
     * @return the client object
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client associated with the sale.
     *
     * @param client the client object
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets the name of the seller for the sale.
     *
     * @return the seller's name
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * Sets the name of the seller for the sale.
     *
     * @param sellerName the seller's name
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * Gets the total amount of the sale.
     *
     * @return the total amount
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets the total amount of the sale.
     *
     * @param total the total amount
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Gets the list of sale items associated with the sale.
     *
     * @return the list of sale items
     */
    public List<SaleItem> getSaleItem() {
        return saleItems;
    }

    /**
     * Sets the list of sale items associated with the sale.
     *
     * @param saleItem the list of sale items
     */
    public void setSaleItem(List<SaleItem> saleItem) {
        this.saleItems = saleItem;
    }

    /**
     * Gets the creation date of the sale record.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the sale record.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
