package br.com.ericklara.pianosws.domain.exception;

import br.com.ericklara.pianosws.infra.enums.ExceptionType;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    private String mensagem;
    private HttpStatus status;

    public BusinessException(String mensagem, HttpStatus status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public BusinessException(ExceptionType mensagem, HttpStatus status) {
        this.mensagem = mensagem.toString();
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
