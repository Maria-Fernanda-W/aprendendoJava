package model;

import java.util.Arrays;

public class Contato {
    String nome;
    //int[] telefone;
    String telefone;
    //String[] email;
    String email;
    Endereco endereco;

//    public Contato(String nome, int telefone) {
//        this.nome = nome;
//        this.telefone = telefone;
//    }

//    public Contato(String nome, int[] telefone, String[] email) {
//        this.nome = nome;
//        this.telefone = telefone;
//        this.email = email;
//    }

    public Contato(String nome, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", email=" + email +
                ", endereco=" + endereco +
                '}';
    }
}
