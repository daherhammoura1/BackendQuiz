package com.example.DaherBackend.Response;

/**
 * CustomResponse is a generic class representing the response format used in the API.
 * It contains data, status, and message information.
 *
 * @param <T> the type of data in the response
 */
public class CustomResponse<T> {

    private T data;

    private CustomResponseStatus status;

    private String message;

    /**
     * Constructs a CustomResponse with the provided data, status, and message.
     *
     * @param data    the data to be included in the response
     * @param status  the status of the response (e.g., SUCCESS, FAILURE)
     * @param message a message providing additional information about the response
     */
    public CustomResponse(T data, CustomResponseStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    /**
     * Gets the data included in the response.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data to be included in the response.
     *
     * @param data the data to be set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the status of the response.
     *
     * @return the response status
     */
    public CustomResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the response.
     *
     * @param status the response status to be set
     */
    public void setStatus(CustomResponseStatus status) {
        this.status = status;
    }

    /**
     * Gets the message providing additional information about the response.
     *
     * @return the response message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message providing additional information about the response.
     *
     * @param message the response message to be set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
