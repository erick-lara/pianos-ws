package br.com.ericklara.pianosws.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "vl_name")
    private String name;
    @Column(name = "vl_document_number")
    private String cpf;
    @Column(name = "vl_password")
    private String password;
    @Column(name = "vl_email")
    private String email;
    @Column(name = "dh_registered")
    private Date registrationDate;

    public User() {
    }

    public User(Long idUser, String name, String cpf, String password, String email, Date registrationDate) {
        this.idUser = idUser;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    public static final class Builder {
        private String name;
        private String cpf;
        private String password;
        private String email;
        private Date registrationDate;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public User build() {
            User user = new User();
            user.setName(name);
            user.setCpf(cpf);
            user.setPassword(password);
            user.setEmail(email);
            user.setRegistrationDate(registrationDate);
            return user;
        }
    }
}
