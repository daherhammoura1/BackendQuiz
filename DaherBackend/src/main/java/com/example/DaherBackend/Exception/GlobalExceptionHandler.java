package com.example.DaherBackend.Exception;

import com.example.DaherBackend.Response.CustomResponse;
import com.example.DaherBackend.Response.CustomResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * GlobalExceptionHandler is a centralized exception handler for handling specific exceptions
 * and providing custom responses for them.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ResourceNotFoundException and returns a custom response with a NOT_FOUND status.
     *
     * @param ex      The ResourceNotFoundException
     * @param request The web request
     * @return ResponseEntity containing the custom error response and NOT_FOUND status
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), request.getDescription(false));
        CustomResponse<ErrorResponse> stringCustomResponse =
                new CustomResponse<>(errorDetails, CustomResponseStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(stringCustomResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles general exceptions and returns a custom response with an INTERNAL_SERVER_ERROR status.
     *
     * @param ex      The Exception
     * @param request The web request
     * @return ResponseEntity containing the custom error response and INTERNAL_SERVER_ERROR status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), request.getDescription(false));
        CustomResponse<ErrorResponse> stringCustomResponse =
                new CustomResponse<>(errorDetails, CustomResponseStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(stringCustomResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
