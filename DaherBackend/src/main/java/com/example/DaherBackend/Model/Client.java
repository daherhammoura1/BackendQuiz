package com.example.DaherBackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Client is an entity class representing a client in the system.
 * It is mapped to the "clients" table in the database.
 */
@Entity
@Table(name = "clients")
@EntityListeners(AuditingEntityListener.class)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss")
    @Column(name = "created_date", nullable = false)
    private Date creationDate;

    /**
     * Gets the unique identifier of the client.
     *
     * @return the client's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the client.
     *
     * @param id the client's ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the client.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the client.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the client.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the client.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the mobile number of the client.
     *
     * @return the mobile number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile number of the client.
     *
     * @param mobile the mobile number
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the creation date of the client record.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the client record.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
