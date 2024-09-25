package com.servico.servidorpagamento; // Pacote onde a classe UserAdm está

public class UserAdm {
    // Atributos que guardam informações do usuário
    private String nome; // Nome do usuário
    private String cpf;  // CPF do usuário

    // Construtor da classe UserAdm
    // Aqui a gente recebe o nome e o CPF e armazena
    public UserAdm(String nome, String cpf) {
        this.nome = nome; // Guarda o nome
        this.cpf = cpf;   // Guarda o CPF
    }

    // Método para pegar o nome do usuário
    public String getNome() {
        return nome; // Retorna o nome que está guardado
    }

    // Método para mudar o nome do usuário
    public void setNome(String nome) {
        this.nome = nome; // Atualiza o nome com o novo valor
    }

    // Método para pegar o CPF do usuário
    public String getCpf() {
        return cpf; // Retorna o CPF que está guardado
    }

    // Método para mudar o CPF do usuário
    public void setCpf(String cpf) {
        this.cpf = cpf; // Atualiza o CPF com o novo valor
    }
}
