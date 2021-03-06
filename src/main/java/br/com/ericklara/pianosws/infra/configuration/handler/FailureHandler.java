package br.com.ericklara.pianosws.infra.configuration.handler;

import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.domain.response.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailureHandler.class);
    private final ObjectMapper mapper = new ObjectMapper();

    protected void mapper(HttpServletResponse response, HttpServletRequest request, HttpStatus status) throws IOException {
        LOGGER.info("[FAILURE HANDLER] Acesso à endpoint [{}] negado. STATUS: {}",request.getRequestURL(), status.value());

        mapper.registerModule(new JavaTimeModule());
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status.value());
        response.getWriter().write(
                mapper.writeValueAsString(
                        new DefaultResponse<>(
                                false,
                                new ExceptionResponse(
                                        "Acesso negado.",
                                        request.getRequestURI()
                                )
                        )
                )
        );
    }
}
