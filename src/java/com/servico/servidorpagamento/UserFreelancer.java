package com.servico.servidorpagamento; // Pacote onde a classe está localizada

import java.io.Serializable; // Importa Serializable para poder serializar objetos

// Classe UserFreelancer que implementa Serializable
public class UserFreelancer implements Serializable {
    // Atributos para armazenar as informações do freelancer
    private String nome; // Nome do freelancer
    private String cpf;  // CPF do freelancer
    private int horasTrabalhadas; // Total de horas trabalhadas pelo freelancer
    private final double salarioPorHora = 6.25; // Valor pago por hora
    private double salarioBruto; // Salário bruto calculado
    private double salarioLiquido; // Salário líquido após impostos
    private double impostos; // Valor total de impostos

    // Construtor da classe UserFreelancer
    public UserFreelancer(String nome, String cpf, int horasTrabalhadas) {
        this.nome = nome; // Guarda o nome
        this.cpf = cpf;   // Guarda o CPF
        this.horasTrabalhadas = horasTrabalhadas; // Guarda as horas trabalhadas
        calcularSalarioBruto(); // Chama o método para calcular o salário bruto
        calcularImpostos(); // Chama o método para calcular os impostos
        calcularSalarioLiquido(); // Chama o método para calcular o salário líquido
    }

    // Método para calcular o salário bruto
    private void calcularSalarioBruto() {
        salarioBruto = horasTrabalhadas * salarioPorHora; // Salário bruto = horas trabalhadas * valor por hora
    }

    // Método para calcular os impostos (exemplo de 10% do salário bruto)
    private double calcularImpostos() {
        impostos = salarioBruto * 0.10; // Calcula 10% de impostos sobre o salário bruto
        return impostos; // Retorna o valor dos impostos
    }

    // Método para calcular o salário líquido
    public double calcularSalarioLiquido() {
        salarioLiquido = salarioBruto - impostos; // Salário líquido = salário bruto - impostos
        return salarioLiquido; // Retorna o salário líquido calculado
    }

    // Getters para acessar as informações
    public String getNome() {
        return nome; // Retorna o nome do freelancer
    }

    public String getCpf() {
        return cpf; // Retorna o CPF do freelancer
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas; // Retorna as horas trabalhadas
    }

    public double getSalarioBruto() {
        return salarioBruto; // Retorna o salário bruto calculado
    }

    public double getSalarioLiquido() {
        return salarioLiquido; // Retorna o salário líquido calculado
    }

    public double getImpostos() {
        return impostos; // Retorna o valor dos impostos calculados
    }
}
