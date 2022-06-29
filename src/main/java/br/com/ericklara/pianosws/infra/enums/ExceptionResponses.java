package br.com.ericklara.pianosws.infra.enums;

public enum ExceptionResponses {
    NO_INSTANCE_ALLOWED("Classe utilitária não instanciável."),
    USER_NOT_FOUND("Usuário ou senha inválidos");

    private final String response;

    ExceptionResponses(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return response;
    }
}
