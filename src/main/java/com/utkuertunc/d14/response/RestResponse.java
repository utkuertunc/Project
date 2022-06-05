package com.utkuertunc.d14.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestResponse<T> {

    private String status = "200";

    private String message = "Success!";

    private T data;

    public RestResponse(T data) {
        this.data = data;
    }

    public RestResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
