package br.com.ericklara.pianosws.domain.exception;

import java.util.List;

public class Errors {

    private final List<String> advices;

    public Errors(List<String> advices) {
        this.advices = advices;
    }

    public List<String> getAdvices() {
        return advices;
    }
}
