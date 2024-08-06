# Banco de Dados e Triggers

Esta pasta contém o esquema do banco de dados e as consultas SQL para criar e manipular o banco de dados, além de triggers para diversas operações. O esquema é composto pelas tabelas CLIENTE, PRODUTO, PEDIDO, ITEMPEDIDO, LOG, e REQUISICAO_COMPRA.

## Esquema do Banco de Dados

- **CLIENTE** (codcliente, nome, datanascimento, cpf)
- **PRODUTO** (codproduto, descricao, quantidade)
- **PEDIDO** (codpedido, codcliente, datapedido, nf, valortotal)
- **ITEMPEDIDO** (codpedido, numeroitem, valorunitario, quantidade, codproduto)
- **LOG** (codlog, data, descricao)
- **REQUISICAO_COMPRA** (codrequisicaocompra, codproduto, data, quantidade, status)

## Inserções Mínimas

Adicione no mínimo 5 registros em cada tabela:
- 5 clientes
- 5 produtos
- 5 pedidos (cada pedido com pelo menos 1 item de pedido)

## Consultas e Triggers

1. Crie um TRIGGER para baixar o estoque de um PRODUTO quando ele for vendido.
2. Crie um TRIGGER para criar um log dos CLIENTES modificados. 
    - Quando um novo cliente for inserido, a descrição do LOG deve ser “Inserindo novo cliente-CPF_DO_CLIENTE”
    - Quando um cliente for excluído, a descrição do LOG deve ser “Excluindo cliente-CPF_DO_CLIENTE”
3. Crie um TRIGGER para criar um log dos PRODUTOS atualizados (similar ao exercício 2).
4. Crie um TRIGGER para criar um log quando não existir a quantidade do ITEMPEDIDO em estoque.
5. Crie um TRIGGER para criar uma requisição de REQUISICAO_COMPRA quando o estoque atingir 50% da venda mensal.
6. Crie um TRIGGER para criar um log quando um ITEMPEDIDO for removido.
7. Crie um TRIGGER para criar um LOG quando o valor total do pedido for maior que R$ 1.000,00.
8. Crie um TRIGGER que NÃO permita que uma PESSOA com data de nascimento posterior à data de hoje seja inserida ou atualizada.
9. Crie um TRIGGER para acrescentar a palavra "Sr(a)" ao nome das PESSOAS que nasceram há mais de 30 anos ao serem registradas no banco de dados.
10. Crie um TRIGGER que ajuste os pedidos de compra para que não existam itens repetidos, ou seja, quando o mesmo ITEMPEDIDO for inserido deve-se disparar uma mensagem.
11. Crie um TRIGGER que exiba uma mensagem informando que o valor do pedido excedeu R$ 100.000,00.
12. Crie um TRIGGER que é executada quando o status de uma requisição for alterado para “Concluída” e exiba uma mensagem informando que o estoque precisa ser reabastecido caso a quantidade atual do estoque continue abaixo de 50% da venda mensal.

## Como Executar

Para executar essas consultas e triggers, você deve ter o MySQL instalado. Siga as instruções abaixo para configurar seu ambiente:

1. Crie o banco de dados e as tabelas conforme o esquema fornecido.
2. Insira pelo menos 5 registros em cada tabela.
3. Utilize um cliente MySQL, como MySQL Workbench, para executar as consultas e criar os triggers.

## Atividade Acadêmica

Este repositório foi criado como parte de uma atividade acadêmica para a prática de criação e manipulação de bancos de dados, além da implementação de triggers utilizando o MySQL.

## Contribuição

Sinta-se à vontade para contribuir com melhorias nas consultas e triggers existentes. Envie um pull request com suas alterações.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
