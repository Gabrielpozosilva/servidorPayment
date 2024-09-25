package com.servico.servidorpagamento; // Pacote onde a classe está localizada

import java.io.Serializable; // Importa Serializable para permitir a serialização da classe

// Classe UserPj que implementa Serializable
public class UserPj implements Serializable {
    // Atributos para armazenar as informações da empresa
    private String nome; // Nome da empresa
    private String cnpj; // CNPJ da empresa
    private double valorProjeto; // Valor do projeto
    private double salarioFinal; // Salário final após impostos
    private double impostos; // Para calcular impostos se necessário

    // Construtor da classe UserPj
    public UserPj(String nome, String cnpj, double valorProjeto) {
        this.nome = nome; // Guarda o nome da empresa
        this.cnpj = cnpj; // Guarda o CNPJ
        this.valorProjeto = valorProjeto; // Guarda o valor do projeto
        calcularSalarioFinal(); // Chama o método para calcular o salário final
    }

    // Construtor não suportado (pode ser removido se não for necessário)
    UserPj(String nome, String cpf, int horasTrabalhadas, double salarioBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Gera uma exceção se este construtor for chamado
    }

    // Método para calcular o salário final
    private void calcularSalarioFinal() {
        // Aqui você pode adicionar a lógica para calcular os impostos, se necessário
        this.impostos = calcularImpostos(); // Chama o método para calcular os impostos
        this.salarioFinal = valorProjeto - impostos; // Salário final é o valor do projeto menos impostos
    }

    // Método para calcular impostos (exemplo de 10% do valor do projeto)
    private double calcularImpostos() {
        return valorProjeto * 0.10; // Exemplo: 10% do valor do projeto
    }

    // Getters para acessar as informações
    public String getNome() {
        return nome; // Retorna o nome da empresa
    }

    public String getCnpj() {
        return cnpj; // Retorna o CNPJ da empresa
    }

    public double getValorProjeto() {
        return valorProjeto; // Retorna o valor do projeto
    }

    public double getSalarioFinal() {
        return salarioFinal; // Retorna o salário final calculado
    }

    public double getImpostos() {
        return impostos; // Retorna os impostos calculados
    }
}
