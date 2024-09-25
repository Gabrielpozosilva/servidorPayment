<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Pagamento</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Formulário de Pagamento</h1>
    <form action="PagamentoServlet" method="post">
        <label for="tipoUsuario">Tipo de Usuário:</label>
        <select name="tipoUsuario" id="tipoUsuario" required>
            <option value="clt">CLT</option>
            <option value="freelancer">Freelancer</option>
            <option value="pj">PJ</option>
        </select>
        
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" required>
        
        <label for="cpfCnpj">CPF/CNPJ:</label>
        <input type="text" name="cpfCnpj" id="cpfCnpj" required>
        
        <label for="horasTrabalhadas">Horas Trabalhadas:</label>
        <input type="number" name="horasTrabalhadas" id="horasTrabalhadas" required>
        
        <label for="salarioBase">Salário Base (somente para CLT e PJ):</label>
        <input type="number" step="0.01" name="salarioBase" id="salarioBase">
        
        <input type="submit" value="Calcular Pagamento">
        
        
    </form>
</body>
</html>
