package com.servico.servidorpagamento; // Pacote onde a classe está localizada

import javax.jws.WebServices; // Importa WebServices para definir a classe como um serviço web
import javax.jws.WebMethod; // Importa WebMethod para definir os métodos do serviço web
import javax.jws.WebParam; // Importa WebParam para definir parâmetros de entrada
import javax.jws.WebService; // Importa WebService para anotar a classe como um serviço web

@WebService(serviceName = "ServidorPagamento") // Define a classe como um serviço web com o nome "ServidorPagamento"
public class ServidorPagamento {

    // Método para gerar a folha de pagamento de um funcionário CLT
    @WebMethod(operationName = "gerarFolhaPagamentoClt")
    public String gerarFolhaPagamentoClt(
            @WebParam(name = "nome") String nome, // Parâmetro nome
            @WebParam(name = "cpf") String cpf, // Parâmetro CPF
            @WebParam(name = "horasTrabalhadas") int horasTrabalhadas, // Parâmetro horas trabalhadas
            @WebParam(name = "salarioBase") double salarioBase) { // Parâmetro salário base

        // Cria uma instância de UserClt com os dados fornecidos
        UserClt userClt = new UserClt(nome, cpf, horasTrabalhadas, salarioBase);

        // Calcula o salário líquido
        double salarioCalculado = userClt.calcularSalarioLiquido();

        // Formata o salário para duas casas decimais
        String salarioFormatado = String.format("%.2f", salarioCalculado);
        return salarioFormatado; // Retorna o salário líquido formatado
    }

    // Método para gerar a folha de pagamento de um freelancer
    @WebMethod(operationName = "gerarFolhaPagamentoFreelancer")
    public String gerarFolhaPagamentoFreelancer(
            @WebParam(name = "nome") String nome, // Parâmetro nome
            @WebParam(name = "cpf") String cpf, // Parâmetro CPF
            @WebParam(name = "horasTrabalhadas") int horasTrabalhadas) { // Parâmetro horas trabalhadas

        // Cria uma instância de UserFreelancer
        UserFreelancer userFreelancer = new UserFreelancer(nome, cpf, horasTrabalhadas);

        // Calcula o salário líquido
        double salarioCalculadoFreelancer = userFreelancer.calcularSalarioLiquido();

        // Formata o salário para duas casas decimais
        String salarioFormatado = String.format("%.2f", salarioCalculadoFreelancer);
        return salarioFormatado; // Retorna o salário líquido formatado
    }

    // Método para gerar a folha de pagamento de um funcionário PJ
    @WebMethod(operationName = "gerarFolhaPagamentoPj")
    public String gerarFolhaPagamentoPj(
            @WebParam(name = "nome") String nome, // Parâmetro nome
            @WebParam(name = "cpf") String cpf, // Parâmetro CPF (pode ser CNPJ em casos de PJ)
            @WebParam(name = "horasTrabalhadas") int horasTrabalhadas, // Parâmetro horas trabalhadas
            @WebParam(name = "salarioBase") double salarioBase) { // Parâmetro salário base

        // Cria uma instância de UserPj com os dados fornecidos
        UserPj userPj = new UserPj(nome, cpf, horasTrabalhadas, salarioBase);

        // Calcula o salário líquido
        double salarioCalculado = userPj.calcularSalarioLiquido();

        // Formata o salário para duas casas decimais
        String salarioFormatado = String.format("%.2f", salarioCalculado);
        return salarioFormatado; // Retorna o salário líquido formatado
    }

    // Método não suportado (pode ser removido se não for necessário)
    String gerarFolhaPagamentoPj(String nome, String cpfCnpj, int horasTrabalhadas, double salarioBase, double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Gera uma exceção se este método for chamado
    }
}
