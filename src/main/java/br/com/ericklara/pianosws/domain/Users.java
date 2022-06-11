package br.com.ericklara.pianosws.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private Integer age;

    public Users() {
    }

    public Users(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Users(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
