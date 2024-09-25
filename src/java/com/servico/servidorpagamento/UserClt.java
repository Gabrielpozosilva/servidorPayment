package com.servico.servidorpagamento; // Pacote onde a classe está localizada

import java.io.Serializable; // Importa Serializable para poder serializar objetos

// Classe UserClt que herda de UserAdm e implementa Serializable
public class UserClt extends UserAdm implements Serializable {
    // Atributos que guardam informações específicas do funcionário CLT
    private String nome; // Nome do funcionário
    private String cpf;  // CPF do funcionário
    private int horasTrabalhadas; // Total de horas trabalhadas no mês
    private double salarioBase; // Salário base do funcionário
    private double salarioBruto; // Salário bruto (antes de descontos)
    private double salarioLiquido; // Salário líquido (após descontos)
    private double inss; // Valor do desconto do INSS
    private final double valorHoraExtra = 6.25; // Valor da hora extra

    // Construtor da classe UserClt
    // Aqui recebemos os dados do funcionário e inicializamos os atributos
    public UserClt(String nome, String cpf, int horasTrabalhadas, double salarioBase) {
        super(nome, cpf); // Chama o construtor da classe pai UserAdm
        this.nome = nome; // Guarda o nome
        this.cpf = cpf;   // Guarda o CPF
        this.horasTrabalhadas = horasTrabalhadas; // Guarda as horas trabalhadas
        this.salarioBase = salarioBase; // Inicializa o salário base
        calcularSalarioBruto(); // Chama o método para calcular o salário bruto
        calcularINSS(); // Chama o método para calcular o INSS
        calcularSalarioLiquido(); // Chama o método para calcular o salário líquido
    }

    // Método para calcular o salário bruto (inclui horas extras se necessário)
    public double calcularSalarioBruto() {
        if (horasTrabalhadas > 160) { // Se trabalhou mais de 160 horas
            int horasExtras = horasTrabalhadas - 160; // Calcula horas extras
            salarioBruto = salarioBase + (horasExtras * valorHoraExtra); // Adiciona ao salário base
        } else {
            salarioBruto = salarioBase; // Se não, só retorna o salário base
        }
        return salarioBruto; // Retorna o salário bruto calculado
    }

    // Método para calcular o INSS
    public double calcularINSS() {
        // Verifica o salário bruto e calcula o INSS baseado nas faixas
        if (salarioBruto >= 1609) {
            inss = salarioBruto * 0.11; // 11% para salários >= 1609
        } else if (salarioBruto < 965) {
            inss = salarioBruto * 0.08; // 8% para salários < 965
        } else {
            inss = 0.0; // Nenhum desconto para salários entre 965 e 1609
        }
        return inss; // Retorna o valor do INSS calculado
    }

    // Método para calcular o salário líquido (salário bruto - INSS)
    public double calcularSalarioLiquido() {
        salarioLiquido = salarioBruto - inss; // Salário líquido = salário bruto - INSS
        return salarioLiquido; // Retorna o salário líquido calculado
    }

    // Getters para acessar os atributos
    public String getNome() {
        return nome; // Retorna o nome do funcionário
    }

    public String getCpf() {
        return cpf; // Retorna o CPF do funcionário
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas; // Retorna as horas trabalhadas
    }

    public double getSalarioBruto() {
        return salarioBruto; // Retorna o salário bruto
    }

    public double getSalarioLiquido() {
        return salarioLiquido; // Retorna o salário líquido
    }

    public double getInss() {
        return inss; // Retorna o valor do INSS
    }

    public double getValorHoraExtra() {
        return valorHoraExtra; // Retorna o valor da hora extra
    }

    // O salário final é o salário líquido após todos os cálculos
    public double getSalarioFinal() {
        return salarioLiquido; // Retorna o salário líquido final
    }
}
