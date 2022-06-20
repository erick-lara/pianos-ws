package br.com.ericklara.pianosws.rest.controller.advicer;

import br.com.ericklara.pianosws.domain.exception.BusinessException;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApplicationControllerAdvicer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationControllerAdvicer.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<DefaultResponse<String>> handleBusinessException(BusinessException exception){
        LOGGER.info("[ADVICER] Tratando exceção: {}", exception.getMensagem());
        return ResponseEntity
                .status(exception.getStatus())
                .body(new DefaultResponse<>(
                        false,
                        exception.getMensagem()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultResponse<String>> handleBusinessException(Exception exception){
        LOGGER.info("[ADVICER] Tratando uma exceção não mapeada: {}", exception.getMessage());
        return ResponseEntity
                .status(512)
                .body(new DefaultResponse<>(
                        false,
                        exception.getMessage()
                ));
    }

}