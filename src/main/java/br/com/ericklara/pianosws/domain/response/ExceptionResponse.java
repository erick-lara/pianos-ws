package br.com.ericklara.pianosws.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ExceptionResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String url;

    public ExceptionResponse(String message, String url) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.url = url;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }
}
