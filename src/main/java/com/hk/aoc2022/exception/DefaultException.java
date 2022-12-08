package com.hk.aoc2022.exception;

import lombok.Data;
import org.springframework.http.HttpStatusCode;
@Data
public class DefaultException extends Exception {
    HttpStatusCode code;

    public DefaultException(HttpStatusCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}
