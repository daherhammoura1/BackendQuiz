package com.example.DaherBackend.Exception;

import java.util.Date;

/**
 * Represents the structure of an error response to be sent in case of exceptions.
 */
public class ErrorResponse {

    // Timestamp indicating when the error occurred
    private Date timestamp;

    // Details about the error
    private String details;

    /**
     * Constructs an instance of ErrorResponse.
     *
     * @param timestamp Timestamp indicating when the error occurred
     * @param details   Details about the error
     */
    public ErrorResponse(Date timestamp, String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    /**
     * Gets the timestamp of the error.
     *
     * @return The timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the error.
     *
     * @param timestamp The timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the details of the error.
     *
     * @return The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the details of the error.
     *
     * @param details The details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
