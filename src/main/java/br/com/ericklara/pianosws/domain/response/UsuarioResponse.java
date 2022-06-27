package br.com.ericklara.pianosws.domain.response;


public class UsuarioResponse {

    private Long idUser;
    private String name;
    private String cpf;
    private String email;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static final class Builder {
        private Long idUser;
        private String name;
        private String cpf;
        private String email;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withIdUser(Long idUser) {
            this.idUser = idUser;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsuarioResponse build() {
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setIdUser(idUser);
            usuarioResponse.setName(name);
            usuarioResponse.setCpf(cpf);
            usuarioResponse.setEmail(email);
            return usuarioResponse;
        }
    }
}
