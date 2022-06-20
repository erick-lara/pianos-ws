package br.com.ericklara.pianosws.infra.configuration.handler;

import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailureHandler.class);

    protected void mapper(HttpServletResponse response, HttpStatus status) throws IOException {
        LOGGER.info("[FAILURE HANDLER] Acesso à endpoint negado. STATUS: {}", status.value());

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status.value());
        response.getWriter().write(
                mapper.writeValueAsString(
                        new DefaultResponse<>(
                                false,
                                "Acesso negado."
                        )
                )
        );
    }
}
