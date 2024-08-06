# Banco de Dados e Views

Esta pasta contém o esquema do banco de dados e as consultas SQL para criar views específicas a partir das tabelas CLIENTE, PRODUTO, PEDIDO, ITEMPEDIDO, LOG e REQUISICAO_COMPRA.

## Esquema do Banco de Dados

- **CLIENTE** (codcliente, nome, datanascimento, cpf)
- **PRODUTO** (codproduto, descricao, quantidade)
- **PEDIDO** (codpedido, codcliente, datapedido, nf, valortotal)
- **ITEMPEDIDO** (codpedido, numeroitem, valorunitario, quantidade, codproduto)
- **LOG** (codlog, data, descricao)
- **REQUISICAO_COMPRA** (codrequisicaocompra, codproduto, data, quantidade, status)

## Consultas e Views

### Para Aquecer
1. Crie uma view que mostre o código do pedido e a data em que foram realizados.

### Aquecimento Finalizado
2. Crie uma view que apresente o código do pedido, o nome do cliente e o valor total do pedido.
3. Crie uma view que mostre o código do pedido, a descrição do produto, a quantidade vendida e o valor unitário.
4. Crie uma view que exiba o código do cliente, o nome, a idade (calculada a partir da data de nascimento) e o CPF formatado.
    - Obs1: Para essa questão adicione ou edite a coluna `cpf` com dados de CPF sem a pontuação.
    - Obs2: O CPF deve ser exibido no seguinte formato: 123.456.789-00
5. Crie uma view que apresente o código do pedido, a data, a descrição do produto, a quantidade e o valor total do item.
6. Crie uma view que apresente o código do pedido, a data, a descrição do produto, a quantidade e o valor total do item, ordenados pelo valor total do item de forma decrescente.
7. Crie uma view que mostre o código do cliente, o nome, a idade (calculada a partir da data de nascimento) e a quantidade total de pedidos feitos por cada cliente.
8. Crie uma view que exiba o código do produto, a descrição, a quantidade total vendida e o valor total das vendas de cada produto.
9. Crie uma view que exiba o código do cliente, o nome, a data do primeiro pedido realizado e a data do último pedido realizado.
10. Crie uma view que mostre o código do pedido, a data, a descrição do produto, a quantidade e o valor total do item, apenas para pedidos realizados no último mês.
11. Crie uma view que exiba o código do cliente, o nome, a quantidade total de produtos diferentes comprados e o valor total gasto por cada cliente.

## Atividade Acadêmica

Este repositório foi criado como parte de uma atividade acadêmica para a prática de criação de views utilizando o MySQL.

## Como Executar

Para executar essas consultas e views, você deve ter o MySQL instalado. Siga as instruções abaixo para configurar seu ambiente:

1. Crie o banco de dados e as tabelas conforme o esquema fornecido.
2. Insira os dados necessários nas tabelas.
3. Utilize um cliente MySQL, como MySQL Workbench, para executar as consultas e criar as views.

## Contribuição

Sinta-se à vontade para contribuir com melhorias nas consultas e views existentes. Envie um pull request com suas alterações.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
