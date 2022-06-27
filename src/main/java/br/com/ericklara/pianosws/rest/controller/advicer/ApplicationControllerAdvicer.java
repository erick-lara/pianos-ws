package br.com.ericklara.pianosws.rest.controller.advicer;

import br.com.ericklara.pianosws.domain.exception.BusinessException;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.domain.response.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ApplicationControllerAdvicer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationControllerAdvicer.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<DefaultResponse<ExceptionResponse>> handleBusinessException(
            BusinessException exception, HttpServletRequest request
    ){
        LOGGER.info("[ADVICER] Tratando exceção: {} - URL: [{}]", exception.getMensagem(), request.getRequestURL());
        return ResponseEntity
                .status(exception.getStatus())
                .body(new DefaultResponse<>(
                        false,
                        new ExceptionResponse(
                                exception.getMensagem(),
                                request.getRequestURI()
                        )
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultResponse<ExceptionResponse>> handleBusinessException(
            HttpServletRequest request, Exception exception, HttpServletResponse response
    ){
        LOGGER.info("[ADVICER] Tratando uma exceção não mapeada: {} - URL: [{}]", exception.getMessage(), request.getRequestURL());
        return ResponseEntity
                .status(response.getStatus())
                .body(new DefaultResponse<>(
                        false,
                        new ExceptionResponse(
                                exception.getMessage(),
                                request.getRequestURI()
                        )
                ));
    }

}
