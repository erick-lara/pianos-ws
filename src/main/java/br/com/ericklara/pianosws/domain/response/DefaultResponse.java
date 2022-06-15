package br.com.ericklara.pianosws.domain.response;

public class DefaultResponse<T>{
    private final boolean success;
    private final T response;

    public DefaultResponse(boolean success, T response) {
        this.success = success;
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public boolean getSuccess() {
        return success;
    }

}
