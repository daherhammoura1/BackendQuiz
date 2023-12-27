package com.example.DaherBackend.Response;

/**
 * CustomResponseHelper is a utility class providing methods to create success and failure responses.
 * It helps in creating instances of CustomResponse with predefined success or failure status.
 *
 * @param <T> the type of data in the response
 */
public class CustomResponseHelper<T> {

    /**
     * Creates a success response with the provided data.
     *
     * @param t the data to be included in the success response
     * @param <T> the type of data in the response
     * @return a CustomResponse with success status and the provided data
     */
    public static <T> CustomResponse<T> successResponse(T t){
        return new CustomResponse<>(t, CustomResponseStatus.SUCCESS, "");
    }

    /**
     * Creates a failure response with the provided message.
     *
     * @param msg a message providing additional information about the failure
     * @param <T> the type of data in the response
     * @return a CustomResponse with failure status and a message
     */
    public static <T> CustomResponse<T> failureResponse(String msg){
        return new CustomResponse<>(null, CustomResponseStatus.FAILURE, msg);
    }
}
